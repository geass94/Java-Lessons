package ge.itstep.demo;

public class ClassWork15 {
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(28);

        Node result = root.find(12);

    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node (int v)
    {

    }

    public Node find(int v)
    {
        return this;
    }
}