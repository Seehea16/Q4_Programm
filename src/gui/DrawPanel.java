package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * JPanel DrawPanel zum Zeichnen des grafischen Stammbaums.
 * 
 * @author herbe
 * @version 6.0
 */
public class DrawPanel extends javax.swing.JPanel {

    /**
     * Konstruktor für JPanel DrawPanel.
     */
    public DrawPanel() {
        initComponents();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder("Zeichenfläche"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        //Todo
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
