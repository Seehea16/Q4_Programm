package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DBPropertiesManagerLogin {
    
    private DBPropertiesManagerLogin() {}
    
    public static DBPropertiesManagerLogin getInstance() {
        return DBPropertiesManagerHolder.INSTANCE;
    }
    
    private static class DBPropertiesManagerHolder {
        private static final DBPropertiesManagerLogin INSTANCE = new DBPropertiesManagerLogin();
    }
    
    private final Map<String, String> propertiesMap = new HashMap<>();
    
    public void createProperties() {
        load("src/dbconfig/derby.dblogin.properties");
    }
    
    public void load(String fileName) {
        File file = new File(fileName);
        String filePath = file.getAbsolutePath();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split("=");
                propertiesMap.put(tokens[0], tokens[1]);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getUrl() {
        return propertiesMap.get("db.url");
    }

    public String getDriver() {
        return propertiesMap.get("db.driver");
    }

    public String getUsername() {
        return propertiesMap.get("db.username");
    }

    public String getPassword() {
        return propertiesMap.get("db.password");
    }
    
    @Override
    public String toString() {
        return "DBPropertiesManager{" + "propertiesMap=" + propertiesMap + '}';
    }
}
