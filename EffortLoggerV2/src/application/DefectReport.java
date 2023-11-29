package application;


public class DefectReport {
	private String project;
	private String group_name;
	private String group_num;
	private String step;
	private String category;
	private String num;
	private String description;
	private String keywords;
	
	public DefectReport(String project, String group_name, String group_num, String step, String category, String num, String description, String keywords) {
		this.project = project;
		this.group_name = group_name;
		this.group_num = group_num;
		this.step = step;
		this.category = category;
		this.num = num;
		this.description = description;
		this.keywords = keywords;
	}
	
	
	public String getProject() {
		return project;
	}
	
	public String getName() {
		return group_name;
	}
	
	public String getNum() {
		return group_num;
	}
}