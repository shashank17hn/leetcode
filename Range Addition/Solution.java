/**
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 *
 * You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 *
 * Return arr after applying all the updates.
 *
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 * Example 2:
 *
 * Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
 * Output: [0,-4,2,2,2,4,4,-4,-4,-4]
 * */

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {

        int[] result = new int[length];

        for(int i =0 ; i< updates.length ; i++){

            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];

            for(int j =start; j<= end ; j++){
                result[j] += value;
            }

        }
        return result;

    }
}