package model;

import data.Person;
import data.Spieler;
import data.Trainer;
import data.Vorstand;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * PersonTableModel-Modelklasse für den JTable.
 * 
 * @author Herbert Seewann
 * @version 3.0
 */
public class PersonTableModel extends AbstractTableModel {
    
    protected List<Person> list = new ArrayList<>();
    protected List<Person> aktList = new ArrayList<>(list);
    private boolean OnlyOneType = false;
    private LocalDate selectedTraining = LocalDate.now();
    private char akt;
    
    @Override
    public int getRowCount() {
        return aktList.size();
    }

    @Override
    public int getColumnCount() {
        if(OnlyOneType) {
            switch (akt) {
                case 'V':
                    return VorstandEnum.values().length;
                case 'T':
                    return TrainerEnum.values().length;
                default:
                    return SpielerEnum.values().length;
            }
        } else {
            return PersonEnum.values().length;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person p = this.aktList.get(rowIndex);
        if(OnlyOneType) {
            switch (akt) {
                case 'V':
                {
                    VorstandEnum enumIndex = VorstandEnum.values()[columnIndex];
                    Vorstand tmp = (Vorstand) p;
                    switch(enumIndex) {
                        case ALTER: return tmp.getAlter();
                        case NACHNAME: return tmp.getNachname();
                        case VORNAME: return tmp.getVorname();
                        case FUNKTION: return tmp.getFunktion();
                    }
                }
                case 'T':
                {
                    TrainerEnum enumIndex = TrainerEnum.values()[columnIndex];
                    Trainer tmp = (Trainer) p;
                    switch(enumIndex) {
                        case ALTER: return tmp.getAlter();
                        case NACHNAME: return tmp.getNachname();
                        case VORNAME: return tmp.getVorname();
                        case MANNSCHAFT: return tmp.getMannschaft();
                    }
                }
                default:
                {
                    SpielerEnum enumIndex = SpielerEnum.values()[columnIndex];
                    Spieler tmp = (Spieler) p;
                    switch(enumIndex) {
                        case ALTER: return tmp.getAlter();
                        case NACHNAME: return tmp.getNachname();
                        case VORNAME: return tmp.getVorname();
                        case MANNSCHAFT: return tmp.getMannschaft();
                        case TOREGESAMT: return tmp.getToreGesamt();
                        case TORESAISON: return tmp.getToreSaison();
                        case TRIKOTNUMMER: return tmp.getTrikotNummer();
                        case TRAINING:  if(tmp.getTrainings().contains(selectedTraining)) {
                            return "Anwesend";
                        } else {
                            return "Abwesend";
                        }
                    }
                }
            }
        } else {
            PersonEnum enumIndex = PersonEnum.values()[columnIndex];
            switch(enumIndex) {
                case ALTER: return p.getAlter();
                case NACHNAME: return p.getNachname();
                case VORNAME: return p.getVorname();
            }
        }
        return "?";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person pAlt = this.list.get(rowIndex);
        
        String vornameAlt = pAlt.getVorname();
        String nachnameAlt = pAlt.getNachname();
        int alterAlt = pAlt.getAlter();
        
        try {
            Person pNeu = pAlt;
            if(pAlt instanceof Vorstand) {
                VorstandEnum enumIndex = VorstandEnum.values()[columnIndex];
                String funktionAlt = ((Vorstand) pAlt).getFunktion();
                switch(enumIndex) {
                    case ALTER: alterAlt = Integer.parseInt(aValue+"");
                                break;
                    case NACHNAME: nachnameAlt = aValue+"";
                                    break;
                    case VORNAME: vornameAlt = aValue+"";
                                    break;
                    case FUNKTION: funktionAlt = aValue+"";
                                    break;
                }
                pNeu = new Vorstand(vornameAlt, nachnameAlt, alterAlt, funktionAlt);
            } else if(pAlt instanceof Trainer) {
                TrainerEnum enumIndex = TrainerEnum.values()[columnIndex];
                String mannschaftAlt = ((Trainer) pAlt).getMannschaft();
                switch(enumIndex) {
                    case ALTER: alterAlt = Integer.parseInt(aValue+"");
                                break;
                    case NACHNAME: nachnameAlt = aValue+"";
                                    break;
                    case VORNAME: vornameAlt = aValue+"";
                                    break;
                    case MANNSCHAFT: mannschaftAlt = aValue+"";
                                    break;
                }
                pNeu = new Trainer(vornameAlt, nachnameAlt, alterAlt, mannschaftAlt);
            } else {
                SpielerEnum enumIndex = SpielerEnum.values()[columnIndex];
                int toreSaisonAlt = ((Spieler) pAlt).getToreSaison();
                int toreGesamtAlt = ((Spieler) pAlt).getToreGesamt();
                int trikotNummerAlt = ((Spieler) pAlt).getTrikotNummer();
                String mannschaftAlt = ((Spieler) pAlt).getMannschaft();
                switch(enumIndex) {
                    case ALTER: alterAlt = Integer.parseInt(aValue+"");
                                break;
                    case NACHNAME: nachnameAlt = aValue+"";
                                    break;
                    case VORNAME: vornameAlt = aValue+"";
                                    break;
                    case MANNSCHAFT: mannschaftAlt = aValue+"";
                                    break;
                    case TOREGESAMT: toreGesamtAlt = Integer.parseInt(aValue+"");
                                    break;
                    case TORESAISON: toreSaisonAlt = Integer.parseInt(aValue+"");
                                    break;
                    case TRIKOTNUMMER: trikotNummerAlt = Integer.parseInt(aValue+"");
                                        break;
                }
                pNeu = new Spieler(vornameAlt, nachnameAlt, alterAlt, 
                        toreSaisonAlt, toreGesamtAlt, trikotNummerAlt, mannschaftAlt);
            }
            this.change(rowIndex, pAlt, pNeu);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Bitte Zahlen eingeben!", 
                    "Warnung", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(OnlyOneType && akt == 'S' && SpielerEnum.values()
                [columnIndex].equals(SpielerEnum.TRAINING)) {
            return false;
        }
        return true;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(OnlyOneType) {
            switch (akt) {
                case 'V':
                    return VorstandEnum.values()[columnIndex].getName();
                case 'T':
                    return TrainerEnum.values()[columnIndex].getName();
                default:
                    return SpielerEnum.values()[columnIndex].getName();
            }
        } else {
            return PersonEnum.values()[columnIndex].getName();
        }
    }

    /**
     * Setzt Boolean OnlyOneType.
     * 
     * @param OnlyOneType
     */
    public void setOnlyOneType(boolean OnlyOneType) {
        this.OnlyOneType = OnlyOneType;
        if(!OnlyOneType) {
            this.aktList = new ArrayList<>(list);
            this.fireTableStructureChanged();
            this.fireTableDataChanged();
        }
    }

    /**
     * Setzt ausgewähltes Training.
     * 
     * @param selectedTraining 
     */
    public void setSelectedTraining(LocalDate selectedTraining) {
        this.selectedTraining = selectedTraining;
        this.fireTableDataChanged();
    }
    
    /**
     * 
     * @param p Person to add
     */
    public void add(Person p) {
        this.list.add(p);
        this.aktList.add(p);
        this.sort();
    }
    
    /**
     * 
     * @param index Index from the person that get's deleted
     */
    public void delete(int index) {
        this.list.remove(aktList.get(index));
        aktList.remove(index);
        this.fireTableDataChanged();
    }

    /**
     * Verändert alten Wert mit neuem Wert.
     * 
     * @param rowIndex
     * @param pAlt
     * @param pNeu 
     */
    public void change(int rowIndex, Person pAlt, Person pNeu) {
        this.aktList.set(rowIndex, pNeu);
        this.list.set(this.list.indexOf(pAlt), pNeu);
        this.sort();
    }

    /**
     * Sortiert die Listen im JTable.
     */
    public void sort() {
        
        this.fireTableDataChanged();
    }
    
    /**
     * Löscht alle Elemente aus den Listen.
     */
    public void clear() {
        this.list.clear();
        this.aktList.clear();
        this.fireTableDataChanged();
    }
    
    /**
     * Setzt aktuelle Liste.
     * 
     * @param c 
     */
    public void setAktList(char c) {
        aktList.clear();
        akt = c;
        switch(akt) {
            case 'V':
                for(Person p : list) {
                    if(p instanceof Vorstand) {
                        aktList.add(p);
                    }
                }   break;
            case 'T':
                for(Person p : list) {
                    if(p instanceof Trainer) {
                        aktList.add(p);
                    }
                }   break;
            default:
                for(Person p : list) {
                    if(p instanceof Spieler) {
                        aktList.add(p);
                    }
                }   break;
        }
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
}
