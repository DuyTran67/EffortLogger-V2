package application;

public class PPReport {
	private String project;
	private String points;
	private String story;
	private String step;
	private String category;
	private String keyword;
	
	public PPReport(String project, String points, String story, String step, String category, String keyword) {
		this.project = project;
		this.points = points;
		this.story = story;
		this.step = step;
		this.category = category;
		this.keyword = keyword;
	}
	
	public String getKey() {
		return keyword;
	}
	public String getProject() {
		return project;
	}
	
	public String getStep() {
		return step;
	}
	
	public String getCat() {
		return category;
	}
	
	public String getPoints() {
		return points;
	}
	
	public String getStory() {
		return story;
	}
}
