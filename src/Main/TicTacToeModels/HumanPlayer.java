package Main.TicTacToeModels;

import Main.TicTacToeEnums.SymbolEnum;

import java.util.Scanner;

//flyweight
public class HumanPlayer extends Player{
    private Scanner sc= new Scanner(System.in);
    public HumanPlayer(SymbolEnum symbol, User _user)
    {
        super(symbol);
        this.user=_user;
    }
    private User user;
    @Override
    public BoardCell Play(Board board) {
        System.out.println("Enter Row and Column: ");
        int row=sc.nextInt();
        int col=sc.nextInt();
        return new BoardCell(row,col,this.getSymbol());
    }
}
