package Main.TicTacToeInterfaceImplementation;

import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterface.WinningStrategy;
import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.Player;

import java.util.List;

public class DiagonalWinnerStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, SymbolEnum currentSymbol) {
        int size= board.getSize();
        boolean isWinner=true;
        for(int i=0;i<size;i++)
        {
            if(board.getCells().get(i).get(i).getSymbol()!=currentSymbol)
            {
                isWinner=false;
            }
        }
        if(isWinner)
        {
            return true;
        }
        isWinner=true;
        for(int i=0;i<size;i++)
        {
            if(board.getCells().get(i).get(size-1-i).getSymbol()!=currentSymbol)
            {
                isWinner=false;
            }
        }
        return isWinner;
    }
}
