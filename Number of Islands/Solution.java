/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * */

class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        for(int row =0 ; row < grid.length ; row++){
            for(int col =0 ; col < grid[row].length; col++){
                if(grid[row][col]== '1'){
                    count++;
                    numIslands(grid, row, col);
                }
            }
        }

        return count;
    }

    private void numIslands(char[][] grid , int row , int col){
        if(row<0 || col<0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0'){
            return ;
        }
        grid[row][col] = '0';
        //up
        numIslands(grid, row-1, col);
        //down
        numIslands(grid, row+1, col);
        //left
        numIslands(grid, row, col-1);
        //right
        numIslands(grid, row , col+1);
    }

}