public class Board {
    /* A class representation of a TicTacToe board.
    The board is a 9 element array. The constructor (provided)
    initializes these values to the strings "1", "2", ... "9".
    When a player makes a move on the board, that element in the
    array should be replaced by "X" or "O" respectively.
    https://en.wikipedia.org/wiki/Tic-tac-toe
    */
    public String[] board = new String[9];

    /**
    * The board is initialized to hold strings containing numbers
    * ["1" "2" "3" "4" "5" "6" "7" "8" "9"]
    */
    public Board() {
        for (int a = 0; a < 9; a++) {
            this.board[a] = String.valueOf(a + 1);
        }
    }

    /**
     * @param pos the desired position 1-9
     * @return true if an X or O has already been placed at the position,
     *         or false a number is at the position.
     */
    public boolean isEmptyPosition(int pos) {
        return!(board[pos - 1].equals("X") || board[pos - 1].equals("O"));
    }

    /**
     * Displays the current board in the console.
     */
    public void displayBoard() {
        /* An example of what an in progress game may look like:
        |---|---|---|
        | 1 | X | O |
        |-----------|
        | 4 | 5 | X |
        |-----------|
        | 7 | 8 | O |
        |---|---|---|
         */
        System.out.printf("|---|---|---| \n| %s | %s | %s |\n" +
                        "|---|---|---| \n| %s | %s | %s |\n" +
                        "|---|---|---| \n| %s | %s | %s |\n" +
                        "|---|---|---|\n",
                board[0], board[1],board[2], board[3], board[4], board[5],
                board[6], board[7], board[8]);
    }

    /**
     * @return "X" or "O" if a respective player has achieved 3 in a row,
     *         "draw" if the board is full and no player won,
     *         or null if there is no winner.
     */
    public String winner() {
        String pWon = checkDiagonal();
        if (pWon != null) {
            return pWon;
        }

        pWon = checkVertical ();
        if (pWon != null) {
            return pWon;
            }

        pWon = checkHorizontal();
        if(pWon != null) {
            return pWon;
        } else if(draw()) {
            return "draw";
        }
        return null;
        }


    public boolean draw(){
        boolean noWinner = checkDiagonal() == null && checkHorizontal() == null && checkVertical() == null;

        boolean isEveryPositionFilled = true;
            for(int i = 1; i < 10; i++){
                if(isEmptyPosition(i)){
                    isEveryPositionFilled = false;
                }
            }
        return noWinner && isEveryPositionFilled;
    }
    public String checkDiagonal(){
        if((board[0].equals("X") && board[4].equals("X") && board[8].equals("X")) ||
                (board[2].equals("X") && board[4].equals("X") && board[6].equals("X"))){
            return "X";
        } else if((board[0].equals("O") && board[4].equals("O") && board[8].equals("O")) ||
                (board[2].equals("O") && board[4].equals("O") && board[6].equals("O"))) {
            return "O";
        }
        return null;
    }


    public String checkVertical() {
        if ((board[ 0 ].equals ("X") && board[ 3 ].equals ("X") && board[ 6 ].equals ("X")) ||
                (board[ 1 ].equals ("X") && board[ 4 ].equals ("X") && board[ 7 ].equals ("X")) ||
                (board[ 2 ].equals ("X") && board[ 5 ].equals ("X") && board[ 8 ].equals ("X"))) {
            return "X";
        }

        if ((board[ 0 ].equals ("O") && board[ 3 ].equals ("O") && board[ 6 ].equals ("O")) ||
                (board[ 1 ].equals ("O") && board[ 4 ].equals ("O") && board[ 7 ].equals ("O")) ||
                (board[ 2 ].equals ("O") && board[ 5 ].equals ("O") && board[ 8 ].equals ("O"))) {
            return "O";
        }
        return null;
    }

    public String checkHorizontal() {
        if ((board[ 0 ].equals ("X") && board[ 1 ].equals ("X") && board[ 2 ].equals ("X")) ||
                (board[ 3 ].equals ("X") && board[ 4 ].equals ("X") && board[ 5 ].equals ("X")) ||
                (board[ 6 ].equals ("X") && board[ 7 ].equals ("X") && board[ 8 ].equals ("X"))) {
            return "X";
        }

        if ((board[ 0 ].equals ("O") && board[ 1 ].equals ("O") && board[ 2 ].equals ("O")) ||
                (board[ 3 ].equals ("O") && board[ 4 ].equals ("O") && board[ 5 ].equals ("O")) ||
                (board[ 6 ].equals ("O") && board[ 7 ].equals ("O") && board[ 8 ].equals ("O"))) {
            return "O";
        }
        return null;
    }
    /**
     * @param move contains the player's symbol (move.player.symbol)
     *             and the location they'd like to place it (move.pos).
     */
    public void applyMove(Move move) {
            board[move.pos - 1] = move.player.symbol;

        }

}
