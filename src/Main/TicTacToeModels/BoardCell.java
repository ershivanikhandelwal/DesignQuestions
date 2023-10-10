package Main.TicTacToeModels;

import Main.TicTacToeEnums.SymbolEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardCell {
    private int row;
    private int col;
    private SymbolEnum symbol;
    public BoardCell()
    {

    }
    public BoardCell(int r, int c)
    {
        this.row=r;
        this.col=c;
    }
}
