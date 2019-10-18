package com.challenge.easy;

import java.util.Stack;

public class HeightBinaryTree {
    private HeightBinaryTree() {

    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeft()) + 1;
        int rightHeight = getHeight(node.getRight()) + 1;

        return Math.max(leftHeight, rightHeight);
    }

    public static Node getTree(String posfixOperation) {
        if (posfixOperation == null || posfixOperation.length() == 0) {
            return null;
        }

        String[] items = posfixOperation.split(" ");

        Stack<Node> valuesStack = new Stack<>();
        for (String item: items) {
            try {
                Integer value = Integer.parseInt(item);
                valuesStack.push(new Node<Integer>(value));
            } catch (NumberFormatException e) {
                Node left;
                Node right;
                Node node;
                switch (item) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        right = valuesStack.pop();
                        left = valuesStack.pop();
                        node = new Node(item, left, right);

                        valuesStack.push(node);
                        break;
                    case "!":
                        left = valuesStack.pop();
                        node = new Node(item, left);

                        valuesStack.push(node);
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported operator: " + item);
                }
            }
        }

        return valuesStack.pop();
    }

    static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value, Node<T> left) {
            this.value = value;
            this.left = left;
        }

        public T getValue() {
            return value;
        }

        public Node<T> setValue(T value) {
            this.value = value;
            return this;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> setLeft(Node<T> left) {
            this.left = left;
            return this;
        }

        public Node<T> getRight() {
            return right;
        }

        public Node<T> setRight(Node<T> right) {
            this.right = right;
            return this;
        }
    }

    public static void main(String... args) {
        Node root1 = getTree("0 1 2 + 2 + ! +");
        Node root2 = getTree("0 1 +");
        Node root3 = getTree("0");
        Node root4 = getTree(null);

        System.out.println(getHeight(root1));   //5
        System.out.println(getHeight(root2));   //2
        System.out.println(getHeight(root3));   //1
        System.out.println(getHeight(root4));   //0
    }
}
