/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 * */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row =0 ; row< matrix.length ; row++){
            if(target== matrix[row][ matrix[row].length-1] || target==matrix[row][0]){
                return true;
            }
            if(target< matrix[row][ matrix[row].length-1] && target> matrix[row][0] ){
                boolean status =  binarySearch(matrix ,row , target);
                if(status){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] arr, int row, int target){

        int left = 0;
        int right = arr[row].length-1;

        while(right>=left){
            int mid = left + (right-left)/2;
            if(arr[row][mid] == target){
                return true;
            }else if(target < arr[row][mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}