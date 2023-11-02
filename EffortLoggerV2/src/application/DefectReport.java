package application;

public class DefectReport {
	private String reportId;
	private String reportContent;
	
	public DefectReport(String reportId, String reportContent) {
		this.reportId = reportId;
		this.reportContent = reportContent;
	}
	
	public String getReportId() {
		return reportId;
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