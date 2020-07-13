package com.future.data.structure.nonlinearStructure.UnionFind;

/**
 * @author: zcd
 */
public class UnionFind2  implements UF{
    //在第一版本中我们使用了一个数组来存储集合元素索引；那么在一般的并查集中我们使用的是一个特殊的树结构
    //该结构的孩子指向父节点,逻辑树是一颗这样的树，但是时间存储仍然可以用数组来存。
    int[] parents;
    public UnionFind2(int size){
        parents = new int[size];
        for(int i = 0 ; i< size; i++){
            parents[i] = i;
        }
    }

    //查找元素编号p对应的集合编号
    public int find(int p){
        if(p < 0 || p > parents.length){
            throw new IllegalArgumentException("index outbound");
        }
        //循环的终止的条件是什么？ p = parents[p] 为根节点
        while(p != parents[p])
            p = parents[p];
        return p;
    }

    @Override
    public int getSize() {
        return parents.length;
    }

    public boolean isConnected(int p , int q){
        return  find(p) == find(q);
    }

    public void unionElement(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ)
            return;
        parents[rootP] = rootQ;
    }
}
