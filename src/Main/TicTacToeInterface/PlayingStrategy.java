package Main.TicTacToeInterface;

import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.BoardCell;

public interface PlayingStrategy {
    public BoardCell Play(Board board);
}
