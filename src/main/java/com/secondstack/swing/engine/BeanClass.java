/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package com.secondstack.swing.engine;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Class ini untuk operasi Class JavaBean. Yang mana Class Java Bean bersifat umum
 * sehingga tidak diketahui Field nya serta setter dan getternya. Class ini akan
 * mengoperasikan setter dan getter dari class JavaBean di package
 * <code>pbb.gui.swing.table.bean</code>
 *
 * @author Latief Al Amin
 */
public class BeanClass {

    /**
     *
     * Fungsi ini untuk mendapatkan Field-Field dari Object JavaBean.
     *
     * @param beanClass Object JavaBean yang akan dicari Field nya
     * @return
     */
    public static Field [] fields(Object beanClass){
        if(beanClass == null)
            return null;

        //getting fields
        return beanClass.getClass().getDeclaredFields();
    }

    /**
     *
     * Fungsi ini untuk mendapatkan Field di indek tertentu dari Object JavaBean.
     *
     * @param beanClass Object JavaBean yang akan dicari Field nya
     * @param fieldIndex index Field yang ingin didapatkan
     * @return Field
     */
    public static Field field(Object beanClass,int fieldIndex){
         if (beanClass == null || fieldIndex < 0)
            return null;

        //getting fields
        Field [] fields = fields(beanClass);
        //get field and then get getter method
        return fields[fieldIndex];
    }

    /**
     *
     * Fungsi ini untuk mendapatkan Nama Field di indek tertentu dari Object JavaBean.
     *
     * @param beanClass Object JavaBean yang akan dicari Field nya
     * @param fieldIndex index Field yang ingin didapatkan
     * @return Field
     */
    public static String fieldName(Object beanClass,int fieldIndex){
        //get field and then get getter method
        return field(beanClass,fieldIndex).getName();
    }

    /**
     *
     * Fungsi untuk mengeksekusi fungsi getter Object JavaBean
     *
     * @param beanClass Object JavaBean
     * @param fieldIndex index field yang akan dieksekusi getter-nya
     * @return Object Hasil eksekusi fungsi getter
     */
    public static Object getterMethod(Object beanClass,int fieldIndex) {
        //get field and then get getter method
        Field field = field(beanClass, fieldIndex);
        String fieldName = field.getName();
        String getterName = "";
        if(field.getType().getName().endsWith("boolean"))
                //|| field.getType().getName().endsWith("java.lang.Boolean"))
            getterName = "is" + fieldName.substring(0, 1).toUpperCase() +
                fieldName.substring(1);
        else
            getterName = "get" + fieldName.substring(0, 1).toUpperCase() +
                fieldName.substring(1);

        //object to return value
        Object value = null;
        //get return value from getter method
        try {
            value = beanClass.getClass().getDeclaredMethod(getterName, new Class[]{}).invoke(beanClass, new Object[]{});
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    /**
     *
     * Fungsi untuk mengeksekusi fungsi setter Object JavaBean
     *
     * @param beanClass Object JavaBean
     * @param fieldIndex index field yang akan dieksekusi setter-nya
     * @param newValue nilai baru untuk Field yang di-setter
     */
    public static void setterMethod(Object beanClass,int fieldIndex, Object newValue) {
        //get field and then get getter method
        String fieldName = fieldName(beanClass, fieldIndex);
        String setterName = "set" + fieldName.substring(0, 1).toUpperCase() +
                fieldName.substring(1);

        try {
            beanClass.getClass().getDeclaredMethod(setterName, new Class[]{newValue.getClass()})
                    .invoke(beanClass, new Object[]{newValue});
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BeanClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
