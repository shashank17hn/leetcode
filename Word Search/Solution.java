/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * **/

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i =0 ; i<board.length; i++){
            for(int j=0 ; j<board[0].length ;j++){
                boolean flag = helper(i,j,board,word, 0);
                if(flag) return true;
            }
        }
        return false;
    }

    private boolean helper(int i , int j , char[][] board , String word, int index){
        if(i >= board.length || j>=board[0].length || i<0 || j<0 || board[i][j] == '#' || index>=word.length() || board[i][j] != word.charAt(index)){
            return false;
        }


        if(index==word.length()-1 && board[i][j] == word.charAt(index)){
            return true;
        }

        char temp = board[i][j] ;
        board[i][j] = '#';
        boolean result = helper(i+1,j,board,word,index+1) || helper(i,j-1,board,word,index+1) || helper(i-1,j,board,word,index+1) || helper(i,j+1,board,word,index+1);
        board[i][j] = temp;
        return result;

    }


}