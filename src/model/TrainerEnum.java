package model;

/**
 * ENUM TrainerEnum.
 * 
 * @author Herbert Seewann
 * @version 3.0
 */
public enum TrainerEnum {
    VORNAME("Vorname"),
    NACHNAME("Nachname"),
    ALTER("Alter"),
    MANNSCHAFT("Mannschaft");
    
    private String name;

    private TrainerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}