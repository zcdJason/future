package com.future.data.structure.linearStructure.stack.leetcode;

import java.util.Stack;

public class Solution {
    //number20 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i= 0; i< s.length(); i ++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                //input empty string
                if(stack.isEmpty())
                    return false;
                char topC = stack.pop();
                if(c == ')' && topC != '(')
                    return false;
                if(c == ']'&& topC != '[')
                    return false;
                if(c == '}'&& topC != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{{{{))))";
        String s1 = "({[]})";
        Solution t = new Solution();
        System.out.println(t.isValid(s1));
    }
}
