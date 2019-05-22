package data;

public class LoginPerson {
    private String art, username, password;
    
    public LoginPerson(String art, String username, String password) {
        this.art = art;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getArt() {
        return art;
    }
}
