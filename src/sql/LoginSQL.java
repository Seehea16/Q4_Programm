package sql;

public enum LoginSQL {
    PSTMT_INSERT("INSERT INTO BENUTZER ("
            + "ART, USERNAME, PASSWORD) "
            + "VALUES (?, ?, ?)");
    private String sql;
    
    private LoginSQL(String sql) {
        this.sql = sql;
    }
    
    public String getSql() {
        return sql;
    }
}
