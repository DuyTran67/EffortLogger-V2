package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DefectLibrary {
    private List<DefectReport> reports;
    private HashMap<String, String> idToRandomNumberMapping;
    
    public DefectLibrary() {
        reports = new ArrayList<>();
        idToRandomNumberMapping = new HashMap<>();
    }

    public void submitDefectReport(DefectReport report, String userId) {
        // Anonymize the report by generating a random number
        String randomId = generateRandomId();
        report.setReportId(randomId);
        
        // Store the mapping between the user's ID and the random ID
        idToRandomNumberMapping.put(userId, randomId);
        
        // Store the anonymized report in the library
        reports.add(report);
    }

    public List<DefectReport> getReports() {
        return reports;
    }

    public String getRandomIdForUser(String userId) {
        return idToRandomNumberMapping.get(userId);
    }

    private String generateRandomId() {
        // Generate a random 6-digit number as the random ID
        Random random = new Random();
        int randomInt = 100000 + random.nextInt(900000);
        return String.valueOf(randomInt);
    }
}