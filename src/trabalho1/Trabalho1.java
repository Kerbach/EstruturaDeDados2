package trabalho1;

import trabalho1.ArrayBinaryTree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trabalho1
{

    public static Node n = new Node();
    public static ArrayBinaryTree tree = new ArrayBinaryTree(n);
    public static int count = 0;

    public static void main(String[] args)
    {
        String arquivo = "dataset-b-small.txt";
        String linha = "";
        String delimitador = " ";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo)))
        {
            while ((linha = br.readLine()) != null)
            {
                String[] tl = linha.split(delimitador);
                addNode(tl);
            }
            int t = getValue(tree.getRoot());
            System.out.println("Altura: " + tree.altura(tree.getRoot()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void addNode(String[] tl)
    {
        int element = 1;
        int parent = 1;

        for (int i = 0; i < tl.length; i++)
        {
            if (tl[i].equals(":"))
            {
                continue;
            }
            if (tl[tl.length - 1].equals(tl[i]))
            {
                int value = Integer.parseInt(tl[i].replace("[", "").replace("]", ""));
                tree.getElement(parent).setValue(value);
                continue;
            }

            tree.getElement(element).setName(tl[i]);
            Node left = tree.getElement(tree.leftChild(element));
            Node right = tree.getElement(tree.rightChild(element));

            if ((i + 2) > (tl.length - 1))
            {
                parent = element;
                continue;
            }
            if (left.getName().equals(tl[i + 2]) || !tree.hasLeftChild(element))
            {
                parent = element;
                element = tree.leftChild(element);
                continue;
            }
            if (right.getName().equals(tl[i + 2]) || !tree.hasRightChild(element))
            {
                parent = element;
                element = tree.rightChild(element);
                continue;
            }
        }
    }

    public static int getValue(int i)
    {
        Node n = tree.getElement(i);
        int t = tree.getElement(i).getValue();
        if (tree.hasLeftChild(i))
        {
            t += getValue(tree.leftChild(i));
        }
        if (tree.hasRightChild(i))
        {
            t += getValue(tree.rightChild(i));
        }
        System.out.println(n.getName() + " " + t);
        return t;
    }
}
