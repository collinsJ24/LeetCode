package com.leetcode.practise.questions;

import java.util.HashMap;
import java.util.Map;

public class IsHappy {

    public boolean isHappy(int n) {
        int result =n;
        int sum = 0;
        String number = String.valueOf(n);
        Map<Integer, Integer> hmap = new HashMap<Integer,Integer>();
        if(n == 1)
            return true;
        while (n > 1){
            for(int i = 0; i < number.length(); i++) {
                int j = Character.digit(number.charAt(i), 10);
                sum += (j * j);
            }
            if(sum == 1)
                return true;
            if(hmap.containsKey(sum)){
                return false;
            }
            hmap.put(sum,1);
            number = String.valueOf(sum);
            sum = 0;
        }
        return false;
    }

    public static void main(String []args) {
        IsHappy happy = new IsHappy();
        System.out.println(happy.isHappy(19));


    }
}
