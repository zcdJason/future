package com.future.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Jama.Matrix;

public class TestMatrix {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add("3");

        List<String> l2 = new ArrayList<>();
        l2.add("add");
        l2.add("delete");
        l2.add("modify");

        List<String> l3 = new ArrayList<>();
        l3.add("/add");
        l3.add("/delete");
        l3.add("/modify");

        List<String> l4 = new ArrayList<>();
        l4.add("id");
        l4.add("name");
        l4.add("url");

        l1.addAll(l2);
        l1.addAll(l3);

        for(String a: l1)
        {
            System.out.println(a);
        }

        List<Integer> tL = new ArrayList<>();
        tL.add(3);
        tL.add(3);
        tL.add(3);
        List<Map<String, Object>> resN = new ArrayList<>();
        // 取最长的
        for(int i = 0 ; i< l2.size(); i++)
        {
            Map<String, Object> res = new HashMap<>();
            // | 1,2,3,4 "add","delete", "modify", "/add", "/delete", "/modify"|
            List<String> temp  = new ArrayList<>();
            int tt = i;
            for(int j = 0 ; j < l4.size() ; j++)
            {
                if(!temp.contains(l4.get(j)))
                {
                    temp.add(l4.get(j));
                    res.put(l4.get(j), l1.get(tt));
                }
                tt += tL.get(j);
            }
            resN.add(res);
        }

        for(Map<String, Object> tt: resN)
        {
            System.out.println(tt);
        }

//        double[] x = {1.0, 2.0, 3.0,4.0};
//        Matrix m = new Matrix(TwoArry(x));
//
//        m.print(1,0);
    }

    //一维数组转化为二维数组
    public static double[][] TwoArry(double[] onedouble){
        double[][] arr=new double[1][onedouble.length];
        for (int i = 0; i < onedouble.length; i++) {
            arr[0][i]=onedouble[i];
        }
        return arr;
    }

//    //一维数组转化为二维数组
//    public static String[][] TwoArry(int rowN, List<String> list){
//        String[][] arr=new String[rowN][list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[0][i]=list.get(i);
//        }
//        return arr;
//    }

    //List2 array
    public static double[] list2Array(List<String> list)
    {
        double[] res = new double[list.size()];
        return null;
    }
}
