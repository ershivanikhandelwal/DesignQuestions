package Main.TicTacToeException;

public class InvalidPlayersException extends RuntimeException{
    public InvalidPlayersException()
    {
        super("Invalid List of Players");
    }
}
