/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8;

/**
 *
 * @author wrkerber
 */
public class Combinatorics
{
    public static void binary (int n, String s)
    {
        // BASE
        if (n == 0)
        {
            System.out.println(s);
        }
        else // General
        {
            binary(n-1, s + "0");
            binary(n-1, s + "1");
        }
    }
    
    public static void abc_tuple(int n, String s)
    {
        // BASE
        if (n == 0)
        {
            System.out.println(s);
        }
        else // General
        {
            abc_tuple(n-1, s + "a");
            abc_tuple(n-1, s + "b");
            abc_tuple(n-1, s + "c");
            abc_tuple(n-1, s + "d");
            abc_tuple(n-1, s + "e");
        }
    }
    
    public static void main(String[] args)
    {
        // binary(3, "");
        abc_tuple(4, "");
    }
}
