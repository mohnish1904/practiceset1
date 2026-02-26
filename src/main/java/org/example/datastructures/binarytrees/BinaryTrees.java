package org.example.datastructures.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {

    Node root;

    // Add an element recursively
    /**
     * First, we have to find the place where we want to add a new node in order to keep the tree sorted.
     *
     * if the new node’s value is lower than the current node’s, we go to the left child
     * if the new node’s value is greater than the current node’s, we go to the right child
     * when the current node is null, we’ve reached a leaf node and we can insert the new node in that position
     */
    private Node addRecursively(Node current, int data){
        if (current == null)
            return new Node(data);

        if (data < current.data)
            current.leftNode = addRecursively(current.leftNode, data);
        else
            current.rightNode = addRecursively(current.rightNode, data);

        return current;
    }

    // public method to add data
    public void add(int data){
        root = addRecursively(root, data);
    }

    // Find an element
    private Boolean containsNodeRecursively(Node current, int data){
        if (null == current)
            return false;

        if (data == current.data)
            return true;

        return data < current.data ?
                containsNodeRecursively(current.leftNode, data) :
                containsNodeRecursively(current.rightNode, data);
    }

    // public method to find an element
    public Boolean find(int data){
        return containsNodeRecursively(root, data);
    }

    static int idx = -1;
    public static Node buildTree(int[] nodes){
        idx++;
        if (nodes[idx] == -1)
            return null;

        Node newNode = new Node(nodes[idx]);
        newNode.leftNode = buildTree(nodes);
        newNode.rightNode = buildTree(nodes);

        return newNode;
    }


    /**
     * Traversal Techniques
     *
     * 1. Depth first Search
     *    a. Pre-order Traversal: Visit the root node first, then visit the left subtree, followed by the right subtree.
     *    b. In-order Traversal: Visit the left node first, then visit root node, followed by right subtree
     *    c. Post-order Traversal: Visit the left node first, then right node, followed by root node
     *
     * 2. Breadth first Search
     *    a. Level-order Traversal: Visit all the nodes at the present depth level before moving on to the nodes at the next depth level.
     */

    // 1.a. Pre order traversal
    public static void preOrderTraversal(Node root){
        if (root == null)
            return;

        System.out.print(root.data + " -> ");
        preOrderTraversal(root.leftNode);
        preOrderTraversal(root.rightNode);
    }

    // 1.b. In order traversal
    public static void inorderTraversal(Node root){
        if (root == null)
            return;

        inorderTraversal(root.leftNode);
        System.out.print(root.data + " -> ");
        inorderTraversal(root.rightNode);
    }

    // 1.c. post order traversal
    public static void postOrderTraversal(Node root){
        if (null == root)
            return;

        postOrderTraversal(root.leftNode);
        postOrderTraversal(root.rightNode);
        System.out.print(root.data + " -> ");
    }

    // 2.a. Level order traversal
    public static void levelOrderTraversal(Node root){

        if (null == root)
            return;

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){

            Node currNode = nodes.remove();

            System.out.print(currNode.data + " -> ");

            if (null != currNode.leftNode)
                nodes.add(currNode.leftNode);

            if (null != currNode.rightNode)
                nodes.add(currNode.rightNode);
        }
    }


}
