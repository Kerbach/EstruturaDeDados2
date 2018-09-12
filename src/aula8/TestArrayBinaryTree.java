package aula8;

public class TestArrayBinaryTree
{
    public static ArrayBinaryTree tree;

    public static void preorder(int i)
    {
        System.out.println(tree.getElement(i));

        int l = tree.left(i);
        if (tree.getElement(l) != null)
        {
            preorder(l);
        }

        int r = tree.right(i);
        if (tree.getElement(r) != null)
        {
            preorder(r);
        }
    }

    public static void main(String[] args)
    {
        tree = new ArrayBinaryTree("A");
        int a = tree.getRoot();
        int b = tree.addLeftChild(a, "B");
        int c = tree.addRightChild(a, "C");
        int d = tree.addRightChild(b, "D");
        int e = tree.addLeftChild(c, "E");

        preorder(a);
    }
}
