package Main.TicTacToeInterface;

import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.Player;

import java.util.List;

public interface WinningStrategy {
    public boolean checkWinner(Board board, SymbolEnum currentSymbol);
}
