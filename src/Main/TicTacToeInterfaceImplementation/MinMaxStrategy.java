package Main.TicTacToeInterfaceImplementation;

import Main.TicTacToeInterface.PlayingStrategy;
import Main.TicTacToeModels.Board;
import Main.TicTacToeModels.BoardCell;

import java.util.List;

public class MinMaxStrategy implements PlayingStrategy {
    @Override
    public BoardCell Play(Board board) {
        //get list of empty cell
        //choose cell from that list
        List<BoardCell> emptyCells= board.getEmptyCell();
        int randomIndex=(int)(Math.random()*emptyCells.size());
        BoardCell cell= emptyCells.get(randomIndex);
        System.out.println(cell.getRow()+" "+cell.getCol());
        return new BoardCell(cell.getRow(),cell.getCol());
    }


}
