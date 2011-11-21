/*
 * created : Nov 18, 2011
 * by : Latief
 */
package com.secondstack.swing.table;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Latief
 */
public class ObjectTableCellEditor extends AbstractCellEditor implements TableCellEditor{

    protected PanelCell panelCell;

    public ObjectTableCellEditor(PanelCell panelCell) throws InstantiationException, IllegalAccessException {
        this.panelCell = panelCell.getClass().newInstance();
    }

    @Override
    public Object getCellEditorValue() {
        return panelCell.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        panelCell.setSelected(isSelected);
//        if(!isSelected)
        panelCell.setValue(value);
        return panelCell;
    }

    public PanelCell getPanelCell() {
        return panelCell;
    }

    public void setPanelCell(PanelCell panelCell) {
        this.panelCell = panelCell;
    }

}
