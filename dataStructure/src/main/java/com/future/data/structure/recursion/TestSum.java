package com.future.data.structure.recursion;

public class TestSum {
    public static int sum(int[] input){
        int total = 0;
        for(int i : input){
            total += i;
        }
        return total;
    }

    public static int sum2(int[] input, int size){
        if(size == 0)
            return 0;
        else
            return input[size -1]+ sum2(input, --size);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        int size = input.length;

        System.out.println(--size);
        System.out.println(sum2(input, input.length));
    }
}
