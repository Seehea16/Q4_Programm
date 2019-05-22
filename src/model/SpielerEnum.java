package model;

/**
 * ENUM SpielerEnum.
 * 
 * @author Herbert Seewann
 * @version 3.0
 */
public enum SpielerEnum {
    VORNAME("Vorname"),
    NACHNAME("Nachname"),
    ALTER("Alter"),
    TORESAISON("Tore | Saison"),
    TOREGESAMT("Tore | Gesamt"),
    TRIKOTNUMMER("Trikotnummer"),
    MANNSCHAFT("Mannschaft"),
    TRAINING("Training");
    
    private String name;

    private SpielerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}