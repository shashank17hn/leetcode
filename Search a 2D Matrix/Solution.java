/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
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
                }else {
                    return false;
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
