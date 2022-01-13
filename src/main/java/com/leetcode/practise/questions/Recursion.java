package com.leetcode.practise.questions;

public class Recursion {

    public int fibonacci(int n) {
        if(n <= 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public int sumDigits(int n) {
        if(n == 0)
            return 0;
        else return n % 10 + sumDigits(n / 10);

    }

    public int countHi(String str) {
        if(str.length() <= 1)
            return 0;
        else if(str.substring(0,2).equals("hi"))
                return 1 + countHi(str.substring(2));
        else
            return countHi(str.substring(1));

    }

    public int countPairs(String str) {
        if(str.length() <= 2)
            return 0;
        if(str.substring(0,1).equals(str.substring(2,3)))
            return 1 + countPairs(str.substring(1));
        else
            return countPairs(str.substring(1));
    }

    public String stringClean(String str) {
        if(str.length() < 2)
            return str;
        if(str.charAt(0) == str.charAt(1))
            return stringClean(str.substring(1));
        else
            return str.charAt(0) + stringClean(str.substring(1));
    }

    public boolean groupSum(int start, int[] nums, int target) {
        if(start >= nums.length)
            return target == 0;

        if(groupSum(start+1, nums, target - nums[start]))
            return true;

        if(groupSum(start+1, nums, target))
            return true;

        return false;

    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length)
            return target == 0;

        int i=start;
        int sum = 0;
        while (i <nums.length && nums[start] == nums[i]){
            sum += nums[i];
            i++;
        }

        if(groupSumClump(i, nums, target - sum))
            return true;

        if(groupSumClump(i, nums, target))
            return true;

        return false;

    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length)
            return target == 0;

        if(groupNoAdj(start+2, nums, target - nums[start]))
            return true;

        if(groupNoAdj(start+1, nums, target))
            return true;

        return false;
    }

    public boolean splitArray(int[] nums) {
        return splitArrayHelper(0, nums, 0, 0);
    }

    public boolean splitArrayHelper(int start, int[] nums, int group1, int group2) {
        if(start >= nums.length)
            return group1 == group2;

        if(splitArrayHelper(start+1, nums, group1 +nums[start], group2))
            return true;

        if(splitArrayHelper(start+1, nums,group1, group2 + nums[start]))
            return true;

        return false;
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if(start >= nums.length)
            return target == 0;

        if(nums[start] == 6)
            target -= nums[start];

        if(groupSum6(start+1,nums, target-nums[start]))
            return true;

        if (groupSum6(start+1,nums, target))
            return true;

        return false;

    }

    public String revString(String str){
        if(str.length() < 2)
            return str;
        return(str.substring(str.length()-1) + revString(str.substring(0, str.length()-1)));
    }

    public void reverseString(char[] s) {
        reverseStringHelper(s, 0);
        System.out.print(s.toString());
    }

    private void reverseStringHelper(char[] s, int index) {
        if(index > (s.length-1)/2)
            return;

        char temp = s[index];
        s[index] = s[s.length-index-1];
        s[s.length-index-1] = temp;
        reverseStringHelper(s,index+1);

    }


    public static void main(String []args) {
       Recursion r = new Recursion();
        int[] candidates = new int[] { 5,6,2};
        char[] chars = new char[] {'h', 'e', 'l', 'l'};
        r.reverseString(chars);
        //System.out.println(r.revString("hell"));


    }
}
