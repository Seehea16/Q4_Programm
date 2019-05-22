package model;

import data.CompName;
import data.Person;
import data.Spieler;
import data.Trainer;
import data.Vorstand;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * PersonTableModel-Modelklasse für den JTable.
 * 
 * @author Herbert Seewann
 * @version 5.0
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
        if(!OnlyOneType) {
            this.aktList.add(p);
        } else {
            if((akt == 'V' && p instanceof Vorstand) || (akt == 'T' && p instanceof Trainer) 
                    || (akt == 'S' && p instanceof Spieler)) {
                this.aktList.add(p);
            }
        }
        this.sort();
    }
    
    /**
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
        Collections.sort(this.aktList, new CompName<>());
        Collections.sort(this.list, new CompName<>());
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
                }
        }
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
    
    /**
     * Speichert aktuelle Liste.
     * 
     * @param path Verwendeter Pfad
     */
    public void save(Path path) {
        try(BufferedWriter writer = Files.newBufferedWriter(path, 
                Charset.forName("UTF-8"))){
            if(!OnlyOneType) {
                for(Person p : aktList) {
                    if(p instanceof Vorstand) {
                        writer.write("Vorstand;");
                        ((Vorstand) p).writeTo(writer, false);
                        writer.newLine();
                    } else if(p instanceof Trainer) {
                        writer.write("Trainer;");
                        ((Trainer) p).writeTo(writer, false);
                        writer.newLine();
                    } else {
                        writer.write("Spieler;");
                        ((Spieler) p).writeTo(writer, false);
                        writer.newLine();
                    }
                }
            } else {
                writer.write(PersonEnum.VORNAME.getName());
                writer.write(";");
                writer.write(PersonEnum.NACHNAME.getName());
                writer.write(";");
                writer.write(PersonEnum.ALTER.getName());
                writer.write(";");
                switch(akt) {
                    case 'V': writer.write(VorstandEnum.FUNKTION.getName());
                        writer.write(";");
                        for(Person p : aktList) {
                            ((Vorstand) p).writeTo(writer, true);
                        }
                        break;
                    case 'T': writer.write(TrainerEnum.MANNSCHAFT.getName());
                        writer.write(";");
                        for(Person p : aktList) {
                            ((Trainer) p).writeTo(writer, true);
                        }
                        break;
                    default: writer.write(SpielerEnum.TORESAISON.getName());
                        writer.write(";");
                        writer.write(SpielerEnum.TOREGESAMT.getName());
                        writer.write(";");
                        writer.write(SpielerEnum.TRIKOTNUMMER.getName());
                        writer.write(";");
                        writer.write(SpielerEnum.MANNSCHAFT.getName());
                        writer.write(";");
                        writer.write("Daten");
                        writer.write(";");
                        for(Person p : aktList) {
                            ((Spieler) p).writeTo(writer, true);
                        }
                }
            }
        } catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Datei konnet nicht gespeichert "
                    + "werden!", "Fehler", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Ladet aktuelle Liste.
     * 
     * @param path Verwendeter Pfad
     */
    public void load(Path path) {
        this.clear();
        try(BufferedReader reader = Files.newBufferedReader(path, 
                Charset.forName("UTF-8"))) {
            String currentLine = reader.readLine();
            switch (currentLine.split(";")[3]) {
                case "Funktion":
                    while((currentLine = reader.readLine()) != null) {
                        this.add(new Vorstand(currentLine));
                    }   break;
                case "Mannschaft":
                    while((currentLine = reader.readLine()) != null) {
                        this.add(new Trainer(currentLine));
                    }   break;
                case "Tore | Saison":
                    while((currentLine = reader.readLine()) != null) {
                        this.add(new Spieler(currentLine));
                    }   break;
                default:
                    switch(currentLine.split(";")[0]) {
                        case "Vorstand": this.add(new Vorstand(currentLine.substring(currentLine.indexOf(";")+1)));
                        break;
                        case "Trainer": this.add(new Trainer(currentLine.substring(currentLine.indexOf(";")+1)));
                        break;
                        default: this.add(new Spieler(currentLine.substring(currentLine.indexOf(";")+1)));
                    }   while((currentLine = reader.readLine()) != null) {
                        switch(currentLine.split(";")[0]) {
                            case "Vorstand": this.add(new Vorstand(currentLine.substring(currentLine.indexOf(";")+1)));
                            break;
                            case "Trainer": this.add(new Trainer(currentLine.substring(currentLine.indexOf(";")+1)));
                            break;
                            default: this.add(new Spieler(currentLine.substring(currentLine.indexOf(";")+1)));
                        }
                    }   break;
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Datei konnte nicht geladen "
                    + "werden!", "Fehler", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }
}