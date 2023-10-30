package ge.itstep.demo;

public class ClassWork19 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(1);
        list.push(2);
        list.push(3);
        list.print();
    }

}

class LinkedList {
    Node node;

    public void push(int y) {
        Node newNode = new Node(y);
        newNode.next = newNode;
        node = newNode;
    }

    public void print() {
        Node current = node;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int x) {
        this.data = x;
        this.next = null;
    }
}
