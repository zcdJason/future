package com.future.data.structure.compationSorting;


import org.springframework.expression.spel.ast.Selection;

/**
 * @author: Cock a doodle doo
 */
public class SortCompare {

    public static double time(String alg, Double[] a) {
//        for(int i = 0 ; i< a.length ; i++)
//            StdOut.println(a[i]);
        StopWatch timer = new StopWatch();
        if (alg.equals("Insertion")) {
            new Insertion().sort(a);
        }
        if (alg.equals("Shell")) {
            new Shell().sort(a);
        }
        if (alg.equals("Merge")) {
           new MergeSort().sort(a);
        }
        if (alg.equals("Quick")) {
            new Quick().sort(a);
        }
        if (alg.equals("Quick3")) {
            new Quick3().sort(a);
        }
        if (alg.equals("Ex22")) {
            Ex22.sort(a);
        }
//        if (alg.equals("Heap")) {
//            Heap.sort(a);
//        }
        // Exercise 2.1.24
//        if (alg.equals("Ex24")) {
//            Ex24.sort(a);
//        }
        // Exercise 2.1.25
//        if (alg.equals("Ex25")) {
//            Ex25.sort(a);
//        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
//        String alg1 = args[0];
//        String alg2 = "Merge";
//        String alg2 = "Quick";
//        String alg2 = "Quick3";
        String alg1 = "Ex22";
        String alg2 = "Shell";

//        String.intern();

//        int N = Integer.parseInt(args[2]);
//        int T = Integer.parseInt(args[3]);
        int N = 1000; //排序数组规模
        int T = N;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
