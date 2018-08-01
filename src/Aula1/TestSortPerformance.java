import java.util.*;

public class TestSortPerformance
{
    public static void insertion_sort(ArrayList<Integer> a)
    {
        for (int j = 1; j < a.size(); j++)
        {
            int tmp = a.get(j);
            int i = j - 1;
            while (i >= 0 && a.get(i) > tmp)
            {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, tmp);
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        int i, n = 1000;
        long start;
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2;

        for (i = 0; i < n; i++)
        {
            array1.add((int)(Math.random() * n));
        }
        array2 = (ArrayList<Integer>) array1.clone();

        System.out.println("Time sorting " + n + " integers (in seconds)");

        start = System.currentTimeMillis();
        insertion_sort(array1);        
        System.out.println("  Insertion sort: " + (System.currentTimeMillis() - start) / 1000.0);

        start = System.currentTimeMillis();
        Collections.sort(array2);        
        System.out.println("  Merge sort:     " + (System.currentTimeMillis() - start) / 1000.0);
    }
}
