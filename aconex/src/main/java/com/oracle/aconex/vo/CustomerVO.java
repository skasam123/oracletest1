package com.oracle.aconex.vo;

public class CustomerVO {

	private String customerId;
	private String contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private int buildduration;

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getGeozone() {
		return geozone;
	}
	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}
	public String getTeamcode() {
		return teamcode;
	}
	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	public int getBuildduration() {
		return buildduration;
	}
	public void setBuildduration(String buildduration) {
		buildduration = buildduration.replace("s", "").trim();
		int duration = Integer.parseInt(buildduration);
		this.buildduration = duration;
	}


}
