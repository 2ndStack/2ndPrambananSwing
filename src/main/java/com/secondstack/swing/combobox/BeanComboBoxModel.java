/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 5, 2010
 */

package com.secondstack.swing.combobox;

import com.secondstack.swing.engine.BeanClass;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Latief Al Amin
 * @since Oct 5, 2010
 */
public class BeanComboBoxModel extends AbstractListModel implements ComboBoxModel{

    private List beanList;
    private boolean [] fieldVisible = {};
    private String separator = " - ";
    private int indexSelected = -1;

    public BeanComboBoxModel(List beanList) {
        this.beanList = beanList;
    }

    public BeanComboBoxModel(List beanList, boolean[] fieldVisible, String separator) {
        this.beanList = beanList;
        this.fieldVisible = fieldVisible;
        this.separator = separator;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem != null && !anItem.equals(getSelectedItem()) ||
                indexSelected == -1 && anItem != null){
            for(int i=0;i<getSize();i++)
                if(getElementAt(i).equals(anItem))
                    indexSelected = i;
            fireContentsChanged(this, -1, -1);
            return;
        }
        if(anItem == null){
            indexSelected = -1;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        if(indexSelected == -1)
            return null;
        return getElementAt(indexSelected);
    }

    @Override
    public int getSize() {
        return beanList.size();
    }

    @Override
    public Object getElementAt(int index) {
        String string = "";
        int fieldCount = BeanClass.fields(beanList.get(index)).length;
        for(int i=0;i<fieldCount || i < fieldVisible.length;i++){
            if(fieldVisible.length == 0 || fieldVisible == null)
                string += BeanClass.getterMethod(beanList.get(index), i) + separator;
            else{
                if(fieldVisible[i])
                    string += BeanClass.getterMethod(beanList.get(index), i) + separator;
            }
        }

        if(string.endsWith(separator))
            string = string.substring(0, string.length()-separator.length());
        return string;
    }

    public List getBeanList() {
        return beanList;
    }

    public void setBeanList(List beanList) {
        this.beanList = beanList;
    }

    public boolean[] getFieldVisible() {
        return fieldVisible;
    }

    public void setFieldVisible(boolean[] fieldVisible) {
        this.fieldVisible = fieldVisible;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

}
