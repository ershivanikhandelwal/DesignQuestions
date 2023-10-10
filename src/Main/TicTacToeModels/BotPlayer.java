package Main.TicTacToeModels;

import Main.TicTacToeEnums.DifficultyLevel;
import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterface.PlayingStrategy;

public class BotPlayer extends Player{
    public BotPlayer(SymbolEnum symbol, DifficultyLevel level,PlayingStrategy playingSt)
    {
        super(symbol);
        this.level=level;
        this.strategy=playingSt;
    }
    private DifficultyLevel level;
    private PlayingStrategy strategy;
    public BoardCell Play(Board board)
    {
        BoardCell cell=this.strategy.Play(board);
        cell.setSymbol(this.getSymbol());
        return cell;
    }
}
