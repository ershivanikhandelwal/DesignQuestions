package Main.TicTacToeModels;

import Main.TicTacToeEnums.GameStatus;
import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeException.InvalidColumnException;
import Main.TicTacToeException.InvalidPlayersException;
import Main.TicTacToeInterface.WinningStrategy;
import Main.TicTacToeInterfaceImplementation.ColumnWinnerStrategy;
import Main.TicTacToeInterfaceImplementation.DiagonalWinnerStrategy;
import Main.TicTacToeInterfaceImplementation.RowWinnerStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex=0;
    private static final int MIN_PLAYERS=2;
    private List<WinningStrategy> winningStrategies= List.of(new RowWinnerStrategy(),new ColumnWinnerStrategy(), new DiagonalWinnerStrategy());
    private Player winner;
    public Game()
    {

    }
    public Game(Builder b)
    {
        this.board=b.game.board;
        this.players=b.game.players;
        this.status=GameStatus.INPROGRESS;
        Start();
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public void makeMove()
    {
        BoardCell boardCell= getNextPlayerMove();
        validateMove(boardCell);
        board.UpdateCell(boardCell);
        if(checkWinner(boardCell.getSymbol()))
        {
            status=GameStatus.FINISHED;
            winner=players.get(nextPlayerIndex);
            return;
        }
        if(checkDrawn())
        {
            status=GameStatus.DRAWN;
            return;
        }
        nextPlayerIndex= (nextPlayerIndex+1)%MIN_PLAYERS;
        makeMove();
    }

    private void validateMove(BoardCell boardCell) {
        if(!this.isEmpty(boardCell.getRow(),boardCell.getCol()))
        {
            throw new InvalidColumnException(boardCell.getRow(),boardCell.getCol());
        }
    }

    private boolean isEmpty(int row, int col) {
        if(board.getCells().get(row).get(col).getSymbol()==null)
        {
            return true;
        }
        return false;
    }

    private BoardCell getNextPlayerMove() {
        Player p= players.get(nextPlayerIndex);
        System.out.println(p.getSymbol() + " is playing: ");
        //get the cell row and col from player
        return p.Play(board);
    }

    public void Start()
    {
        Random random= new Random();
        nextPlayerIndex=random.nextInt(MIN_PLAYERS);
        status=GameStatus.INPROGRESS;
    }

    public boolean checkWinner(SymbolEnum currentSymbol)
    {
        for(WinningStrategy st:winningStrategies)
        {
            boolean isWon=st.checkWinner(board,currentSymbol);
            if(isWon)
            {
                return true;
            }
        }
        return false;
    }

    public boolean checkDrawn()
    {
        return board.isAllCellFilled();
    }

    public static class Builder
    {
        private Game game;
        private Builder()
        {
            game= new Game();
        }

        public Builder createBoard(int size)
        {
            this.game.board=new Board(size);
            return this;
        }

        public Builder createPlayer(Player player)
        {
            this.game.players.add(player);
            return this;
        }

        public Game Build()
        {
            boolean isValid= validate();
            if(!isValid)
            {
                throw new InvalidPlayersException();
            }
            return this.game;
        }

        public boolean validate()
        {
            Set<SymbolEnum> symbols= game.players.stream().map(player->
                    player.getSymbol()).collect(Collectors.toSet());
            if(game.players.size()!=MIN_PLAYERS || symbols.size()!=game.players.size())
            {
                return false;
            }
            return true;
        }
    }
}
