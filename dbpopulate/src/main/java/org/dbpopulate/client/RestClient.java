package org.dbpopulate.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.dbpopulate.entity.ControllerIdDictionary;

public class RestClient {

	private static final String URL = "https://smarterroads.org/dataset/download/20?token=PlmhXEbQfnEG6bLQzRFDMMzW1RTvoThdL2NiZgPHRtckW7b7LrYqVL3d3VsTIs0Y&api=true&ctlr=";
	private static final int SIZE = 50;

	public void exchange() throws Exception {
		ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
		PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
		CloseableHttpAsyncClient client = HttpAsyncClients.custom().setConnectionManager(cm).build();
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
