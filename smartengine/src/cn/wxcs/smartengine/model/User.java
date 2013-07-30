package cn.wxcs.smartengine.model;

import java.util.List;;

public class User {
	
	private String userId;
	private List<Application> footPrint;

	public List<Application> getFootPrint() {
		return footPrint;
	}
	public void setFootPrint(List<Application> footPrint) {
		this.footPrint = footPrint;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
