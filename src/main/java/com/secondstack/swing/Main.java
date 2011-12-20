package com.secondstack.swing;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Object o = 0F;
        Number number = (Number)o;
        System.out.println(number.getClass());
        System.out.println(number instanceof Float);
    }
}
