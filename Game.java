//written by daniel reynolds 3/31/2019
public class Game {
    private String[][] gameBoard = new String[6][7];
    public Game(){ }

    public void resetGameBoard() {
        for (int r = 0; r < gameBoard.length; r++) {
            for (int c = 0; c < gameBoard[r].length; c++) { //fills gameboard with O'S
                gameBoard[r][c] = "O";
            }
        }
    }

    public void clearConsole(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //clears console so printing is clean
    }

    public void printBoard(){
        System.out.println(" _______________");
        System.out.println("| 0 1 2 3 4 5 6 |");
        System.out.println("|_______________|");
        for(int r = 0; r < gameBoard.length; r++){
            System.out.print("| ");
            for(int c = 0; c < gameBoard[r].length; c++){
                System.out.print(gameBoard[r][c] + " ");
            }
            System.out.print("|\n");
        }
    }

    public void insertTo(String toInsert, int column){ //inserts the players symbol into specified column
        if(gameBoard[0][column] != "O"){
            return;
        }
        for(int r = 0; r < 5; r++){
            if(gameBoard[r + 1][column] != "O") { //check target
                gameBoard[r][column] = toInsert;
                return;
            }
        }
        gameBoard[5][column] = toInsert;
    }

    public Boolean checkWin(String symbol){ //checks the four 2d axes that could result in a win: up, right, diagonal up-left, and diagonal up-right
        //up down
        int inARow = 0;
        String previous = "O";
        for(int c = 0; c < 7; c++){
            for(int r = 0; r < 6; r++){
                if(gameBoard[r][c] == previous && gameBoard[r][c] != "O"){
                    inARow++;
                    if(inARow >= 3){
                        return true;
                    }
                }
                else{
                    inARow = 0;
                }
                previous = gameBoard[r][c];
            }
            inARow = 0;
        }

        //left right
        inARow = 0;
        previous = "O";
        for(int r = 0; r < 6; r++){
            for(int c = 0; c < 7; c++){
                if(gameBoard[r][c] == previous && gameBoard[r][c] != "O"){
                    inARow++;
                    if(inARow >= 3){
                        return true;
                    }
                }
                else{
                    inARow = 0;
                }
                previous = gameBoard[r][c];
            }
            inARow = 0;
        }

        //diagonal upToLeft
        inARow = 0;
        previous = "O";
        for(int c = 6; c >= 0; c--){
            try {
                for (int d = 0; d < 6; d++) {
                    if (gameBoard[5 - d][c - d] == previous && gameBoard[5 - d][c - d] != "O") {
                        inARow++;
                        if (inARow >= 3) {
                            return true;
                        }
                    } else {
                        inARow = 0;
                    }
                    previous = gameBoard[5 - d][c - d];
                }
            }
            catch (Exception e){ }
            inARow = 0;
        }

        //diagonal upToRight
        inARow = 0;
        previous = "O";
        for(int c = 0; c < 7; c++){
            try {
                for (int d = 0; d < 6; d++) {
                    if (gameBoard[5 - d][c + d] == previous && gameBoard[5 - d][c + d] != "O") {
                        inARow++;
                        if (inARow >= 3) {
                            return true;
                        }
                    } else {
                        inARow = 0;
                    }
                    previous = gameBoard[5 - d][c + d];
                }
            }
            catch (Exception e){ }
            inARow = 0;
        }

        //default to false if nothing has been found
        return false;
    }

}
