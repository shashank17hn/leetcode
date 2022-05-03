/**
 * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves are allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Implement the TicTacToe class:
 *
 * TicTacToe(int n) Initializes the object the size of the board n.
 * int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
 *
 *
 * Example 1:
 *
 * Input
 * ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
 * [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
 * Output
 * [null, 0, 0, 0, 0, 0, 0, 1]
 *
 * Explanation
 * TicTacToe ticTacToe = new TicTacToe(3);
 * Assume that player 1 is "X" and player 2 is "O" in the board.
 * ticTacToe.move(0, 0, 1); // return 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 *
 * ticTacToe.move(0, 2, 2); // return 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 *
 * ticTacToe.move(2, 2, 1); // return 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 *
 * ticTacToe.move(1, 1, 2); // return 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 *
 * ticTacToe.move(2, 0, 1); // return 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 *
 * ticTacToe.move(1, 0, 2); // return 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 *
 * ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * */

class TicTacToe {

    int[][] matrix;
    int colData[];
    int rowData[];
    int posDia;
    int ndegDia;
    int size;




    public TicTacToe(int n) {

        matrix = new int[n][n];
        colData = new int[n];
        rowData = new int[n];
        posDia=0;
        ndegDia =0;
        size =n;

    }

    public int move(int row, int col, int player) {
        int play = player == 2 ? -1 : 1;
        matrix[row][col] = play;
        colData[col] += play;
        rowData[row] += play;
        if(col==row){
            posDia +=play;
        }
        if(size-1-row == col){
            ndegDia += play;
        }

        if(Math.abs(posDia)==size || Math.abs(colData[col])==size || Math.abs(ndegDia) ==size ||Math.abs(rowData[row]) ==size){
            return play==-1?2:1;
        }
        return 0;
    }



}

// basic idea
//     public TicTacToe(int n) {

//         matrix = new int[n][n];
//         size =n;

//     }

//     public int move(int row, int col, int player) {
//         int play = player == 2 ? -1 : 1;
//         matrix[row][col] = play;
//         int rowCount =0;
//         int colCount =0;
//         int digonal =0;
//         int digonalRev =0;
//         for(int i =0 ; i<size ; i++){
//            rowCount += matrix[row][i];
//            colCount += matrix[i][col];
//            digonal  += matrix[i][i];
//            digonalRev += matrix[size-1-i][i];
//         }

//         if(Math.abs(rowCount)==size || Math.abs(colCount)==size || Math.abs(digonal) ==size ||Math.abs(digonalRev) ==size){
//             return play==-1?2:1;
//         }
//         return 0;
//     }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */