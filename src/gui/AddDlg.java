package gui;

import data.Person;
import data.Spieler;
import data.Trainer;
import data.Vorstand;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * JDialog AddDlg zum Hinzufügen von Personen.
 * 
 * @author herbe
 * @version 4.0
 */
public class AddDlg extends javax.swing.JDialog {
    
    private Person newPerson;
    private boolean isOkay = false;
    
    private JTextField tfMannschaftTr;
    private JTextField tfToreSaison;
    private JTextField tfToreGesamt;
    private JTextField tfTrikotNummer;
    private JTextField tfMannschaftSp;
    
    /**
     * Konstruktor für Klasse AddDlg.
     * 
     * @param parent parent for super(super, modal)
     * @param modal modal for super(super, modal)
     */
    public AddDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.tfMannschaftTr = new JTextField();
        this.tfToreSaison = new JTextField();
        this.tfToreGesamt = new JTextField();
        this.tfTrikotNummer = new JTextField();
        this.tfMannschaftSp = new JTextField();
    }

    /**
     * @return current newPerson
     */
    public Person getNewPerson() {
        return newPerson;
    }

    /**
     * @return current isOkay
     */
    public boolean isIsOkay() {
        return isOkay;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPerson = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbVorstand = new javax.swing.JRadioButton();
        rbTrainer = new javax.swing.JRadioButton();
        rbSpieler = new javax.swing.JRadioButton();
        paChange = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfVorname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNachname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAlter = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfFunktion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btOk = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Person hinzufügen");
        getContentPane().setLayout(new java.awt.GridLayout(3, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Person"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        bgPerson.add(rbVorstand);
        rbVorstand.setSelected(true);
        rbVorstand.setText("Vorstand");
        rbVorstand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbVorstand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVorstandActionPerformed(evt);
            }
        });
        jPanel1.add(rbVorstand);

        bgPerson.add(rbTrainer);
        rbTrainer.setText("Trainer");
        rbTrainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTrainerActionPerformed(evt);
            }
        });
        jPanel1.add(rbTrainer);

        bgPerson.add(rbSpieler);
        rbSpieler.setText("Spieler");
        rbSpieler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbSpieler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSpielerActionPerformed(evt);
            }
        });
        jPanel1.add(rbSpieler);

        getContentPane().add(jPanel1);

        paChange.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setText("Vorname:");
        paChange.add(jLabel1);
        paChange.add(tfVorname);

        jLabel2.setText("Nachname:");
        paChange.add(jLabel2);
        paChange.add(tfNachname);

        jLabel3.setText("Alter:");
        paChange.add(jLabel3);
        paChange.add(tfAlter);

        jLabel4.setText("Funktion:");
        paChange.add(jLabel4);
        paChange.add(tfFunktion);

        getContentPane().add(paChange);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        btOk.setText("Übernehmen");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onOk(evt);
            }
        });
        jPanel3.add(btOk);

        btCancel.setText("Abbrechen");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        jPanel3.add(btCancel);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Wird beim Klick auf Button Abbrechen aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        isOkay = false;
        this.dispose();
    }//GEN-LAST:event_onCancel
    
    /**
     * Wird beim Klick auf Button Übernehmen aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void onOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onOk
        try {
             if(tfVorname.getText().equals("") || tfNachname.getText().equals("") || 
                    tfAlter.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen!", 
                        "Warnung", JOptionPane.WARNING_MESSAGE);
                throw new Exception();
            } else {
                String vorname = tfVorname.getText();
                String nachname = tfNachname.getText();
                int alter = Integer.parseInt(tfAlter.getText());
                if(rbVorstand.isSelected()) {
                    if(tfFunktion.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen!", 
                        "Warnung", JOptionPane.WARNING_MESSAGE);
                        throw new Exception();
                    } else {
                        String funktion = tfFunktion.getText();
                        newPerson = new Vorstand(vorname, nachname, alter, funktion);
                    }
                } else if(rbTrainer.isSelected()) {
                    if(tfMannschaftTr.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen!", 
                        "Warnung", JOptionPane.WARNING_MESSAGE);
                        throw new Exception();
                    } else {
                        String mannschaftTr = tfMannschaftTr.getText();
                        newPerson = new Trainer(vorname, nachname, alter, mannschaftTr);
                    }
                } else {
                    if(tfToreSaison.getText().equals("") || tfToreGesamt.getText().equals("")
                            || tfTrikotNummer.getText().equals("") || tfMannschaftSp.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen!", 
                        "Warnung", JOptionPane.WARNING_MESSAGE);
                        throw new Exception();
                    } else {
                        int toreSaison = Integer.parseInt(tfToreSaison.getText());
                        int toreGesamt = Integer.parseInt(tfToreGesamt.getText());
                        int trikotNummer = Integer.parseInt(tfTrikotNummer.getText());
                        String mannschaftSp = tfMannschaftSp.getText();
                        newPerson = new Spieler(vorname, nachname, alter, 
                                toreSaison, toreGesamt, trikotNummer, mannschaftSp);
                    }
                }
                this.isOkay = true;
                this.dispose();
            }
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Zahlen richtig eingeben!", 
                    "Fehler", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex) {
            //Do nix
        }
    }//GEN-LAST:event_onOk

    /**
     * Wird beim Klick auf RadioButton Vorstand aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbVorstandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVorstandActionPerformed
        paChange.removeAll();
        clearTextFields();
        paChange.setLayout(new GridLayout(4, 2));
        paChange.add(new JLabel("Vorname:"));
        paChange.add(tfVorname);
        paChange.add(new JLabel("Nachname:"));
        paChange.add(tfNachname);
        paChange.add(new JLabel("Alter:"));
        paChange.add(tfAlter);
        paChange.add(new JLabel("Funktion:"));
        paChange.add(tfFunktion);
        pack();
        repaint();
    }//GEN-LAST:event_rbVorstandActionPerformed

    /**
     * Wird beim Klick auf RadioButton Trainer aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTrainerActionPerformed
        paChange.removeAll();
        clearTextFields();
        paChange.setLayout(new GridLayout(4, 2));
        paChange.add(new JLabel("Vorname:"));
        paChange.add(tfVorname);
        paChange.add(new JLabel("Nachname:"));
        paChange.add(tfNachname);
        paChange.add(new JLabel("Alter:"));
        paChange.add(tfAlter);
        paChange.add(new JLabel("Mannschaft:"));
        paChange.add(tfMannschaftTr);
        pack();
        repaint();
    }//GEN-LAST:event_rbTrainerActionPerformed

    /**
     * Wird beim Klick auf RadioButton Spieler aufgerufen.
     * 
     * @param evt Übergebenes ActionEvent
     */
    private void rbSpielerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSpielerActionPerformed
        paChange.removeAll();
        clearTextFields();
        paChange.setLayout(new GridLayout(7, 2));
        paChange.add(new JLabel("Vorname:"));
        paChange.add(tfVorname);
        paChange.add(new JLabel("Nachname:"));
        paChange.add(tfNachname);
        paChange.add(new JLabel("Alter:"));
        paChange.add(tfAlter);
        paChange.add(new JLabel("Tore | Saison:"));
        paChange.add(tfToreSaison);
        paChange.add(new JLabel("Tore | Gesamt:"));
        paChange.add(tfToreGesamt);
        paChange.add(new JLabel("Trikotnummer:"));
        paChange.add(tfTrikotNummer);
        paChange.add(new JLabel("Mannschaft:"));
        paChange.add(tfMannschaftSp);
        pack();
        repaint();
    }//GEN-LAST:event_rbSpielerActionPerformed

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
            java.util.logging.Logger.getLogger(AddDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDlg dialog = new AddDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPerson;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel paChange;
    private javax.swing.JRadioButton rbSpieler;
    private javax.swing.JRadioButton rbTrainer;
    private javax.swing.JRadioButton rbVorstand;
    private javax.swing.JTextField tfAlter;
    private javax.swing.JTextField tfFunktion;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables

    /**
     * Zum Clearen der Textfelder.
     */
    private void clearTextFields() {
        tfVorname.setText("");
        tfNachname.setText("");
        tfAlter.setText("");
        tfFunktion.setText("");
        tfMannschaftTr.setText("");
        tfToreSaison.setText("");
        tfToreGesamt.setText("");
        tfTrikotNummer.setText("");
        tfMannschaftSp.setText("");
    }
}