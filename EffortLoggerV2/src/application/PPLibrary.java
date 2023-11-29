package application;

import java.util.ArrayList;
import java.util.List;

public class PPLibrary {
	private ArrayList<PPReport> library; 
	
	public PPLibrary() {
        library = new ArrayList<>();
	}
	
	public ArrayList<PPReport> getLibrary(){
		return library;
	}
	
	public void report(PPReport report) {
		library.add(report);
	}

}
