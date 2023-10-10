package Main.TicTacToeModels;

import Main.TicTacToeEnums.SymbolEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<BoardCell>> cells= new ArrayList<>();
    public Board(int s)
    {
        this.size=s;
        cells= initializeCells();
    }

    private List<List<BoardCell>> initializeCells()
    {
        List<List<BoardCell>> cells= new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            List<BoardCell> rowCells=new ArrayList<>();
            for(int j=0;j<size;j++)
            {
                rowCells.add(j,new BoardCell(i,j));
            }
            cells.add(rowCells);
        }
        return cells;
    }

    public void UpdateCell(BoardCell cell) {
        cells.get(cell.getRow()).get(cell.getCol()).setSymbol(cell.getSymbol());
        printBoard();
    }

    private BoardCell getBoardCell(int row, int col) {
        return cells.get(row).get(col);
    }

    public boolean isAllCellFilled() {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(cells.get(i).get(j).getSymbol()==null)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(getBoardCell(i,j).getSymbol()!=null) {
                    System.out.print("|" + getBoardCell(i, j).getSymbol() + "| ");
                }
                else {
                    System.out.print("|_| ");
                }
            }
            System.out.println("");
        }
    }

    public List<BoardCell> getEmptyCell()
    {
        return cells.stream().flatMap(List::stream)
                .filter(cell -> cell.getSymbol()==null)
                .toList();
    }
}
