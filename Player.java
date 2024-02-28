import java.util.Objects;
import java.util.Scanner;

public class Player {
    /* A class representation of a TicTacToe player.
    A player is identified by their symbol, which can be "X" or "O".
    */
    public final String symbol;
    public int points;

    public Player(String symbol) {
        if (!(symbol.equals("X") || symbol.equals("O"))) {
            throw new IllegalArgumentException("Invalid Symbol: Must be X or O");
        }
        this.symbol = symbol;
        this.points = 0;
    }

    public Move getTurn() {
        /*
        if the inputted position is not from 1-9, reject and ask again
        return a new Move with this player and the desired location.
         */
        Scanner input = new Scanner (System.in);
        while(true){
            System.out.println ("Where Do you want to place your move?");
            int val = input.nextInt();
            if(val >= 1 && val <= 9){
                return new Move(this, val);
            } else{
                System.out.println ("Invalid Input. Try again");
            }

        }
    }

    /*
    These functions allow us to compare Players to each-other
    by overriding the .equals() and .hashCode() methods.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return this.symbol.equals(player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
