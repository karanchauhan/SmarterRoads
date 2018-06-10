package org.dbpopulate.client;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.protocol.HttpContext;

class GetThread extends Thread {
	private CloseableHttpAsyncClient client;
	private CyclicBarrier gate;
	private HttpContext context;
	private HttpGet request;
	private String id;

	public GetThread(CloseableHttpAsyncClient client, HttpGet req, CyclicBarrier gate, String id) {
		this.client = client;
		context = HttpClientContext.create();
		this.request = req;
		this.id = id;
		this.gate = gate;
	}

	@Override
	public void run() {
		try {
			int i = 0;
			gate.await();
			while (i < 5) {
				Future<HttpResponse> future = client.execute(request, context, null);
				HttpResponse response = future.get();
				System.out.println(id + ":" + i++ + " ,");
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
}
