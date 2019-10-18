package com.challenge.medium;

//https://www.hackerrank.com/challenges/is-binary-search-tree
public class CheckBinaryTree {

    public static boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }



        return false;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
