package application;


public class DefectReport {
	private String reportId;
	private String reportContent;
	private String project;
	private String group_name;
	private String group_num;
	
	public DefectReport(String project, String group_name, String group_num, String reportId, String reportContent) {
		this.reportId = reportId;
		this.reportContent = reportContent;
		this.project = project;
		this.group_name = group_name;
		this.group_num = group_num;
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
	public String getReportContent() {
		return reportContent;
	}

    public void setReportId(String senderRandomId) {
        this.reportId = senderRandomId;
    }
    
    public void setReportContent(String senderReportContent) {
        this.reportContent = senderReportContent;
    }
}