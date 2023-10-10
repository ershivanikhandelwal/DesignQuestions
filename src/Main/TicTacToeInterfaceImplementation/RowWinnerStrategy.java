package Main.TicTacToeInterfaceImplementation;

import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterface.WinningStrategy;
import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.BoardCell;
import Main.TicTacToeModels.Player;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RowWinnerStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, SymbolEnum currentSymbol) {
        for(List<BoardCell> rows: board.getCells())
        {
            boolean isWinner=true;
            for(BoardCell cell: rows)
            {
                if(cell.getSymbol()!=currentSymbol)
                {
                    isWinner=false;
                }
            }
            if(isWinner)
            {
                return true;
            }
        }
        return false;
    }
}
