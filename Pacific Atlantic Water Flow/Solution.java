/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 * */
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic =new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();

        //col
        for(int i =0 ; i< heights[0].length ; i++){
            dfs(heights, 0, i, pacific , heights[0][i]);
            dfs(heights, heights.length-1, i, atlantic ,heights[ heights.length-1][i]);
        }

        //rows
        for(int i =0 ; i< heights.length ; i++){
            dfs(heights, i, 0, pacific,heights[i][0]);
            dfs(heights, i, heights[0].length-1, atlantic,heights[i][heights[0].length-1]);

        }

        for(int i=0; i< heights.length ; i++){
            for(int j=0 ; j< heights[0].length ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited , int prev){
        if(i>=heights.length || i< 0 || j>=heights[0].length || j<0|| visited[i][j] || heights[i][j]<prev){
            return;
        }
        //System.out.println("test "+ i + " "+ j);
        visited[i][j] = true;
        dfs(heights, i-1, j, visited, heights[i][j]);
        dfs(heights, i+1, j, visited, heights[i][j]);
        dfs(heights, i, j-1, visited, heights[i][j]);
        dfs(heights, i, j+1, visited, heights[i][j]);
    }
}