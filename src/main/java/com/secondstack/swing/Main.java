package com.secondstack.swing;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        String s = "allatief04032@gmail.com";
        System.out.println("_a".matches("\\w*"));
        System.out.println(s.matches("\\p{Alpha}(\\w)*\\p{Alnum}@\\p{Lower}(\\p{Lower}|\\.)*\\p{Lower}"));
    }
}
