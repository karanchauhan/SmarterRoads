package org.dbpopulate.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "detector")
public class Detector {
	
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	
	private int vol;
	
	private int occ;
	
	private int spd;
	
	private String detectors_on_off;
	
	private String timestamp;
	
	private String controller_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public int getOcc() {
		return occ;
	}

	public void setOcc(int occ) {
		this.occ = occ;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public String getDetectors_on_off() {
		return detectors_on_off;
	}

	public void setDetectors_on_off(String detectors_on_off) {
		this.detectors_on_off = detectors_on_off;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getController_id() {
		return controller_id;
	}

	public void setController_id(String controller_id) {
		this.controller_id = controller_id;
	}

	@Override
	public String toString() {
		return "Detector [id=" + id + ", vol=" + vol + ", occ=" + occ + ", spd=" + spd + ", detectors_on_off="
				+ detectors_on_off + ", timestamp=" + timestamp + ", controller_id=" + controller_id + "]";
	}
	
}
