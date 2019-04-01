import java.util.*;

public class Main {
    //code by daniel reynolds 3/31/2019

    //initializes gameBoard

    private static Game game;

    public static void main(String[] args) {
        game = new Game();
        System.out.println("Welcome to connect four. You need two players for this game.\n");
        game.resetGameBoard();
        Boolean playerGoing = false; //false for player 1, true for player 2
        while(true){ //game loop
            game.printBoard();
            System.out.print("\n");
            String currentInput;
            if(playerGoing){ //player 2
                System.out.println("Player 2's turn, enter a column to drop your \"#\"");
                currentInput = "#";
            }
            else{ //player 1
                System.out.println("Player 1's turn, enter a column to drop your \"@\"");
                currentInput = "@";
            }
            Scanner sc = new Scanner(System.in);
            int column = sc.nextInt();
            game.insertTo(currentInput,column);
            if (game.checkWin(currentInput)) {
                if(playerGoing){
                    System.out.println("Player 2 wins!");
                }
                else{
                    System.out.println("Player 1 wins!");
                }
                System.exit(0);
            }
            game.clearConsole();
            playerGoing = !playerGoing; //switches player
        }
    }




}
