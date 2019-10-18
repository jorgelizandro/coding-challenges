package com.challenge.easy;

//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
public class LowestCommonAncestor {
    public static Node lca(Node root, int v1, int v2) {
        boolean rootIsCommonAncestor = isAncestor(root, v1) && isAncestor(root, v2);

        if (rootIsCommonAncestor) {
            boolean leftIsCommonAncestor = isAncestor(root.left, v1) && isAncestor(root.left, v2);
            boolean rightIsCommonAncestor = isAncestor(root.right, v1) && isAncestor(root.right, v2);

            if (leftIsCommonAncestor) {
                return lca(root.left, v1, v2);
            }

            if (rightIsCommonAncestor) {
                return lca(root.right, v1, v2);
            }

            return root;
        }

        return null;
    }

    private static boolean isAncestor(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        boolean leftResult = isAncestor(node.left, value);
        boolean rightResult = isAncestor(node.right, value);

        return leftResult || rightResult;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
