package com.leetcode.practise.questions;

public class InsertToArray {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int middle = (end + start) / 2;
            if(nums[middle] == target)
                return middle;
            else if(target < nums[middle])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return start;
    }

    public static void main(String[] args){
        InsertToArray ist = new InsertToArray();
        int[] candidates = new int[] { 1,3,5,6};
        System.out.println(ist.searchInsert(candidates, 4));
    }
}
