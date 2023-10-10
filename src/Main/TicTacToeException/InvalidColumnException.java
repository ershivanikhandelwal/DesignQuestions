package Main.TicTacToeException;

public class InvalidColumnException extends RuntimeException{
    public InvalidColumnException(int row, int col)
    {
        super("Invalid input : "+row+" "+col);
    }
}
