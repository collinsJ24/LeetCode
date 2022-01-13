package com.leetcode.practise.questions;

import java.util.*;

public class MedianTwoArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0.0;
        int [] mergedList = new int[nums1.length+nums2.length];
        int half = mergedList.length / 2;
        int middle = mergedList.length % 2;
        int nums1Index =0;
        int nums2Index = 0;
        for(int i=0; i< mergedList.length; i++){
            if(nums1Index >= nums1.length){
                mergedList[i] = nums2[nums2Index];
                nums2Index++;
                continue;
            }
            if(nums2Index >= nums2.length){
                mergedList[i] = nums1[nums1Index];
                nums1Index++;
                continue;
            }
            if(nums1[nums1Index] < nums2[nums2Index]){
                mergedList[i] = nums1[nums1Index];
                nums1Index++;
            }
            else {
                mergedList[i] = nums2[nums2Index];
                nums2Index++;
            }

        }


        if((middle % 2) != 0){
            median = (double) mergedList[half];
        }
        else{
            int result = mergedList[half] + mergedList[half-1];
            median = (double) (result / 2.0);
        }
        return median;

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(String s:strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String key=new String(temp);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String []args) {
        MedianTwoArrays ma = new MedianTwoArrays();
        int[] candidates = new int[] { 1,2};
        int[] candidates2 = new int[] {3,4};
        String[] words = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ma.groupAnagrams(words));


    }
}
