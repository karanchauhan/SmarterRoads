package org.dbpopulate.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "controller")
public class Controller implements Serializable {

	private static final long serialVersionUID = 264264714908264527L;

	@DynamoDBHashKey(attributeName = "id")
	private String id;

	private String name;
	private String description;
	private String op_status;
	private String control_mode;
	private String coordinate_state;
	private String model_name;
	private float lat;
	private float lng;
	private String timestamp;
	private String controller_time;
	private String last_reset;
	private String comm_state;
	private Integer comm_percent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOp_status() {
		return op_status;
	}

	public void setOp_status(String op_status) {
		this.op_status = op_status;
	}

	public String getControl_mode() {
		return control_mode;
	}

	public void setControl_mode(String control_mode) {
		this.control_mode = control_mode;
	}

	public String getCoordinate_state() {
		return coordinate_state;
	}

	public void setCoordinate_state(String coordinate_state) {
		this.coordinate_state = coordinate_state;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getController_time() {
		return controller_time;
	}

	public void setController_time(String controller_time) {
		this.controller_time = controller_time;
	}

	public String getLast_reset() {
		return last_reset;
	}

	public void setLast_reset(String last_reset) {
		this.last_reset = last_reset;
	}

	public String getComm_state() {
		return comm_state;
	}

	public void setComm_state(String comm_state) {
		this.comm_state = comm_state;
	}

	public Integer getComm_percent() {
		return comm_percent;
	}

	public void setComm_percent(Integer comm_percent) {
		this.comm_percent = comm_percent;
	}

	@Override
	public String toString() {
		return "Controller [id=" + id + ", name=" + name + ", description=" + description + ", op_status=" + op_status
				+ ", control_mode=" + control_mode + ", coordinate_state=" + coordinate_state + ", model_name="
				+ model_name + ", lat=" + lat + ", lng=" + lng + ", timestamp=" + timestamp + ", controller_time="
				+ controller_time + ", last_reset=" + last_reset + ", comm_state=" + comm_state + ", comm_percent="
				+ comm_percent + "]";
	}

	
	
}