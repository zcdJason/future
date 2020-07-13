package com.future.data.structure.nonlinearStructure.UnionFind;

/**
 * @author: zcd
 * 定义一个并查集,并查集中我们使用是存储数据编号的形式。
 * 例如有10个不同的对象，我们对它进行编号0-9，刚刚开始的时候每个对象他们是互相独立的，属于自己单独的集合
 * union操作就是让他们属于一个集合，find操作就是找出他们的集合根编号
 */
public class UnionFind implements  UF{
    //底层本质是一个数组；使用数组来模拟
    int[] ids;

    public UnionFind(int size) {
        ids = new int[size];
        //初始化的时候让每个元素属于不同的集合
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    public int getSize() {
        return ids.length;
    }

    //找出元素p对应的编号；p的值应该在数组索引范围内
    public int find(int p) {
        if (p < 0 || p > ids.length) {
            throw new IllegalArgumentException("index outbound");
        }
        return ids[p];
    }

    //两个元素是否联通，查看两个元素是否属于同一个集合
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并
    public void unionElement(int p, int q) {
        //如果本身属于一个集合，那么就退出
        int iP = find(p);
        int iQ = find(q);

        if (iP == iQ)
            return;

        //O(n) 的复杂度
        for (int i = 0; i < ids.length; i++) {
            if(ids[i] == iP)
                ids[i] = iQ;
        }
    }
}
