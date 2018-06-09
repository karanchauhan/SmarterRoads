package org.dbpopulate.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "controller")
public class ControllerData implements Serializable{

	private static final long serialVersionUID = 264264714908264527L;

	@DynamoDBHashKey(attributeName = "id")
	String controllerId;
	
	String sample;

	public String getControllerId() {
		return controllerId;
	}

	public void setControllerId(String controllerId) {
		this.controllerId = controllerId;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	@Override
	public String toString() {
		return "ControllerData [controllerId=" + controllerId + ", sample=" + sample + "]";
	}
}
