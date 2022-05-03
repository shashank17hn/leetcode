/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 * */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(cache, matrix, m, n, i, j, null));
            }
        }
        return max;
    }

    private int dfs(int[][] cache, int[][] matrix, int m, int n, int i, int j , Integer prev) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if(prev != null && prev >= matrix[i][j]) {
            return 0;
        }
        if(cache[i][j] != 0) {
            return cache[i][j];
        }

        int a = dfs(cache, matrix, m, n, i+1, j, matrix[i][j]);
        int b = dfs(cache, matrix, m, n, i-1, j, matrix[i][j]);
        int c = dfs(cache, matrix, m, n, i, j-1, matrix[i][j]);
        int d = dfs(cache, matrix, m, n, i, j+1, matrix[i][j]);
        cache[i][j] =  Math.max(Math.max(a,b),Math.max(c,d)) + 1;
        return cache[i][j];
    }
}