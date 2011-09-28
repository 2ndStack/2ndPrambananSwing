/*
 * created : Sep 26, 2011
 * by : Latief
 */
package com.secondstack.swing.table;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Latief
 */
public class JPTable extends JTable{
    private List list;
    private String [] columnHeader;
    BeanTableModel model;

    public JPTable() {
        super();
        model = new BeanTableModel();
    }

    /**
     * Menampilkan Daftar data ke dalam JTable.
     */
    public void reModel() {
//        BeanTableModel modelTemp = new BeanTableModel();
//        modelTemp.setBeanList(list);
//        modelTemp.setCheckAll(model.isCheckAll());
//        modelTemp.setCheckColumnName(model.getCheckColumnName());
//        //modelTemp.setCheckValue(model.getCheckValue());
//        modelTemp.setColumnEditable(model.getColumnEditable());
//        modelTemp.setColumnVisible(model.getColumnVisible());
//        modelTemp.setWithCheck(model.isWithCheck());
//        model = modelTemp;
        setModel(model);
    }

    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
        if(dataModel instanceof BeanTableModel)
            this.model = (BeanTableModel) dataModel;
    }
    
    /**
     * Dapatkan beanList yang tercentang.
     */
    public List getBeanListCheck(){
        return model.getBeanListCheck();
    }
    
    /**
     * Dapatkan kunci dari beanList yang tercentang.
     * @return 
     */
    public List<String> getBeanListCheckKey(){
        return model.getBeanListCheckKey();
    }
    
    /**
     * Dapatkan nilai dari Bean Object pada baris table yang disorot.
     * @return 
     */
    public Object getSelectedBean(){
        if(getSelectedRow() == -1)
            return null;
        
        return model.getSelectedBean(getSelectedBeanKey());
    }
    
    /**
     * Dapatkan kunci dari Bean Object pada table yang disorot.
     * @return 
     */
    public String getSelectedBeanKey(){
        if(getSelectedRow() == -1)
            return null;
        String key = "";
        
        for(int col = (isWithCheck() ? 1 : 0)
                ;col < getColumnCount(); col++){
            key = key + getValueAt(getSelectedRow(), col);
        }
        
        return key;
    }
    
    public List getList() {
        return model.getBeanList();
    }

    public void setList(List list) {
        model.setBeanList(list);
    }

    public String[] getColumnHeader() {
        return model.getColumnNames();
    }

    public void setColumnHeader(String[] columnHeader) {
        model.setColumnNames(columnHeader);
    }
    
    /**
     * Apakah TableModel dengan auto checked?
     * @return 
     */
    public boolean isWithCheck() {
        return model.isWithCheck();
    }

    /**
     * setting untuk menambahkan auto checked jika bernilai true
     * @param withCheck 
     */
    public void setWithCheck(boolean withCheck) {
        model.setWithCheck(withCheck);
    }

    public String getCheckColumnName() {
        return model.getCheckColumnName();
    }

    public void setCheckColumnName(String checkColumnName) {
        model.setCheckColumnName(checkColumnName);
    }

    public Boolean[] getCheckValue() {
        return model.getCheckValue();
    }

    public void setCheckValue(Boolean[] checkValue) {
        model.setCheckValue(checkValue);
    }

    public boolean isCheckAll() {
        return model.isCheckAll();
    }

    public void setCheckAll(boolean checkAll) {
        model.setCheckAll(checkAll);
    }
    
    public boolean[] getColumnEditable() {
        return model.getColumnEditable();
    }

    public void setColumnEditable(boolean[] columnEditable) {
        model.setColumnEditable(columnEditable);
    }
    
    public Class[] getColumnClass() {
        return model.getColumnClass();
    }

    public void setColumnClass(Class[] columnClass) {
        model.setColumnClass(columnClass);
    }

    public boolean[] getColumnVisible() {
        return model.getColumnVisible();
    }

    public void setColumnVisible(boolean[] columnVisible) {
        model.setColumnVisible(columnVisible);
    }
}
