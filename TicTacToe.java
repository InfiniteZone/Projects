import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        boolean player1Turn = true;

        Scanner scan = new Scanner(System.in);
        char[][] board = new char[3][3]; // Creating a 3 by 3 board for each spot on a tic tac toe board.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Each player will take turns placing an 'X' or an 'O' on the board");
        System.out.println("For reference, here are the row and columns of each position\n");
        System.out.println("(1,1)(1,2)(1,3)");
        System.out.println("(2,1)(2,2)(2,3)");
        System.out.println("(3,1)(3,2)(3,3)\n");
        System.out.println("Player 1, please enter your name");
        String p1 = scan.nextLine();
        System.out.println("Player 2, please enter your name");
        String p2 = scan.nextLine();

        drawBoard(board);

        while (true) {

            System.out.println(checkTurn(player1Turn) + "'s turn!");
            System.out.println(checkTurn(player1Turn) + ": Please enter the row and column to play!");
            int row = scan.nextInt();
            int col = scan.nextInt();

            while (row > 3 || col > 3 || board[row - 1][col - 1] != '-') {
                System.out.println("Please enter a valid row and column and make sure the spot isn't taken already!");
                row = scan.nextInt();
                col = scan.nextInt();
            }

            if (checkTurn(player1Turn) == "Player One") {
                board[row - 1][col - 1] = 'X';
            } else {
                board[row - 1][col - 1] = 'O';
            }

            drawBoard(board);

            if (winCondition(board)) {
                if (checkTurn(player1Turn).equals("Player One")) {
                    System.out.println(p1 + " wins!");
                } else {
                    System.out.println(p2 + " wins!");
                }

                break;

            }

            if (checkTie(board)) {
                System.out.println("It's a tie!");
                System.exit(0);
            }

            player1Turn = !player1Turn;
        }

        scan.close();
    }

    /**
     * This method draws each item of the board, printing them in a tic tac toe
     * board formation.
     * 
     * @param board
     * @return Nothing
     */
    public static void drawBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Method inputs the boolean of player1Turn and will return the appropriate
     * String of the player
     * 
     * @param turn
     * @return String of the player
     */
    public static String checkTurn(boolean turn) {
        if (turn) {
            return "Player One";
        } else {
            return "Player Two";
        }
    }

    /**
     * Method checks if a player has won the game
     * 
     * @param board
     * @return A boolean on if the game has been won
     */
    public static boolean winCondition(char[][] board) {
        /*
         * Win condition -> [0][0] == [0][1] == [0][2] [1][0] == [1][1] == [1][2] //
         * Horizontal Match [2][0] == [2][1] == [2][2]
         * 
         * [0][0] == [1][0] == [2][0] [0][1] == [1][1] == [2][1] // Vertical Match
         * [0][2] == [1][2] == [2][2]
         * 
         * [0][0] == [1][1] == [2][2] //Diagonal Match -> Top left to bottom right
         * [0][2] == [1][1] == [2][0] Bottom left to top right
         */
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '-') {
            return true;
        }
        if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '-') {
            return true;
        }
        if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != '-') {
            return true;
        }

        if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '-') {
            return true;
        }
        if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '-') {
            return true;
        }
        if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '-') {
            return true;
        }

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }

    /**
     * Method checks to see if the game has been tied
     * 
     * @param board
     * @return A boolean representing if the game has been tied
     */
    public static boolean checkTie(char[][] board) {
        // If every item is not equal to '-'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}