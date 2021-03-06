/*
 * created : Nov 18, 2011
 * by : Latief
 */

/*
 * PanelCellPerson.java
 *
 * Created on Nov 18, 2011, 1:21:50 PM
 */
package com.secondstack.swing.table;

import com.secondstack.swing.Person;

/**
 *
 * @author Latief
 */
public class PanelCellPerson extends PanelCell {

    /** Creates new form PanelCellPerson */
    public PanelCellPerson() {
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

        labelName = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textAddress = new javax.swing.JTextField();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        labelName.setText("Nama :");

        labelAddress.setText("Alamat : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelName)
                    .addComponent(labelAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textName, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(textAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAddress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        System.out.println("sdafasdfasdfasdfsdf");
    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
    Person person;

    @Override
    public Object getValue() {
        if (person == null) {
            person = new Person();
        }

        person.setNama(textName.getText());
        person.setAlamat(textAddress.getText());

        return person;
    }

    @Override
    public void setValue(Object value) {
        this.person = (Person)value;
        if (person != null) {
            textName.setText(person.getNama());
            textAddress.setText(person.getAlamat());
        }
    }

    @Override
    public void requestDefaultFocusComponent() {
        textName.requestFocusInWindow();
    }
}
