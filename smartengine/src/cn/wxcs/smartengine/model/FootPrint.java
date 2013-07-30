package cn.wxcs.smartengine.model;

import java.util.Date;


public class FootPrint {

	private Application application;
	private Date visitTime;
	
	
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	
}
