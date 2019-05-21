package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Haupt-GUI (JFrame).
 * 
 * @author Herbert Seewann
 * @version 2.0
 */
public class MainGUI extends javax.swing.JFrame {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SV Hausmannstätten - Trainerprogramm");
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        bgFilter.add(rbAlle);
        rbAlle.setSelected(true);
        rbAlle.setText("Alle");
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
        jPanel1.add(rbVorstand);

        lbDatum.setText("Trainingsdatum:");
        jPanel1.add(lbDatum);

        bgFilter.add(rbTrainer);
        rbTrainer.setText("Trainer");
        jPanel1.add(rbTrainer);

        cboxDatum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboxDatum);

        bgFilter.add(rbSpieler);
        rbSpieler.setText("Spieler");
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
        jScrollPane1.setViewportView(personTable);

        getContentPane().add(jScrollPane1);

        jMenu1.setText("Datei");

        miSpeichern.setText("Speichern");
        miSpeichern.setActionCommand("Speichern");
        jMenu1.add(miSpeichern);

        miLaden.setText("Laden");
        miLaden.setActionCommand("Laden");
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

        miStammbaum.setText("Grafischen \"Stammbaum\" anzeigen");
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
            lbDatum.setVisible(true);
            cboxDatum.setVisible(true);
        } else {
            lbDatum.setVisible(false);
            cboxDatum.setVisible(false);
        }
    }//GEN-LAST:event_cbMannschaftActionPerformed

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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDatum;
    private javax.swing.JMenuItem miBeenden;
    private javax.swing.JMenuItem miLaden;
    private javax.swing.JMenuItem miREADME;
    private javax.swing.JMenuItem miSpeichern;
    private javax.swing.JMenuItem miStammbaum;
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
        if(rbSpieler.isSelected()) {
            cbMannschaft.setVisible(true);
        } else {
            setAllInvisible();
        }
    }
}