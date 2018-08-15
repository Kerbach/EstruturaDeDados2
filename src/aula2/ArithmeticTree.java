package aula2;

public class ArithmeticTree
{

    public static void preorder(Node n)
    {
        // 1.node
        System.out.print(n.element);
        
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
        if (n.isInternal())
        {
            System.out.print("(");
        }
        
        // 1. left
        if (n.left != null)
        {
            inorder(n.left);
        }
        
        // 2.node
        System.out.print(n.element);
        
        // 3. right
        if (n.right != null)
        {
            inorder(n.right);
        }
        
        if (n.isInternal())
        {
            System.out.print(")");
        }
    }
    
    private static double postorder(Node n)
    {
        // n is external --> return value of n.elemnt
        if (n.isExternal())
        {
            double v = Double.parseDouble(n.element);
            return v;
        }
        // 1. left --> store value
        double l = postorder(n.left);
        // 2. right --> store value
        double r = postorder(n.right);
        // 3.node --> execute calculation and return
        if      (n.element.equals("+")) return l + r;
        else if (n.element.equals("-")) return l - r;
        else if (n.element.equals("*")) return l * r;
        else                            return l / r;
    }

    public static void main(String[] args)
    {
        /*
        BinaryTree tree = new BinaryTree("A");
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "B");
        Node c = tree.addrightChild(a, "C");
        Node d = tree.addrightChild(b, "D");
        
        preorder(a);
        System.out.println("---------- \n");
        inorder(a);
        System.out.println("---------- \n");
        postorder(a);
        * */
        
        BinaryTree tree = new BinaryTree("+");
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "*");
        Node c = tree.addRightChild(a, "-");
        Node d = tree.addLeftChild(b, "+");
        Node e = tree.addRightChild(b, "5");
        Node f = tree.addLeftChild(c, "8");
        Node g = tree.addRightChild(c, "*");
        tree.addLeftChild(d, "1");
        tree.addRightChild(d, "4");
        tree.addLeftChild(g, "3");
        tree.addRightChild(g, "7");
        
        System.out.println(postorder(a));
        
        // System.out.println("");
        // inorder(a);
        // System.out.println("");
        // postorder(a);
    }

}
