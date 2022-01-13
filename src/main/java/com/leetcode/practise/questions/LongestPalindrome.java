package com.leetcode.practise.questions;

public class LongestPalindrome {


    /*public String longestPalindrome(String s) {
        String result = "";
        int maxString = 0;
        if(s.length() < 2)
            return s;
        if(s.length() ==2){
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.substring(0,1);
        }
        for(int i=0; i< s.length(); i++){
            int end = i+2;
            for(int j = end; j< s.length()+1; j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > maxString) {
                    maxString = temp.length();
                    result = temp;
                }

            }
        }
        if(result.isEmpty())
            return s.substring(0,1);
        return result;
    }

    public boolean isPalindrome(String s){
        int mid = s.length()/2;
        int end = s.length()-1;
        for(int i=0; i< mid;i++){
            if(!(s.charAt(i) == s.charAt(end)))
                return false;
            else
                end--;
        }
        return true;
    }*/

    private String maxString = "";
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i=0; i<length; i++) {
            // find longest odd palindrome
            findPalindrome(chars, length, i, 0);
            // find longest even palindrome
            findPalindrome(chars, length, i, 1);
        }
        return maxString;
    }

    private void findPalindrome(char[] chars, int length, int i, int shift) {
        int left = i;
        int right= i+shift;
        while (left >= 0 && right < length && chars[left] == chars[right]){
            left--; right++;
        }
        if ((right-left-1) > maxLength) {
            maxLength = right-left-1;
            maxString = new String(chars, left+1, maxLength);
        }
    }

    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();

        System.out.println(lp.longestPalindrome("babaaaaa"));
    }
}
