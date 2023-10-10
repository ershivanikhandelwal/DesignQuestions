package Main.TicTacToeModels;

import Main.TicTacToeEnums.SymbolEnum;
import lombok.Getter;

@Getter
public abstract class Player {
    public Player(SymbolEnum _symbol)
    {
        this.symbol=_symbol;
    }
    private SymbolEnum symbol;
    public abstract BoardCell Play(Board board);
}


