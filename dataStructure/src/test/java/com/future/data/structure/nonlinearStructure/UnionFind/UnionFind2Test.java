package com.future.data.structure.nonlinearStructure.UnionFind;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author: zcd
 */
public class UnionFind2Test {


    public void op(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElement(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        double t = (endTime - startTime) / 10000000000.0;
        System.out.println("dis time:" + t);
    }

    @Test
    public void test() {
        int size = 100000000;
        int opM = 1000000;
//       UnionFind u1 = new UnionFind(size);
       UnionFind2 u2 = new UnionFind2(size);
       UnionFind3 u3 = new UnionFind3(size);
       UnionFindRank u4 = new UnionFindRank(size);
       UnionFindRankPathCompress u5 = new UnionFindRankPathCompress(size);
       UnionFindRankPathCompress2 u6 = new UnionFindRankPathCompress2(size);
//       op(u1, opM);
       op(u2, opM);
       op(u3, opM);
       op(u4, opM);
       op(u5, opM);
       op(u6, opM);

    }
}