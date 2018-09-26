/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10;

/**
 *
 * @author wrkerber
 */
public class Latin3State
{
    public char[][] m = {{'-', '-', '-'},
                         {'-', '-', '-'},
                         {'-', '-', '-'}};
    
    public Latin3State() {}
    
    public boolean isValidRow (int row)
    {
        int a = 0, b = 0, c = 0;
        for (int col = 0; col < 3; col++)
        {
            if (m[row][col] == 'a') { a++;}
            if (m[row][col] == 'b') { b++;}
            if (m[row][col] == 'c') { c++;}
        }
        return a <= 1 && b <= 1 && c <= 1;
    }
    
    public boolean isValidCol (int col)
    {
        int a = 0, b = 0, c = 0;
        for (int row = 0; row < 3; row++)
        {
            if (m[row][col] == 'a') { a++;}
            if (m[row][col] == 'b') { b++;}
            if (m[row][col] == 'c') { c++;}
        }
        return a <= 1 && b <= 1 && c <= 1;
    }
    
    public boolean isValid()
    {
        return isValidRow(0) && isValidRow(1) &&
               isValidRow(2) && isValidCol(0) &&
               isValidCol(1) && isValidCol(2);  
    }
}
