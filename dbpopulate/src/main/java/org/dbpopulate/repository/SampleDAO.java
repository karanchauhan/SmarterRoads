package org.dbpopulate.repository;

import org.dbpopulate.entity.ControllerData;
import org.springframework.data.repository.CrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface SampleDAO extends CrudRepository<ControllerData, String>{

	ControllerData save(ControllerData sample);
	
}
