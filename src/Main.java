import Main.TicTacToeEnums.DifficultyLevel;
import Main.TicTacToeEnums.GameStatus;
import Main.TicTacToeEnums.SymbolEnum;
import Main.TicTacToeInterfaceImplementation.MinMaxStrategy;
import Main.TicTacToeModels.*;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final int BOARD_SIZE=3;
    public static void main(String[] args) {
        //ask for user input
        //create game
        //initialize bot player
        //start game
        //assigning first player
        //mark the game inprogress
        //start playing
        Player p1 =createUser();
        Player p2 =createBotPlayer(p1.getSymbol());
        Game g= createGame(p1,p2);
        g.Start();
        while(g.getStatus() == GameStatus.INPROGRESS)
        {
            g.makeMove();
        }
        if(g.getStatus()==GameStatus.DRAWN)
        {
            System.out.println("Game Draw");
        }
        if(g.getStatus()==GameStatus.FINISHED)
        {
            System.out.println(g.getWinner().getSymbol() + " won the game.");
        }
    }

    private static Game createGame(Player p1,Player p2)
    {
        return Game.getBuilder().createBoard(BOARD_SIZE).createPlayer(p1).createPlayer(p2).Build();
    }
    private static Player createBotPlayer(SymbolEnum humanSymbol) {
        SymbolEnum s2;
        if(humanSymbol.equals(SymbolEnum.O))
        {
           s2=SymbolEnum.X;
        }
        else
        {
            s2=SymbolEnum.O;
        }
        return new BotPlayer(s2, DifficultyLevel.EASY,new MinMaxStrategy());
    }

    private static Player createUser()
    {
        User u= new User();
        System.out.println("Welcome to TicTacToe");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Name: ");
        u.setName(sc.nextLine());
        System.out.println("Enter Email: ");
        u.setEmail(sc.nextLine());
        try
        {
            System.out.println("Enter Symbol: ");
            SymbolEnum symb=SymbolEnum.valueOf(sc.nextLine());
            return new HumanPlayer(symb,u);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("Invalid Symbol");
            return null;
        }
    }

}