package org.dbpopulate.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import org.apache.http.Consts;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.DnsResolver;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.codecs.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.nio.codecs.DefaultHttpResponseParserFactory;
import org.apache.http.impl.nio.conn.ManagedNHttpClientConnectionFactory;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.NHttpMessageParserFactory;
import org.apache.http.nio.NHttpMessageWriterFactory;
import org.apache.http.nio.conn.ManagedNHttpClientConnection;
import org.apache.http.nio.conn.NHttpConnectionFactory;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.util.HeapByteBufferAllocator;
import org.dbpopulate.entity.ControllerIdDictionary;

public class RestClient {

	private static final String URL = "https://smarterroads.org/dataset/download/20?token=PlmhXEbQfnEG6bLQzRFDMMzW1RTvoThdL2NiZgPHRtckW7b7LrYqVL3d3VsTIs0Y&api=true&ctlr=";
	private static final String DUM = "https://www.google.com";
	private static final int SIZE = 100;

	public void exchange() throws Exception {

		// Create I/O reactor configuration
		IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
				.setIoThreadCount(Runtime.getRuntime().availableProcessors()).setConnectTimeout(30000)
				.setSoTimeout(30000).build();

		// Create a custom I/O reactort
		ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);

		// Use custom DNS resolver to override the system DNS resolution.
		DnsResolver dnsResolver = new SystemDefaultDnsResolver() {

			@Override
			public InetAddress[] resolve(final String host) throws UnknownHostException {
				if (host.equalsIgnoreCase("myhost")) {
					return new InetAddress[] { InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 }) };
				} else {
					return super.resolve(host);
				}
			}

		};

		NHttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();
		NHttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory();
		NHttpConnectionFactory<ManagedNHttpClientConnection> connFactory = new ManagedNHttpClientConnectionFactory(
				requestWriterFactory, responseParserFactory, HeapByteBufferAllocator.INSTANCE);

		// Create a connection manager with custom configuration.
		PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor,
				connFactory, dnsResolver);

		// Create message constraints
		MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
				.setMaxLineLength(2000).build();
		// Create connection configuration
		ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE)
				.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
				.setMessageConstraints(messageConstraints).build();
		// Configure the connection manager to use connection configuration either
		// by default or for a specific host.
		connManager.setDefaultConnectionConfig(connectionConfig);

		// Configure total max or per route limits for persistent connections
		// that can be kept in the pool or leased by the connection manager.
		connManager.setMaxTotal(200);
		connManager.setDefaultMaxPerRoute(100);

		CloseableHttpAsyncClient client = HttpAsyncClients.custom().setConnectionManager(connManager).build();
		client.start();

		List<String> controllerIds = ControllerIdDictionary.getIds();
		List<String> urls = new ArrayList<>();

		for (String id : controllerIds) {
			urls.add(URL + id);
		}

		final CyclicBarrier gate = new CyclicBarrier(SIZE + 1);
		GetThread[] threads = new GetThread[SIZE];
		for (int i = 0; i < threads.length; i++) {
			HttpGet request = new HttpGet(urls.get(i));
			// HttpGet request = new HttpGet(DUM);
			threads[i] = new GetThread(client, request, gate, controllerIds.get(i));
		}

		for (GetThread thread : threads) {
			thread.start();
		}
		gate.await();
		System.out.println("Starting threads");
		for (GetThread thread : threads) {
			thread.join();
		}
	}
}
