package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 */
public class Insertion extends Example {

    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        for(int i=1; i< len; i++){
            for(int j = i; j > 0 && less(a[j], a[j -1]); j--)
                swap(a, j, j-1);
        }
    }
}
