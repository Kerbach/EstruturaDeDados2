package aula2;

public class JsonTree
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
    
    public static String serialize(Node n)
    {
        if (n == null) {
            return "null";
        }
        StringBuilder ser = new StringBuilder();
        ser.append("[");
        ser.append("\"" + n.element + "\"");
        ser.append(",");
        ser.append(serialize(n.left) + ",");
        ser.append(serialize(n.right));
        ser.append("]");
        return ser.toString();
    }

    public static void main(String[] args)
    {
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
        
        System.out.println(serialize(a));
        
    }

}
