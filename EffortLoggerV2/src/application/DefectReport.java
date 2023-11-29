package application;


public class DefectReport {
	private String project;
	private String group_name;
	private String group_num;
	private String step;
	private String category;
	private String reportId;
	private String reportContent;
	private String keywords;
	

	public DefectReport(String project, String group_name, String group_num, String step, String category, String reportId, String reportContent, String keywords) {
		this.reportId = reportId;
		this.reportContent = reportContent;
		this.project = project;
		this.group_name = group_name;
		this.group_num = group_num;
		this.step = step;
		this.category = category;
		this.keywords = keywords;
	}
	
	public String getKey() {
		return keywords;
	}
	public String getStep() {
		return step;
	}
	public String getCat() {
		return category;
	}
	public String getReportId() {
		return reportId;
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