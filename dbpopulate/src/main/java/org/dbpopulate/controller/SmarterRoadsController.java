package org.dbpopulate.controller;

import org.dbpopulate.entity.ControllerData;
import org.dbpopulate.repository.SampleDAO;
import org.dbpopulate.service.SmarterRoadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmarterRoadsController {
	
	@Autowired
	SmarterRoadsService service;
	
	@RequestMapping(
		    value = "/populate", consumes = "application/json", 
		    method = RequestMethod.POST)
		public ResponseEntity<?> populate(@RequestBody ControllerData data) 
		    throws Exception {
		System.out.println(data.getControllerId());
		service.send(data);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
