package data;

import java.util.Comparator;

/**
 * CompName-Comparator für das Sortieren des Tables.
 * 
 * @author herbe
 * @param <T>
 * @version 5.0
 */
public class CompName<T> implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        String vorname1 = o1.getVorname();
        String vorname2 = o2.getVorname();
        String nachname1 = o1.getNachname();
        String nachname2 = o2.getNachname();
        if(nachname1.compareTo(nachname2) == 0) {
            return vorname1.compareTo(vorname2);
        } else {
            return nachname1.compareTo(nachname2);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(this.getClass() == obj.getClass()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
