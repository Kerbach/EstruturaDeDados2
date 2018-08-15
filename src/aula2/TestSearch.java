package aula2;

public class TestSearch
{

    public static void preorder(Node n)
    {
        // 1.node
        System.out.println(n.element);
        
        // 2. left
        if (n.left != null)
        {
            preorder(n.left);
        }
        
        // 3. right
        if (n.right != null)
        {
            preorder(n.right);
        }
    }
    
    public static void inorder (Node n)
    {
        // 1. left
        if (n.left != null)
        {
            inorder(n.left);
        }
        
        // 2.node
        System.out.println(n.element);
        
        // 3. right
        if (n.right != null)
        {
            inorder(n.right);
        }
    }
    
    private static void postorder(Node n)
    {
        // 1. left
        if (n.left != null)
        {
            postorder(n.left);
        }
        
        // 2. right
        if (n.right != null)
        {
            postorder(n.right);
        }
        
        // 3.node
        System.out.println(n.element);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree("A");
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "B");
        Node c = tree.addRightChild(a, "C");
        Node d = tree.addRightChild(b, "D");
        
        preorder(a);
        System.out.println("---------- \n");
        inorder(a);
        System.out.println("---------- \n");
        postorder(a);
        
    }

}
