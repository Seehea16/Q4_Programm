package db;

import data.LoginPerson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import sql.LoginSQL;

public class DBLoginAccess {
    
    private DBLoginAccess() {}
    
    public static DBLoginAccess getInstance() {
        return DBAccessHolder.INSTANCE;
    }
    
    private static class DBAccessHolder {
        private static final DBLoginAccess INSTANCE = new DBLoginAccess();
    }
    
    private final DBManagerLogin dbm = DBManagerLogin.getInstance();
    
    public void persistEntity(LoginPerson login) throws Exception {
        PreparedStatement pstmt = dbm.createPreparedStatement(
                LoginSQL.PSTMT_INSERT.getSql(), Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, login.getArt());
        pstmt.setString(2, login.getUsername());
        pstmt.setString(3, login.getPassword());

        pstmt.executeUpdate();
        
        pstmt.close();
    }
    
    public String findPasswordByUsername(String benutzer) throws Exception { 
        try {
            Statement stat = dbm.createStatement();
            String sql = "SELECT * FROM Benutzer " +
            "WHERE username = '" + benutzer + "' ";
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                return rs.getString("password");
            }
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public boolean isUsernameThere(String benutzer) throws Exception { 
        try {
            Statement stat = dbm.createStatement();
            String sql = "SELECT * FROM Benutzer";
            ResultSet rs = stat.executeQuery(sql);
            //rs.next();
            while(rs.next()) {
                if(rs.getString("username").equals(benutzer)) {
                    return true;
                }
            }
            stat.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public String getArt(String benutzer, String password) throws Exception { 
        try {
            Statement stat = dbm.createStatement();
            String sql = "SELECT * FROM Benutzer " +
            "WHERE username = '" + benutzer + "' AND "
                    + "password = '" + password + "' ";
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                return rs.getString("art");
            }
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}