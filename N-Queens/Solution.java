/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 * **/

class Solution {
    Set<Integer> col;
    Set<Integer> posDia;
    Set<Integer> negDia;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        col= new HashSet<>();
        posDia = new HashSet<>();
        negDia = new HashSet<>();
        result = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i =0 ; i<n ; i++){
            for(int j=0 ; j<n; j++){
                board[i][j] = '.';
            }
        }
        helper(0,n,board);
        return result;
    }

    private void helper(int row , int n , char[][] board){
        if(row ==n){
            createBoard(board);
            return;
        }

        for(int c =0 ; c<n ; c++){
            if(!col.contains(c) && !posDia.contains(row+c) && !negDia.contains(row-c)){
                col.add(c);
                posDia.add(row+c);
                negDia.add(row-c);
                board[row][c] = 'Q';

                helper(row+1, n, board);

                col.remove(c);
                posDia.remove(row+c);
                negDia.remove(row-c);
                board[row][c] = '.';

            }
        }
    }

    private void createBoard(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i =0; i<board.length ; i++){
            temp.add(new String(board[i]));
        }
        result.add(temp);
    }
}