package ge.itstep.demo;

public class ClassWork15 {
    public static void main(String[] args) {

        NodeNode root = new NodeNode(10);

        root.left = new NodeNode(5);
        root.right = new NodeNode(15);


        root.left.left = new NodeNode(3);
        root.left.right = new NodeNode(7);

        root.right.left = new NodeNode(12);
        root.right.right = new NodeNode(28);

        NodeNode result = root.find(15);
        System.out.println(result.toString());
    }


}

class NodeNode {
    int value;
    NodeNode left;
    NodeNode right;

    public NodeNode (int v)
    {
        this.value = v;
        this.left = null;
        this.right = null;
    }

    public NodeNode find(int v) {
        NodeNode current = this;

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