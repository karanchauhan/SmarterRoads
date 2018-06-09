package org.dbpopulate.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "phase")
public class Phase {
	
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	
	private String phases;
	
	private String vehicle_calls;
	
	private String pedestrian_calls;
	
	private String force_off;
	
	private String hold;
	
	private String vehicle_green_time;
	
	private String controller_id;
	
	private String ringStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhases() {
		return phases;
	}

	public void setPhases(String phases) {
		this.phases = phases;
	}

	public String getVehicle_calls() {
		return vehicle_calls;
	}

	public void setVehicle_calls(String vehicle_calls) {
		this.vehicle_calls = vehicle_calls;
	}

	public String getPedestrian_calls() {
		return pedestrian_calls;
	}

	public void setPedestrian_calls(String pedestrian_calls) {
		this.pedestrian_calls = pedestrian_calls;
	}

	public String getForce_off() {
		return force_off;
	}

	public void setForce_off(String force_off) {
		this.force_off = force_off;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	public String getVehicle_green_time() {
		return vehicle_green_time;
	}

	public void setVehicle_green_time(String vehicle_green_time) {
		this.vehicle_green_time = vehicle_green_time;
	}

	public String getController_id() {
		return controller_id;
	}

	public void setController_id(String controller_id) {
		this.controller_id = controller_id;
	}

	public String getRingStatus() {
		return ringStatus;
	}

	public void setRingStatus(String ringStatus) {
		this.ringStatus = ringStatus;
	}

	@Override
	public String toString() {
		return "Phase [id=" + id + ", phases=" + phases + ", vehicle_calls=" + vehicle_calls + ", pedestrian_calls="
				+ pedestrian_calls + ", force_off=" + force_off + ", hold=" + hold + ", vehicle_green_time="
				+ vehicle_green_time + ", controller_id=" + controller_id + ", ringStatus=" + ringStatus + "]";
	}
	
}
