package org.example.datastructures.binarytrees;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreesTest {


    @Test
    public void testBtFind(){
        BinaryTrees bt = createBinaryTree();
        assertTrue(bt.find(8));
        assertFalse(bt.find(30));
    }


    BinaryTrees createBinaryTree(){
        BinaryTrees bt = new BinaryTrees();
        IntStream.rangeClosed(1, 10).forEach(bt::add);
        return bt;
    }
}