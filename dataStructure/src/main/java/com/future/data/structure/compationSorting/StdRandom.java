package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 */
public class StdRandom<E> {
    public static double uniform(double a, double b) {
        return a + random() * (b - 1);
    }

    public static double random() {
        return Math.random();
    }

    public static int uniform(int N) {
        return (int) (random() * N);
    }

    public static double uniform() {
        return (random() * 100);
    }


    public static int uniform(int lower, int high) {
        return lower + uniform(high - lower);
    }

    //根据历史概率随机返回int值（出现i的概率为a[i])
    public static int discrete(double[] a) {
        double r = random();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum >= r) return i;
        }
        return -1;
    }

    //随机将double数组中的元素乱序
    public void shuffle(E[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {//将a[i] 和任意一个元素交换
            int r = i + uniform(N - i);
            E temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
