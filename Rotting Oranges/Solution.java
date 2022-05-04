/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 * */
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh =0;
        int time =0;
        Queue<int[]> rotten = new LinkedList<>();

        for(int i=0 ; i<grid.length ; i++){
            for(int j =0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int cord[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!rotten.isEmpty() && fresh>0){
            int level = rotten.size();
            for(int i=0 ; i<level ; i++){
                int[] index = rotten.poll();
                for(int j=0 ; j<cord.length; j++){
                    int row = index[0] + cord[j][0];
                    int col = index[1] + cord[j][1];
                    if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col] != 1) continue;
                    if(grid[row][col] == 1){
                        rotten.add(new int[]{row,col});
                        grid[row][col] =2;
                        fresh--;
                    }

                }

            }
            time++;

        }
        if(fresh ==0) return time;
        return -1;

    }
}