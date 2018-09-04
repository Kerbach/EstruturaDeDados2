package trabalho1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trabalho1
{

    public static Node n = new Node();
    public static ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(n);
    public static int count = 0;
    private Node pai;

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
            int t = getValue(arrayBinaryTree.getRoot());
            System.out.println("Diâmetro: " + arrayBinaryTree.diameter(arrayBinaryTree.getRoot()));
            //System.out.println("Diâmetro: " + tree.getDiameter(tree.getRoot()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void addNode(String[] conjunto)
    {
        int elemento = 1;
        int pai = 1;

        for (int i = 0; i < conjunto.length; i++)
        {
            if (conjunto[i].equals(":"))
            {
                continue;
            }
            if (conjunto[conjunto.length - 1].equals(conjunto[i]))
            {
                int value = Integer.parseInt(conjunto[i].replace("[", "").replace("]", ""));
                arrayBinaryTree.getElement(pai).setValue(value);
                continue;
            }

            arrayBinaryTree.getElement(elemento).setName(conjunto[i]);
            Node left = arrayBinaryTree.getElement(arrayBinaryTree.leftChild(elemento));
            Node right = arrayBinaryTree.getElement(arrayBinaryTree.rightChild(elemento));

            if ((i + 2) > (conjunto.length - 1))
            {
                pai = elemento;
                continue;
            }
            if (left.getName().equals(conjunto[i + 2]) || !arrayBinaryTree.hasLeftChild(elemento))
            {
                pai = elemento;
                elemento = arrayBinaryTree.leftChild(elemento);
                continue;
            }
            if (right.getName().equals(conjunto[i + 2]) || !arrayBinaryTree.hasRightChild(elemento))
            {
                pai = elemento;
                elemento = arrayBinaryTree.rightChild(elemento);
                continue;
            }
        }
    }

    public static int getValue(int i)
    {
        Node n = arrayBinaryTree.getElement(i);
        int t = arrayBinaryTree.getElement(i).getValue();
        if (arrayBinaryTree.hasLeftChild(i))
        {
            t += getValue(arrayBinaryTree.leftChild(i));
        }
        if (arrayBinaryTree.hasRightChild(i))
        {
            t += getValue(arrayBinaryTree.rightChild(i));
        }
        System.out.println(n.getName() + " " + t);
        return t;
    }
}
