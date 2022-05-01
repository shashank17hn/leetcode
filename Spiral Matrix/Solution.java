/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * **/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int up =0;
        int left =0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;

        List<Integer> result = new ArrayList<>();

        while(result.size() < rowLength *colLength){

            // traverse left to right
            for(int i =left ; i<=right ; i++){
                result.add(matrix[up][i]);
            }
            // traverse up to down
            for(int i =up+1 ; i<= down ; i++){
                result.add(matrix[i][right]);
            }

            if(up!= down)
                // right to left
                for(int i =right-1 ; i>=left ; i--){
                    result.add(matrix[down][i]);
                }
            if(left!= right)
                // down to up
                for(int i =down-1 ; i> up ; i--){
                    result.add(matrix[i][left]);
                }

            up++;
            down--;
            left++;
            right--;

        }
        return result;
    }
}