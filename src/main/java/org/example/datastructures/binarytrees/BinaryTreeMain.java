package org.example.datastructures.binarytrees;

import java.util.stream.IntStream;

public class BinaryTreeMain {

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTrees bt = createBinaryTree();
        System.out.println(" pre order ");
        BinaryTrees.preOrderTraversal(bt.root);
        System.out.println();
        System.out.println(" in order ");
        BinaryTrees.inorderTraversal(bt.root);
        System.out.println();
        System.out.println(" post order ");
        BinaryTrees.postOrderTraversal(bt.root);
        System.out.println();
        System.out.println(" level order ");
        BinaryTrees.levelOrderTraversal(bt.root);

    }

    private static BinaryTrees createBinaryTree(){
        BinaryTrees bt = new BinaryTrees();
        IntStream.rangeClosed(1, 10).forEach(bt::add);
        return bt;
    }
}
