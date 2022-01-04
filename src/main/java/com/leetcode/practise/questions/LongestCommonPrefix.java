package com.leetcode.practise.questions;

import java.util.Arrays;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        if(strs.length == 1)
            return strs[0];
        StringBuilder result = new StringBuilder();
        for(int i=0; i< strs[0].length(); i++){
            Character c = strs[0].charAt(i); // f
            for(int j=1; j< strs.length; j++){
                String strToCheck = strs[j];
                Character t = strToCheck.charAt(i);
                if(!t.equals(c)){
                    return result.toString();
                }
                else if (j == strs.length-1){
                    result.append(c);
                }
            }
        }
        return result.toString();
    }



    public static void main(String []args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] candidates = new String[] { "ab", "a"};
        System.out.println(lcp.longestCommonPrefix(candidates));


    }
}
