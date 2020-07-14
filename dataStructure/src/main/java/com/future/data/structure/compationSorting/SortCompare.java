package com.future.data.structure.compationSorting;

import org.springframework.util.StopWatch;

/**
 * @author: Cock a doodle doo
 */
public class SortCompare {

    public static double time(String alg, Double[] a){
        StopWatch timer = new StopWatch();
        if(alg.endsWith("Insertion")) (new InsertionSort<Double>()).sort(a, new ComparableMy<Double>() {
            @Override
            public boolean compare(Double a, Double b) {
                return a > b;
            }
        });
        return timer.getLastTaskTimeMillis();
    }

    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; t++)
        {
            for (int i = 0; i< N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "";
        String alg2 = "";
        int N = 0;
        int T = 0;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.println("random numbers:" + N);
        System.out.println("random alg2/alg1:" + t2/t1);
    }
}
