package model;

/**
 * ENUM VorstandEnum.
 * 
 * @author Herbert Seewann
 * @version 3.0
 */
public enum VorstandEnum {
    VORNAME("Vorname"),
    NACHNAME("Nachname"),
    ALTER("Alter"),
    FUNKTION("Funktion");
    
    private String name;

    private VorstandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}