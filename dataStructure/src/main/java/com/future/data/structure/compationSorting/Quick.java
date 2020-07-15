package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 */
public class Quick extends Example {

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
//        if(lo >= hi) return;
        int M = 15;//如果待排序的数组在(5~15之间)任意值，使用插入排序效果更好
        if (hi <= lo + M) {
            new Insertion().sort(a);
            return;
        }
        int j = partition2(a, lo, hi);
        sort(a, lo, j);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为 a[low, i -1 ] a[i]   a[i+1, hi]
        int i = lo, j = hi + 1;  //左右扫描指针
        Comparable v = a[lo]; //切分的元素
        for (; ; ) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j); //将v=a[j]放入正确位置
        return j;
    }


    private int partition2(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;  //定义左右扫描索引
        Comparable v = a[lo];
        for (; ; ) {
            while (less(a[++i], v)) if (i == hi) break; //i 元素比 v要小移动左指针
            while (less(v, a[--j])) if (j == lo) break;//j 元素比v要大移动右指针
            if (i >= j) break; //i和j相遇的适合退出
            swap(a, i, j); // i元素比v大，j元素比v小，则交换元素
        }
        swap(a, lo, j);//最后将low对于的base基准数据放入正确的位置j
        return j;//返回j位置的切分点，这样左边的比j小，右边的比j大
    }


    public static void main(String[] args) {
        Double[] a = {3.0, 8.0, 8.0, 11.0, 18.0, 9.0};
        int i = 0;
        System.out.println(a[i++]);
        Quick q = new Quick();
        q.sort(a);
        Shell.show(a);
    }
}
