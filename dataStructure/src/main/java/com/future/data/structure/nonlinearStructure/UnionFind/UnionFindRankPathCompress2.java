package com.future.data.structure.nonlinearStructure.UnionFind;

/**
 * @author: zcd
 */
public class UnionFindRankPathCompress2 implements UF {
    //在第一版本中我们使用了一个数组来存储集合元素索引；那么在一般的并查集中我们使用的是一个特殊的树结构
    //该结构的孩子指向父节点
    int[] parents;
    int[] rank; //基于rank的优化，rank数组存放的是树的高度，原则树树的高度低的指向高度高的

    public UnionFindRankPathCompress2(int size) {
        parents = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    //查找元素编号p对应的集合编号
    public int find(int p) {
        if (p < 0 || p >= parents.length) {
            throw new IllegalArgumentException("index outbound");
        }
        //循环的终止的条件是什么？ p = parents[p] 为根节点
        if(p != parents[p]){
            parents[p] = find(parents[p]);//路径压缩2
        }
        return parents[p];
    }

    @Override
    public int getSize() {
        return parents.length;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElement(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        if (rank[rootP] < rank[rootQ]) {
            parents[rootP] = rootQ;
        } else if(rank[rootP] > rank[rootQ]) {
            parents[rootQ] = rootP;
        }else{
            parents[rootQ] = rootP;
            //由于两颗子🌲的高度相同，因此合并后的高度需要维护
            rank[rootP] += 1;
        }
    }
}
