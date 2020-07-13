package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 */
public interface ComparableMy<E extends Comparable<E>> {
    boolean compare(E a, E b);
}
