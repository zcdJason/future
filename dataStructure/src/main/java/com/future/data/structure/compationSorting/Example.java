package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 */
public abstract class Example {
    public abstract void sort(Comparable[] a);
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    public static boolean more(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    public static void swap(Comparable[] a , int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        int len = a.length;
        for(int i = 0; i< len; i++)
            System.out.println("a[" + i + "]=" +a[i]);
        System.out.println();
    }

    public static  boolean isSorted(Comparable[] a){
        int len = a.length;
        for (int i = 1; i< len; i++){
            if(less(a[i], a[i-1]))
                return false;
        }
        return true;
    }
}
