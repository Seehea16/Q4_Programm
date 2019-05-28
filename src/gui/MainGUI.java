package gui;

import data.CSVFilter;
import data.Spieler;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.PersonTableModel;

/**
 * Haupt-GUI (JFrame).
 * 
 * @author Herbert Seewann
 * @version 7.0
 */
public class MainGUI extends javax.swing.JFrame {
    
    private PersonTableModel model;
    private final Path path = Paths.get("src/resource/standard.csv");
    private final JFileChooser fc = new JFileChooser();
    public static String art;
    public static String username;
    public String mannschaft;
    private LocalDate selectedDate;
    
    /**
     * Konstruktor für Klasse MainGUI
     */
    public MainGUI() {
        initComponents();
        rbSpieler.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onRbSpieler();
            }
        });
        setAllInvisible();
        model = new PersonTableModel();
        personTable.setModel(model);
        personTable.setFillsViewportHeight(true);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new CSVFilter());
        fc.setCurrentDirectory(new File("D:\\Schule\\3. Jahrgang 2018 - 2019\\Programmieren\\Projekt_Q4\\SV Hausmannstätten - Trainerprogramm"));
        miAnwesenheit.setVisible(false);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFilter = new javax.swing.ButtonGroup();
        pMenu = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miDelete = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miAnwesenheit = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        rbAlle = new javax.swing.JRadioButton();
        cbMannschaft = new javax.swing.JCheckBox();
        rbVorstand = new javax.swing.JRadioButton();
        lbDatum = new javax.swing.JLabel();
        rbTrainer = new javax.swing.JRadioButton();
        cboxDatum = new javax.swing.JComboBox<>();
        rbSpieler = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miSpeichern = new javax.swing.JMenuItem();
        miLaden = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miREADME = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miStammbaum = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miBeenden = new javax.swing.JMenuItem();

        miAdd.setText("Hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        pMenu.add(miAdd);

        miDelete.setText("Entfernen");
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        pMenu.add(miDelete);
        pMenu.add(jSeparator3);

        miAnwesenheit.setText("Anwesenheit ändern");
        miAnwesenheit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAnwesenheitActionPerformed(evt);
            }
        });
        pMenu.add(miAnwesenheit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SV Hausmannstätten - Trainerprogramm");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        bgFilter.add(rbAlle);
        rbAlle.setSelected(true);
        rbAlle.setText("Alle");
        rbAlle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlleActionPerformed(evt);
            }
        });
        jPanel1.add(rbAlle);

        cbMannschaft.setText("Mannschaft");
        cbMannschaft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMannschaftActionPerformed(evt);
            }
        });
        jPanel1.add(cbMannschaft);

        bgFilter.add(rbVorstand);
        rbVorstand.setText("Vorstand");
        rbVorstand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVorstandActionPerformed(evt);
            }
        });
        jPanel1.add(rbVorstand);

        lbDatum.setText("Trainingsdatum:");
        jPanel1.add(lbDatum);

        bgFilter.add(rbTrainer);
        rbTrainer.setText("Trainer");
        rbTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTrainerActionPerformed(evt);
            }
        });
        jPanel1.add(rbTrainer);

        cboxDatum.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxDatumItemStateChanged(evt);
            }
        });
        jPanel1.add(cboxDatum);

        bgFilter.add(rbSpieler);
        rbSpieler.setText("Spieler");
        rbSpieler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSpielerActionPerformed(evt);
            }
        });
        jPanel1.add(rbSpieler);

        getContentPane().add(jPanel1);

        personTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        personTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        personTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(personTable);

        getContentPane().add(jScrollPane1);

        jMenu1.setText("Datei");

        miSpeichern.setText("Speichern");
        miSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSpeichernActionPerformed(evt);
            }
        });
        jMenu1.add(miSpeichern);

        miLaden.setText("Laden");
        miLaden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLadenActionPerformed(evt);
            }
        });
        jMenu1.add(miLaden);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Optionen");

        miREADME.setText("README-Datei anzeigen");
        miREADME.setToolTipText("");
        miREADME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miREADMEActionPerformed(evt);
            }
        });
        jMenu2.add(miREADME);
        jMenu2.add(jSeparator1);

        miStammbaum.setText("Grafischen \"Stammbaum\" anzeigen //TODO");
        miStammbaum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miStammbaumActionPerformed(evt);
            }
        });
        jMenu2.add(miStammbaum);
        jMenu2.add(jSeparator2);

        miBeenden.setText("Programm beenden");
        miBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBeendenActionPerformed(evt);
            }
        });
        jMenu2.add(miBeenden);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Zum Anzeigen der README-Datei.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miREADMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miREADMEActionPerformed
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(
                "src/resource/README.txt"), Charset.forName("UTF-8"))) {
            String tmp = "";
            String currentLine = null;
            while((currentLine = reader.readLine()) != null) {
                tmp += currentLine + "\n";
            }
            JOptionPane.showMessageDialog(this, tmp, "README-Datei", 
                    JOptionPane.INFORMATION_MESSAGE);
        } catch(IOException ex) {
            JOptionPane.showMessageDialog(this, "Fehler beim Lesen der "
                    + "README-Datei!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miREADMEActionPerformed

    /**
     * Zum Beenden des Programms.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBeendenActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miBeendenActionPerformed

    /**
     * Wird beim Ändern der Checkbox Mannschaft aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void cbMannschaftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMannschaftActionPerformed
        if(cbMannschaft.isSelected()) {
            miAnwesenheit.setVisible(true);
            lbDatum.setVisible(true);
            cboxDatum.setVisible(true);
            model.setMannschaftFilter(true);
            model.setAktList(mannschaft);
            cboxDatum.removeAllItems();
            for(LocalDate ld = LocalDate.now(); ld.isAfter(LocalDate.of(2018, 12, 31)); ld = ld.minusDays(2)) {
                cboxDatum.addItem(Spieler.DTF.format(ld));
            }
            cboxDatum.setSelectedIndex(0);
            selectedDate = LocalDate.parse(cboxDatum.getItemAt(0), Spieler.DTF);
            model.setSelectedTraining(selectedDate);
        } else {
            miAnwesenheit.setVisible(false);
            lbDatum.setVisible(false);
            cboxDatum.setVisible(false);
            model.setMannschaftFilter(false);
            model.setAktList('S');
        }
        model.fireTableStructureChanged();
        model.fireTableDataChanged();
        pack();
    }//GEN-LAST:event_cbMannschaftActionPerformed

    /**
     * Wird beim Klicken des RadioButtons Alle aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbAlleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlleActionPerformed
        cbMannschaftActionPerformed(evt);
        model.setOnlyOneType(false);
        pack();
    }//GEN-LAST:event_rbAlleActionPerformed

    /**
     * Wird beim Klicken des RadioButtons Vorstand aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbVorstandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVorstandActionPerformed
        cbMannschaftActionPerformed(evt);
        model.setAktList('V');
        model.setOnlyOneType(true);
        pack();
    }//GEN-LAST:event_rbVorstandActionPerformed

    /**
     * Wird beim Klicken des RadioButtons Trainer aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTrainerActionPerformed
        cbMannschaftActionPerformed(evt);
        model.setAktList('T');
        model.setOnlyOneType(true);
        pack();
    }//GEN-LAST:event_rbTrainerActionPerformed

    /**
     * Wird beim Klicken des RadioButtons Spieler aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbSpielerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSpielerActionPerformed
        model.setAktList('S');
        model.setOnlyOneType(true);
        if(art.equals("Trainer") && !model.getMannschaftFromTrainer(username).equals("")) {
            cbMannschaft.setVisible(true);
            mannschaft = model.getMannschaftFromTrainer(username);
        }
        pack();
    }//GEN-LAST:event_rbSpielerActionPerformed

    /**
     * Wird beim Klicken in den Table aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void personTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personTableMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON3) {
            this.pMenu.show(this, evt.getX(), evt.getYOnScreen());
        }
    }//GEN-LAST:event_personTableMouseClicked

    /**
     * Wird beim Klicken auf das MenuItem Add aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        AddDlg dialog = new AddDlg(this, true);
        dialog.setVisible(true);
        if(dialog.isIsOkay()) {
            model.add(dialog.getNewPerson());
        }
    }//GEN-LAST:event_miAddActionPerformed

    /**
     * Wird beim Klicken auf das MenuItem Delete aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
        int selected = personTable.getSelectedRow();
        if(selected == -1) {
            JOptionPane.showMessageDialog(this, "Bitte eine Person auswählen!", 
                    "Warnung", JOptionPane.WARNING_MESSAGE);
        } else {
            model.delete(selected);
        }
    }//GEN-LAST:event_miDeleteActionPerformed

    /**
     * Wird beim Klicken auf das MenuItem Anwesenheit ändern aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miAnwesenheitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAnwesenheitActionPerformed
        int selected = personTable.getSelectedRow();
        if(selected == -1) {
            JOptionPane.showMessageDialog(this, "Bitte eine Person auswählen!", 
                    "Warnung", JOptionPane.WARNING_MESSAGE);
        } else {
            model.changeAnwesenheit(selected);
        }
    }//GEN-LAST:event_miAnwesenheitActionPerformed

    /**
     * Wird beim Klicken auf das MenuItem Speichern aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSpeichernActionPerformed
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String s = f.toString();
            if(!s.endsWith(".csv")) {
                if(s.charAt(s.length()-4) == '.') {
                    s = s.substring(0, s.length()-4);
                }
                s = s.concat(".csv");
            }
            model.save(Paths.get(s));
        }
    }//GEN-LAST:event_miSpeichernActionPerformed

    /**
     * Wird beim Klicken auf das MenuItem Laden aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miLadenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLadenActionPerformed
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            model.load(f.toPath());
        } 
    }//GEN-LAST:event_miLadenActionPerformed

    /**
     * Wird beim Öffnen der GUI aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        model.load(path);
    }//GEN-LAST:event_formWindowOpened

    /**
     * Wird beim Klicken auf das MenuItem Stammbaum anzeigen aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void miStammbaumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miStammbaumActionPerformed
        JDialog g = new JDialog(this, true);
        g.setTitle("Grafischer Stammbaum");
        g.setSize(new Dimension(500, 500));
        g.add(new DrawPanel());
        g.setVisible(true);
    }//GEN-LAST:event_miStammbaumActionPerformed

    private void cboxDatumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxDatumItemStateChanged
        try {    
            selectedDate = LocalDate.parse(cboxDatum.getSelectedItem()+"", Spieler.DTF);
            model.setSelectedTraining(selectedDate);
        } catch(Exception ex) {
            //Do nix
        }
    }//GEN-LAST:event_cboxDatumItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
        
        art = args[0];
        username = args[1];
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFilter;
    private javax.swing.JCheckBox cbMannschaft;
    private javax.swing.JComboBox<String> cboxDatum;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbDatum;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miAnwesenheit;
    private javax.swing.JMenuItem miBeenden;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miLaden;
    private javax.swing.JMenuItem miREADME;
    private javax.swing.JMenuItem miSpeichern;
    private javax.swing.JMenuItem miStammbaum;
    private javax.swing.JPopupMenu pMenu;
    private javax.swing.JTable personTable;
    private javax.swing.JRadioButton rbAlle;
    private javax.swing.JRadioButton rbSpieler;
    private javax.swing.JRadioButton rbTrainer;
    private javax.swing.JRadioButton rbVorstand;
    // End of variables declaration//GEN-END:variables

    /**
     * Setzt alle unwichtigen Filter auf Invisible.
     */
    private void setAllInvisible() {
        cbMannschaft.setSelected(false);
        cbMannschaft.setVisible(false);
        lbDatum.setVisible(false);
        cboxDatum.setVisible(false);
    }
    
    /**
     * Wird beim Ändern des RadioButtons Spieler aufgerufen.
     */
    private void onRbSpieler() {
        if(!rbSpieler.isSelected()) {
            setAllInvisible();
        }
    }
}
