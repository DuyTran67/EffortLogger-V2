package application;

import java.sql.Timestamp;

import javafx.beans.property.SimpleStringProperty;

/**** This class creates an object type effort log
 * 
 * @author: Duy Tran
 * 
 */

public class EffortLogs {
	private SimpleStringProperty start, stop, project, step, effort, deliverable;
	
	public EffortLogs(String project, Timestamp start, Timestamp stop, String lifeCycle, String effortCategory, String deliverable) {
		this.start = new SimpleStringProperty(start.toString());
		this.stop = new SimpleStringProperty(stop.toString());
		this.project = new SimpleStringProperty(project);
		this.step = new SimpleStringProperty(lifeCycle);
		this.effort = new SimpleStringProperty(effortCategory);
		this.deliverable = new SimpleStringProperty(deliverable);
	}
	
	public void setStart(String start) {
		this.start.set(start);;
	}
	public void setStop(String stop) {
		this.stop.set(stop);;
	}
	public void setProject(String project) {
		this.project.set(project);
	}
	public void setStep(String lifeCycle) {
		this.step.set(lifeCycle);
	}
	public void setCategory(String effortCategory) {
		this.effort.set(effortCategory);
	}
	public void setDeliverable(String deliverable) {
		this.deliverable.set(deliverable);
	}
	public String getStart() {
		return this.start.get();
	}
	public String getStop() {
		return this.stop.get();
	}
	public String getProject() {
		return this.project.get();
	}
	public String getStep() {
		return this.step.get();
	}
	public String getEffort() {
		return this.effort.get();
	}
	public String getDeliverable() {
		return this.deliverable.get();
	}
	
}
