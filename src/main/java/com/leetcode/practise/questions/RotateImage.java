package com.leetcode.practise.questions;

import java.util.Arrays;

public class RotateImage {


    public boolean findRotation(int[][] mat, int[][] target) {
        int rotations = 0;
        while(rotations < 4) {
            for (int i = 0; i < mat.length; i++) {
                if (!Arrays.equals(mat[i], target[i])) {
                        rotate(mat);
                        rotations+=1;
                        break;
                }
                else if(i == mat.length-1)
                    return true;
            }
        }
        return false;

    }

    public void rotate(int[][] matrix) {
        int spacesToMove = matrix.length - 1; //2
        int len = matrix.length;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0; i< len; i++){
            for(int j=0; j< len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][spacesToMove-j];
                matrix[i][spacesToMove-j] = temp;
            }
        }
    }

    public static void main(String[] args){
        RotateImage rI = new RotateImage();
        int[][] matrix = new int[][] {{0,0,0},{0,0,1},{0,0,1}};
        int[][] matrix2 = new int[][] {{0,0,0},{0,0,1},{0,0,1}};
        rI.findRotation(matrix, matrix2);
    }
}
