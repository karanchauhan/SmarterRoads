package org.dbpopulate.service;

import java.io.IOException;

import org.dbpopulate.entity.ControllerData;
import org.dbpopulate.repository.SampleDAO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SmarterRoadsService {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SampleDAO sampleDAO;
	
	@Autowired
	private ObjectMapper mapper;

	private String exchange="exchange";

	private String routingkey = "key";

	public void send(ControllerData data) {
		String dataJson = null;
		try {
		 dataJson = mapper.writeValueAsString(data);
		} catch (IOException e) {
			System.out.println("Failed to read data as json");
			e.printStackTrace();
		}
		sampleDAO.save(data);
		//rabbitTemplate.convertAndSend(exchange, routingkey, dataJson);
		System.out.println("Sent msg = " + data.toString());
	}
	
	public void getData() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:8080/spring-rest/foos";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
	}
}
