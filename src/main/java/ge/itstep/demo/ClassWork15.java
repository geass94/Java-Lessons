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

        Node result = root.find(15);
        System.out.println(result.toString());
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node (int v)
    {
        this.value = v;
        this.left = null;
        this.right = null;
    }

    public Node find(int v) {
        Node current = this;

        while (current != null) {
            if (v == current.value) {
                return current; // Found the node with the value
            } else if (v < current.value) {
                current = current.left; // Search in the left subtree
            } else {
                current = current.right; // Search in the right subtree
            }
        }

        return null; // Node with the value 'v' not found
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}