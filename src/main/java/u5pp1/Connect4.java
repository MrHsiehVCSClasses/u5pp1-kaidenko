package u5pp1;

public class Connect4 {

    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static final int RED = 1;
    public static final int BLACK = -1;
    public static final int EMPTY = 0;


   public static boolean isFull(int[][] board){

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                if (board[row][col] == 0){
                    return false;
                }
            }
        }
        return true;
   }


   public static boolean isBoardValid(int[][] board){

        for (int row = board.length - 1; row > 0; row--){
            for (int col = 0; col < board[row].length; col++){
                if ((board[row][col] == 0) && (board[row - 1][col] != 0)){
                    return false;
                }
            }
        }
        return true;
   }


   public static int getWinner(int[][] board){

    int score = 0;
    int both = 0;

    //check horizontal
    for (int row = 0; row < board.length; row++){
        for (int col = 0; col < board[row].length-3; col++){
            int check = 0;
            for (int h = 0; h < 4; h++){
                if (board[row][col+h] == RED){
                    check++;
                    if (check == 4){
                        return RED_WIN;
                    }
                }
                else if (board[row][col+h] == BLACK){
                    check++;
                    if (check == 4){
                        return BLACK_WIN;
                    }
                }
            }
        }
    }

    //check vertical
    for (int row = 0; row < board.length-3; row++){
        for (int col = 0; col < board[row].length; col++){
            int check = 0;
            for (int h = 0; h < 4; h++){
                if (board[row+h][col] == RED){
                    check++;
                    if (check == 4){
                        return RED_WIN;
                    }
                }
                else if (board[row+h][col] == BLACK){
                    check++;
                    if (check == 4){
                        return BLACK_WIN;
                    }
                }
            }
         }
    }

    //check diagonal right down 
    for (int row = 0; row < board.length-3; row++){
        for (int col = 0; col < board[row].length-4; col++){
            int check = 0;
            for (int h = 0; h < 4; h++){
                if (board[row+h][col-h] == RED){
                    check++;
                    if (check == 4){
                        return RED_WIN;
                    }
                }
                else if (board[row+h][col-h] == BLACK){
                    check++;
                    if (check == 4){
                        return BLACK_WIN;
                    }
                }
            }
         }
    }

    //check diagonal left down
    for (int row = board.length; row < 3; row--){
        for (int col = board[row].length; col < 4; col--){
            int check = 0;
            for (int h = 0; h < 4; h++){
                if (board[row-h][col-h] == RED){
                    check++;
                    if (check == 4){
                        return RED_WIN;
                    }
                }
                else if (board[row-h][col-h] == BLACK){
                    check++;
                    if (check == 4){
                        return BLACK_WIN;
                    }
                }
            }
         }
    }

    // check both winner

    // if (both == 2){
    //     return BOTH_WIN;
    // }
    // else if (both == 1){
    //     return score;
    // }
    // else {
    //     return NO_WINNER;
    // }
   
    return NO_WINNER;
    }
}