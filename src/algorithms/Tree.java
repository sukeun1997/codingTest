package algorithms;

import org.w3c.dom.Node;

import java.net.Socket;

public class Tree<T> {

    int size = 0;

    public class Node<T> {

        private T data;
        private Node<T> right;
        private Node<T> left;

        public Node(T data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }

        public void addLeft(Node<T> node) {
            size++;
            left = node;
        }

        public void addRight(Node<T> node) {
            size++;
            right = node;
        }


        public void deleteLeft() {
            left = null;
            size--;
        }

        public void deleteRight() {
            right = null;
            size--;
        }
    }

    public Node<T> addNode(T data) {
        Node<T> node = new Node<>(data);
        return node;
    }

    public void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }


    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        Tree<Integer>.Node<Integer> node1 = tree.addNode(1);
        Tree<Integer>.Node<Integer> node2 = tree.addNode(2);
        Tree<Integer>.Node<Integer> node3 = tree.addNode(3);
        Tree<Integer>.Node<Integer> node4 = tree.addNode(4);
        Tree<Integer>.Node<Integer> node5 = tree.addNode(5);
        Tree<Integer>.Node<Integer> node6 = tree.addNode(6);
        Tree<Integer>.Node<Integer> node7 = tree.addNode(7);

        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        tree.preOrder(node1);
        System.out.println();
        tree.inOrder(node1);
        System.out.println();
        tree.postOrder(node1);

    }

}
