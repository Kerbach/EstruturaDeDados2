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
public class Latin3Solver
{
    public static void main(String[] args)
    {
        solve(new Latin3State());
    }
    
    public static void solve (final Latin3State state)
    {
        boolean found = false;
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col ++)
            {
                if (state.m[row][col] == '-')
                {
                    found = true;
                    break;
                }
            }
            if (found == true)
            {
                break;
            }
        }
        
        if (found == false)
        {
            if (state.isValid())
            {
                System.out.println("Solution found!");
            }
        }
        else
        {
            // Copiar state para state_a e jogar em solve(state_a)
            // Copiar state para state_b e jogar em solve(state_b)
            // Copiar state para state_c e jogar em solve(state_c)
            
        }
    }
}
