package org.dbpopulate.client;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.protocol.HttpContext;

 class GetThread extends Thread {
	    private CloseableHttpAsyncClient client;
	    private HttpContext context;
	    private HttpGet request;
	    private String id;
	 
	    public GetThread(CloseableHttpAsyncClient client,HttpGet req, String id){
	        this.client = client;
	        context = HttpClientContext.create();
	        this.request = req;
	        this.id = id;
	    }
	 
	    @Override
	    public void run() {
	        try {
	            Future<HttpResponse> future = client.execute(request, context, null);
	            HttpResponse response = future.get();
	            System.out.print(id+",");
	        } catch (Exception ex) {
	            System.out.println(ex.getLocalizedMessage());
	        }
	    }
	}
