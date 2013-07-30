package cn.wxcs.smartengine.model;

import java.util.Date;

public class UserContext {

	private Date currentTime;
	private float longitude;
	private float latitude;
	
	
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	
}
