package com.future.data.structure.nonlinearStructure.segmentTree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {

    @Test
    public void getSize() {
        Integer[] input = {1,2,3,4,8,9};
        SegmentQueryTree s = new SegmentQueryTree<>(input, (a, b) -> a+ b);
        System.out.println(s);

        System.out.println(s.query(0,3));
    }
}