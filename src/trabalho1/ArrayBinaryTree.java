package trabalho1;

import java.util.*;

public class ArrayBinaryTree
{

    private ArrayList<Node> array;
    private int size;

    public ArrayBinaryTree(Node node)
    {
        this.array = new ArrayList<Node>();
        for (int i = 0; i < 1024; i++)
        {
            Node n = new Node();
            n.setName(" ");
            this.array.add(n);
        }
        this.array.set(1, node);
        this.size = 1;
    }

    public int getRoot()
    {
        return 1;
    }

    public Node getElement(int i)
    {
        return this.array.get(i);
    }

    public void putElement(int i, Node n)
    {
        if (i == 1 || hasParent(i))
        {
            this.array.set(i, n);
            this.size++;
        }
    }

    public int addLeftChild(int i, Node n)
    {
        this.array.set(i * 2, n);
        this.size++;
        return i * 2;
    }

    public int addRightChild(int i, Node n)
    {
        this.array.set(i * 2 + 1, n);
        this.size++;
        return i * 2 + 1;
    }

    public void print()
    {
        for (int i = 1; i < 32; i++)
        {
            System.out.print(this.array.get(i).getName());
        }
        System.out.println();
    }

    public boolean isRoot(int i)
    {
        return i == 1;
    }

    public boolean isExternal(int i)
    {
        return this.array.get(2 * i).getName().equals(" ")
                && this.array.get(2 * i + 1).getName().equals(" ");
    }

    public boolean isInternal(int i)
    {
        return !isExternal(i);
    }

    public int getSize()
    {
        return this.size;
    }

    public int pai(int i)
    {
        return i / 2;
    }

    public int filhoEsquerda(int i)
    {
        return i * 2;
    }

    public int filhoDireita(int i)
    {
        return i * 2 + 1;
    }

    public boolean hasParent(int i)
    {
        return i != 1;
    }

    public boolean hasLeftChild(int i)
    {
        return !this.array.get(i * 2).getName().equals(" ");
    }

    public boolean hasRightChild(int i)
    {
        return !this.array.get(i * 2 + 1).getName().equals(" ");
    }

    public void prefixSearch(int i)
    {
        System.out.print(getElement(i));
        if (hasLeftChild(i))
        {
            prefixSearch(filhoEsquerda(i));
        }
        if (hasRightChild(i))
        {
            prefixSearch(filhoDireita(i));
        }
    }

    public void infixSearch(int i)
    {
        if (hasLeftChild(i))
        {
            infixSearch(filhoEsquerda(i));
        }
        System.out.print(getElement(i));
        if (hasRightChild(i))
        {
            infixSearch(filhoDireita(i));
        }
    }

    public void postfixSearch(int i)
    {
        if (hasLeftChild(i))
        {
            postfixSearch(filhoEsquerda(i));
        }
        if (hasRightChild(i))
        {
            postfixSearch(filhoDireita(i));
        }
        System.out.print(getElement(i));
    }

    public int profundidade(int i)
    {
        int d = 0;
        while (!isRoot(i))
        {
            i = i / 2;
            d++;
        }
        return d;
    }

    public int altura(int i)
    {
        if (isExternal(i))
        {
            return 0;
        }
        int l = 0, r = 0;
        if (!this.array.get(2 * i).getName().equals(" "))
        {
            l = altura(2 * i);
        }
        if (!this.array.get(2 * i + 1).getName().equals(" "))
        {
            r = altura(2 * i + 1);
        }
        return Math.max(r, l) + 1;
    }

    public int diametro(int i)
    {
        if (isExternal(i))
        {
            return 0;
        }
        int d1 = altura(i) + 3;
        int l = 0, r = 0;
        if (!this.array.get(2 * i).getName().equals(" "))
        {
            l = diametro(2 * i);
        }
        if (!this.array.get(2 * i + 1).getName().equals(" "))
        {
            r = diametro(2 * i + 1);
        }
        return Math.max(d1, Math.max(l, r));
    }
}
