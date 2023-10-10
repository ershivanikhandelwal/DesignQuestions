package TestCases;

import Main.TicTacToeEnums.DifficultyLevel;
import Main.TicTacToeEnums.GameStatus;
import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterfaceImplementation.RandomPlayingStrategy;
import Main.TicTacToeModels.*;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeTest {
    private static final int BOARD_SIZE=3;
    @Test
    public void testCreateGame()
    {
        Player humanPlayer= new HumanPlayer(SymbolEnum.O,new User());
        Player botPlayer= new BotPlayer(SymbolEnum.X, DifficultyLevel.EASY,new RandomPlayingStrategy());
        Game game= Game.getBuilder().createBoard(BOARD_SIZE).createPlayer(humanPlayer).createPlayer(botPlayer).Build();
        Assert.assertEquals(2,game.getPlayers().size());
    }

    @Test
    public void testCreateBoard()
    {
        Board b= new Board(BOARD_SIZE);
        int rowSize= b.getCells().size();
        int colSize= b.getCells().get(0).size();
        Assert.assertEquals("If the ctor called of board class with size n it should create n rows",3,rowSize);
        Assert.assertEquals("If the ctor called of board class with size n it should create n cols ",3,colSize);
    }
}
