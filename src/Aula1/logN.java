package Aula1;

import java.io.*;

public class logN
{

    public static int f(int n)
    {
        int c = 0;
        for (int i = n; i > 0; i /= 2)
        {
            c++;
        }
        return c;
    }

    public static void main(String[] args)
    {
        try
        {
            FileWriter fstream = new FileWriter("complex.csv");
            BufferedWriter out = new BufferedWriter(fstream);
            for (int k = 1; k <= 200; k++)
            {
                out.write(k + ";" + f(k) + '\n');
            }
            out.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
