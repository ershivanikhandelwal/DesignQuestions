package Main.TicTacToeInterfaceImplementation;

import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterface.WinningStrategy;
import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.BoardCell;
import Main.TicTacToeModels.Player;

import java.util.List;

public class ColumnWinnerStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, SymbolEnum currentSymbol) {
        int boardSize=board.getSize();
        for(int col=0;col<boardSize;col++)
        {
            boolean isWinner=true;
            for(int row=0;row<boardSize;row++)
            {
                if(board.getCells().get(row).get(col).getSymbol()!=currentSymbol)
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
