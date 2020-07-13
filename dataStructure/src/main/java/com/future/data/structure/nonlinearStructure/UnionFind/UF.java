package com.future.data.structure.nonlinearStructure.UnionFind;

/**
 * @author: zcd
 */
public interface UF {
    boolean isConnected(int a, int b);
    int find(int a);
    int getSize();
    void unionElement(int p, int q);
}
