/*
 * created : Aug 19, 2011
 * by : Latief
 */

/*
 * FrameTest.java
 *
 * Created on Aug 19, 2011, 9:19:31 PM
 */
package com.secondstack.swing;

/**
 *
 * @author Latief
 */
public class FrameTest extends javax.swing.JFrame {

    /** Creates new form FrameTest */
    public FrameTest() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPanel1 = new com.secondstack.swing.panel.JPPanel();
        jPPanel2 = new com.secondstack.swing.header.JPHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPPanel1Layout = new javax.swing.GroupLayout(jPPanel1);
        jPPanel1.setLayout(jPPanel1Layout);
        jPPanel1Layout.setHorizontalGroup(
            jPPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPPanel1Layout.setVerticalGroup(
            jPPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.secondstack.swing.panel.JPPanel jPPanel1;
    private com.secondstack.swing.header.JPHeader jPPanel2;
    // End of variables declaration//GEN-END:variables
}
