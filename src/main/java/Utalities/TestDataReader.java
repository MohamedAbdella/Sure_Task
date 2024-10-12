package Utalities;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public static EmployeeData getEmployeeData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), EmployeeData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ContactDetails getContactDetails(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), ContactDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

