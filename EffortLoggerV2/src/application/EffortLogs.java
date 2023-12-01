package application;

import java.sql.Timestamp;

/**** This class creates an object type effort log
 * 
 * @author: Duy Tran
 * 
 */

public class EffortLogs {
	private Timestamp startTime, stopTime;
	private String project, lifeCycle, effortCategory, deliverable;
	
	public EffortLogs(Timestamp startTime, Timestamp stopTime, String project, String lifeCycle, String effortCategory, String deliverable) {
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.project = project;
		this.lifeCycle = lifeCycle;
		this.effortCategory = effortCategory;
		this.deliverable = deliverable;
	}
}
