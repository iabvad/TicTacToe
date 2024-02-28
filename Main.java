import java.util.Scanner;

public class Main {

    static GameState game = new GameState();


    public static void main(String[] args) {
        // Each iteration of this loop represents one game of TicTacToe
        while (true) {

            Scanner input = new Scanner (System.in);
            game.newGame();

            // Each iteration of this while loop represents one turn of TicTacToe.
            game.currentPlayer = game.randomPlayer();
            while (!game.isOver()) {

                /* Each iteration of this while loop represents one turn of TicTacToe.
                 *
                 * Every turn, the game should display the current board to the user,
                 * announce which player's turn it is,
                 * and prompt that user to take a turn.
                 *
                 * If the user asks for an invalid position
                 * (not 1-9 or the position is already filled)
                 * ask the user to try again.
                 *
                 * Once the player inputs a valid move,
                 * apply the move to the board,
                 * and cycle the game to the next player (with game.nextPlayer()).
                 *
                 * If a move wins the game, it will terminate this loop.
                 */

                   System.out.println("It is " + game.currentPlayer.symbol + "'s turn");
                   game.board.displayBoard();

                    Move turn = game.currentPlayer.getTurn();
                    int position = turn.pos;

                while(true) {
                    if (game.board.isEmptyPosition(position)) {
                       game.board.applyMove(turn);
                       game.nextPlayer();
                       break;
                    }
                    System.out.println ("Current spot is filled. Enter another");
                    turn = game.currentPlayer.getTurn ();
                    position = turn.pos;
                }
            }
             // Display end game information and update scores

            game.board.displayBoard();
            if(game.board.winner().equals("draw")){
                System.out.println("The game has ended in a draw");
            } else{
                System.out.printf("%S has won the game \n", game.board.winner());
                game.addPointToWinningPlayer();
                System.out.println("The score is " + game.players[0].points + " : " + game.players[1].points);
            }

            /*
             * If the user says "Y", the game restarts.
             * If the user says "N", the game ends.
             */
            System.out.println("Would you like to play again?");
            if(!input.next().equalsIgnoreCase("Y")){
                break;
            }
        }
    }
}
