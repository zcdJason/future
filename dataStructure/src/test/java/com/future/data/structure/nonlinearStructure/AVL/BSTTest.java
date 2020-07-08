package com.future.data.structure.nonlinearStructure.AVL;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: zcd
 */
public class BSTTest {

    @Test
    public void test() {
        BST<Integer> bst = new BST<>();
        bst.add(2);
        bst.add(5);
        bst.add(1);
        System.out.println(bst);
        bst.postOrder();
//        bst.inOrder();
//        bst.preOrder();

        System.out.println(bst.maxNode());
        System.out.println(bst.minNode());
    }
}