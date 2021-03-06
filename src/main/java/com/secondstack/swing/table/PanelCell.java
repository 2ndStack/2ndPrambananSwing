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

import com.secondstack.swing.panel.JPPanelTransparency;
import com.secondstack.swing.table.listener.CellValueChangedListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Latief
 */
public abstract class PanelCell extends JPPanelTransparency {

    /** Creates new form PanelCellPerson */
    public PanelCell() {
        initComponents();
        setAlphaTransparency(0F);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        System.out.println("sadasdasdasdasd");
    }//GEN-LAST:event_formFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private boolean selected = false;
    protected List<CellValueChangedListener> cellValueChangedListeners;

    public abstract Object getValue();

    public abstract void setValue(Object value);
    
    public abstract void requestDefaultFocusComponent();

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setAlphaTransparency(0.5F);
            requestFocusInWindow();
            requestDefaultFocusComponent();
        } else {
            setAlphaTransparency(0F);
        }
    }
    
    public boolean isSelected(){
        return this.selected;
    }
    
    public void addCellValueChanngedListener(CellValueChangedListener cellValueChangedListener){
        if(cellValueChangedListeners == null){
            cellValueChangedListeners = new ArrayList<CellValueChangedListener>();
        }
        cellValueChangedListeners.add(cellValueChangedListener);
    }
    
    protected void fireValueChanged(){
        if(cellValueChangedListeners == null){
            return;
        }
        
        for(CellValueChangedListener cellValueChangedListener:cellValueChangedListeners){
            cellValueChangedListener.fireValueChanged();
        }
    }
}
