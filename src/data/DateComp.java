package data;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * DateComp-Comparator für das Sortieren der Dates.
 * 
 * @author Herbert Seewann
 * @param <T>
 * @version 7.0
 */
public class DateComp<T> implements Comparator<LocalDate> {

    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        return o1.compareTo(o2);
    }
}
