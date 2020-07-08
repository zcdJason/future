package com.future.data.structure.nonlinearStructure.segmentTree;

/**
 * 线段树不是一颗完全二叉树，这里把它看作为一颗满二叉树，没有的地方用空填充。
 *
 * @param <E>
 */
public class SegmentQueryTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentQueryTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length ||
                queryR < 0 || queryR > data.length) {
            throw new IllegalArgumentException("index illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //以treeIndex为根节点的left->right范围查找, 搜索范围为queryL——》queryR的值
    private E query(int treeIndex, int left, int right, int queryL, int queryR) {
        if (left == queryL && right == queryR) {
            //return treeIndex value when left and right equals queryL and queryR
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, right, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftIndex, leftIndex, mid, queryL, queryR);
        }

        E queryLeftRes = query(leftIndex, left, mid, queryL, mid);
        E queryRightRes = query(rightIndex, mid + 1, right, mid + 1, queryR);

        return merger.merge(queryLeftRes, queryRightRes);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        //int mid = (left + right)/2;//可能导致整形溢出，因此替换写法
        int mid = left + (right - left) / 2;
        buildSegmentTree(leftIndex, left, mid);
        buildSegmentTree(rightIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    public int getSize() {
        return data.length;
    }

    //update segmentTree
    public void set(int setIndex, E newV) {
        if (setIndex < 0 || setIndex > data.length) {
            throw new IllegalArgumentException("index illegal");
        }
        data[setIndex] = newV;

        set(0, 0, data.length - 1, setIndex, newV);
    }

    private void set(int treeIndex, int left, int right, int setIndex, E newV) {
        if (left == right) {
            tree[treeIndex] = newV;
            return;
        }

        int mid = left + (right - left) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if(setIndex >= mid + 1){
            set(rightIndex, mid + 1, right, setIndex, newV);
        }else{
            set(leftIndex, left, mid, setIndex, newV);
        }

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }


    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index  illegal");
        return data[index];
    }


    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
