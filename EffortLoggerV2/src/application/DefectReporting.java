package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class DefectReporting {
//By Easton	
	private String defect;
	private String grp_name;
	private int grp_num;
	private String project;
	private String keywords;
	
	public DefectReporting(String defect, String grp_name, String grp_num, String project, String keywords) {
		this.defect = defect;
		this.grp_name = grp_name;
		int num = Integer.parseInt(grp_num);
		this.grp_num = num;
		this.project = project;
		this.keywords = keywords;
	}
	
	public String getKey() {
		return keywords;
	}
	
	public String getDefect() {
		return defect;
	}
	
	public String getName() {
		return grp_name;
	}
	
	public int getNum() {
		return grp_num;
	}
	
	public String getProject() {
		return project;
	}
	
}
