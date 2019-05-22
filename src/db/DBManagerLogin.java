package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManagerLogin {
    
    private DBPropertiesManagerLogin dbpm = DBPropertiesManagerLogin.getInstance();
    private Connection con;
    
    private DBManagerLogin() {
        try {
            dbpm.createProperties();
            Class.forName(dbpm.getDriver());
            con = DriverManager.getConnection(dbpm.getUrl(),
                    dbpm.getUsername(), dbpm.getPassword());
        } catch(ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static DBManagerLogin getInstance() {
        return DBManagerHolder.INSTANCE;
    }
    
    private static class DBManagerHolder {
        private static final DBManagerLogin INSTANCE = new DBManagerLogin();
    }
    
    public Statement createStatement() throws Exception {
        return con.createStatement();
    }
    
    public PreparedStatement createPreparedStatement(String sql, int... params) throws Exception {
        switch(params.length) {
            case 0: return con.prepareStatement(sql);
            default: return con.prepareStatement(sql, params[0]);
        }
    }
    
    public void close() throws SQLException {
        con.close();
    }
    
    public int readGeneratedKeys(Statement stmt) throws Exception {
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next())
        {
            int id = rs.getInt(1);
            return id;
        }
        throw new Exception("No generated Key!");
    }
}
