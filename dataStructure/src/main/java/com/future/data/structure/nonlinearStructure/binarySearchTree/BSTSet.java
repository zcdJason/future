package com.future.data.structure.nonlinearStructure.binarySearchTree;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    BST4Overwrite<E> bst;

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size;
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
