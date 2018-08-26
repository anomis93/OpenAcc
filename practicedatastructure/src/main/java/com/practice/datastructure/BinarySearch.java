package com.practice.datastructure;

/**
 * Created by chakrabo on 8/25/2018.
 */
public class BinarySearch {
    static int [] inputArr = {4,7,2,6,1,3,8};
    public static void main(String []args) {

        Node root = new Node(inputArr[0]);

        for (int i=1; i<inputArr.length; i++) {
            insert(root, inputArr[i]);
        }
        System.out.println("Inorder Traversal : ");
        inOrderTraversal(root);
        System.out.println("\nPreorder Traversal : ");
        preOrderTraversal(root);
        System.out.println("\nPostorder Traversal : ");
        postOrderTraversal(root);
    }

    public static void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else {
            if (node.right !=null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            inOrderTraversal(node.left);
            System.out.print(node.value + ", ");
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.value + ", ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + ", ");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}
