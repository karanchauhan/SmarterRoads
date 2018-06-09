package org.dbpopulate.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "phase")
public class Timing {
	
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	
	private String timestamp;
	
	private int plan_id;
	
	private String control_mode;
	
	private String coord_state;
	
	private int cycle_length;
	
	private int offset;
	
	private int local_cycle_timer;
	
	private int master_cycle_timer;
	
	private float sync_phases;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getControl_mode() {
		return control_mode;
	}

	public void setControl_mode(String control_mode) {
		this.control_mode = control_mode;
	}

	public String getCoord_state() {
		return coord_state;
	}

	public void setCoord_state(String coord_state) {
		this.coord_state = coord_state;
	}

	public int getCycle_length() {
		return cycle_length;
	}

	public void setCycle_length(int cycle_length) {
		this.cycle_length = cycle_length;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLocal_cycle_timer() {
		return local_cycle_timer;
	}

	public void setLocal_cycle_timer(int local_cycle_timer) {
		this.local_cycle_timer = local_cycle_timer;
	}

	public int getMaster_cycle_timer() {
		return master_cycle_timer;
	}

	public void setMaster_cycle_timer(int master_cycle_timer) {
		this.master_cycle_timer = master_cycle_timer;
	}

	public float getSync_phases() {
		return sync_phases;
	}

	public void setSync_phases(float sync_phases) {
		this.sync_phases = sync_phases;
	}

	@Override
	public String toString() {
		return "Timing [id=" + id + ", timestamp=" + timestamp + ", plan_id=" + plan_id + ", control_mode="
				+ control_mode + ", coord_state=" + coord_state + ", cycle_length=" + cycle_length + ", offset="
				+ offset + ", local_cycle_timer=" + local_cycle_timer + ", master_cycle_timer=" + master_cycle_timer
				+ ", sync_phases=" + sync_phases + "]";
	}
	
}
