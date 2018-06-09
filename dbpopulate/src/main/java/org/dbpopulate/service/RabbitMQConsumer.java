//package org.dbpopulate.service;
//
//import java.io.IOException;
//
//import org.dbpopulate.entity.ControllerData;
//import org.dbpopulate.repository.SampleDAO;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
// 
//@Component
//public class RabbitMQConsumer {
// 
//	@Autowired 
//	ObjectMapper objectMapper;
//	
//	@Autowired
//	SampleDAO sampleDAO;
//	
//	
//	@RabbitListener(queues="queue")
//    public void receivedMessage(String msg) {
//		//TODO: Call multiple repositories
//		try {
//			ControllerData data = objectMapper.readValue(msg, ControllerData.class);
//			sampleDAO.save(data);
//		} catch (IOException e) {
//			System.out.println("Failed to read message");
//			e.printStackTrace();
//		}
//        System.out.println("Recieved Message: " + msg);
//    }
//	
//}