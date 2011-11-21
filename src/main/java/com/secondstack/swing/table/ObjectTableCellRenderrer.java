/*
 * created : Nov 18, 2011
 * by : Latief
 */
package com.secondstack.swing.table;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Latief
 */
public class ObjectTableCellRenderrer implements TableCellRenderer {

    protected PanelCell panelCell;

    public ObjectTableCellRenderrer(PanelCell panelCell) throws InstantiationException, IllegalAccessException {
        this.panelCell = panelCell;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(!isSelected)
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
