package aula8;

import java.util.ArrayList;

public class ArrayBinaryTree
{
    private ArrayList<String> array;
    private int capacity;

    public ArrayBinaryTree(String s)
    {
        this.array = new ArrayList<String>();
        this.capacity = 15 + 1;
        for (int i = 0; i < this.capacity; i++)
        {
            this.array.add(null);
        }
        this.array.set(1, s);
    }

    public int getRoot()
    {
        return 1;
    }

    public String getElement(int i)
    {
        return this.array.get(i);
    }

    public int parent(int i)
    {
        return i / 2;
    }

    public int left(int i)
    {
        return 2 * i;
    }

    public int right(int i)
    {
        return 2 * i + 1;
    }

    public int addLeftChild(int p, String s)
    {
        int l = left(p);
        this.array.set(l, s);
        return l;
    }

    public int addRightChild(int p, String s)
    {
        int r = right(p);
        this.array.set(r, s);
        return r;
    }
}
