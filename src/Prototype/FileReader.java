package Prototype;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class FileReader {
    public static List<String> readNames() {
        List<String> names = new ArrayList<>();
        
        try {
            InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream("names.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
            
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading names file: " + e.getMessage());
            e.printStackTrace();
        }
        
        return names;
    }
} 