/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * */
class Solution {
    int area =0;
    int count =0;
    public int maxAreaOfIsland(int[][] grid) {

        for(int i=0 ; i< grid.length ; i++){
            for(int j=0 ; j<grid[i].length ; j++){
                if(grid[i][j] == 1){
                    count =0;
                    helper(grid, i, j);
                }
            }
        }

        return area;
    }

    private void helper(int[][] grid , int i , int j){
        if(i<0 ||j<0 || i>=grid.length || j>=grid[i].length ||grid[i][j] == 0){
            System.out.println(count);
            area = Math.max(count, area);
            return;
        }
        count++;
        grid[i][j] = 0;
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j+1);
        helper(grid, i, j-1);
    }
}