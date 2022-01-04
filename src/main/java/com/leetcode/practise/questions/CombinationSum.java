package com.leetcode.practise.questions;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSumUtil(candidates,0,target,res,temp);

        // Converting Hashset to List
        return new ArrayList<>(res);
    }


    public void combinationSumUtil(int[] candidates, int sum, int target, Set<List<Integer>> res, List<Integer> temp){
        if(sum > target){
            return;
        }else if(sum == target){
			/* Creating a copy and sorting so that the original temp array is not altered.
			Sorting is done to remove duplicates.
			Ex: To make [2,3] and [3,2] same
			*/
            ArrayList<Integer> temp2= new ArrayList(temp);
            Collections.sort(temp2);
            res.add(temp2);
        }else{
            for(int i=0;i<candidates.length;i++){
                sum += candidates[i];
                // Since array is sorted, there is no point in checking further if sum > target.
                if(sum > target)
                    return;
                temp.add(candidates[i]);
                combinationSumUtil(candidates,sum,target,res,temp);
                int removed = temp.remove(temp.size()-1);
                sum -= removed;
            }
        }
    }

    public static void main(String []args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[] { 2,3,6,7};
        System.out.println(cs.combinationSum(candidates, 7));


    }
}
