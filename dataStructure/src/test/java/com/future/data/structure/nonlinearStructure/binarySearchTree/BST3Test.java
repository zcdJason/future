package com.future.data.structure.nonlinearStructure.binarySearchTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BST3Test {

    @Test
    public void size() {
        System.out.println(1%2);
        double s = (float)1/2;
        System.out.println(s);
        int[]  input = {1,3,5,8,10};
        int[] nums = {5, 3, 6, 8, 4, 2};
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        BST4Overwrite bst3 = new BST4Overwrite();
//        BST3 bst3 = new BST3();
        for(int i: nums){
            bst3.add(i);
        }
//        bst3.preOrder();
//        bst3.inOrder();
//        bst3.postOrder();

//        System.out.println(bst3.minNode());
//        System.out.println(bst3.maxNode());
//        System.out.println(bst3.remove(6));

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
    }
}