package model;

/**
 * ENUM PersonEnum.
 * 
 * @author Herbert Seewann
 * @version 3.0
 */
public enum PersonEnum {
    VORNAME("Vorname"),
    NACHNAME("Nachname"),
    ALTER("Alter");
    
    private String name;

    private PersonEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}