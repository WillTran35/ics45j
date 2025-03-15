package labs.lab5;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TicTacToeGame implements Game{
    private ArrayList<String> all_moves = new ArrayList<>(); // tracks all moves
    private char [][] arr = new char [3][3];

    private char player1;
    private char player2;
    private char curr = 'z';
    public ArrayList<String> get_all_moves(){
        return all_moves;
    }

    public void add(String move){
        all_moves.add(move);
//        System.out.println("added" + move);
    }

    public char getCurr(){
        return curr;
    }

    public void setCurr(char c){
        curr = c;
    }

    public void addToArr(int x, int y, char player){
        arr[x][y] = player;
    }

    public boolean checkIfMoveExists(String move){
        int row = move.charAt(0) - '0';
        int column = move.charAt(1) - '0';
        char letter = move.charAt(2);

        for (String s : all_moves){
            int curr_row = s.charAt(0) - '0';
            int curr_column = s.charAt(1) - '0';
            char curr_letter = s.charAt(2);

            if (row == curr_row && curr_column == column){
//                System.out.println("trusdfsfdfe");
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean isValidMove(String move){
//        A "move" in TicTacToeGame is a string that contains the row number (0-2),
//        column number (0-2), and the character to mark the space with (either 'x' or 'o').
//        For example, placing an 'x' in the top middle square (space 0, 1) would be done with
//        the command: "01x".
//        A "move" in TicTacToeGame is valid if:
//        The row and column number represent a valid space on the board that has not yet been taken
//        The mark is 'x' if it is x's turn, or 'o' if it is y'o turn.
        if (move.length() > 3){
//            System.out.print("length > 3");
            return false;
        }
        move = move.toLowerCase();
        int row = move.charAt(0) - '0';
        int column = move.charAt(1) - '0';
        char letter = move.charAt(2);
//        System.out.println(row + " " + column + " " + letter);
        if (row < 0 || row > 2 || column < 0 || column > 2){
//            System.out.println("hi");
//            System.out.print("invalid row col");
            return false;
        }
        if (letter != 'x' && letter != 'o'){
//            System.out.println("hi");
//            System.out.print("invalid letter");
            return false;
        }
//        System.out.println("this is curr before: " + getCurr());
        if (curr == letter){
//            System.out.print("played twice");
            return false;
        }

//        System.out.println("this is curr: " + getCurr());
        boolean x = !checkIfMoveExists(move);
        if (!x){
//            System.out.println("returned not x");
        }
        return x;

    }

    public char checkRows(){
        char curr = 'z';
        int count = 0 ;
        for (int i = 0 ; i < 3 ; i ++){
            for (int k = 0; k < 3; k ++){
                if (arr[i][k] != '\u0000'){
                    if (curr == 'z' || curr == arr[i][k]){
                        curr = arr[i][k];
                        count ++;
                    }
                    else{
                        if (curr != arr[i][k]){
                            curr = 'z';
                            count = 0 ;
                            break;
                        }
                    }
                }
            }
            if (count == 3){
                return curr;
            }
        }
        return curr;
    }

    public char checkColumns(){
        char curr = 'z';
        int count = 0 ;
        for (int i = 0 ; i < 3 ; i ++){
            for (int k = 0; k < 3; k ++){
                if (arr[k][i] != '\u0000'){
//                    System.out.println("im in ehrere");
                    if (curr == 'z' || curr == arr[k][i]){
                        curr = arr[k][i];
                        count ++;
                    }
                    else{
                        if (curr != arr[k][i]){
                            curr = 'z';
                            count = 0 ;
                            break;
                        }
                    }
                }
            }
            if (count == 3){
                return curr;
            }
            else{
                curr = 'z';
                count = 0;
            }
        }
        return curr;
    }

    public char checkDiagonals(){
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]){
            return arr[0][0]; // first diagonal
        }
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]){
            return arr[0][0];
        }
        return 'z'; // second diagonal
    }

    @Override
    public void executeMove(String move) {
        int row = move.charAt(0) - '0';
        int column = move.charAt(1) - '0';
        char letter = move.charAt(2);

        if (isValidMove(move)){
//            System.out.println(row + " " + column + " " + letter);
            if (get_all_moves().isEmpty()){
                player1 = letter;
            }
            else if (get_all_moves().size() == 1){
                player2 = letter;
            }
            add(move);
            addToArr(row, column, letter);
            setCurr(letter);
        }

    }

    @Override
    public boolean gameOver() {
        //returns true if the game is over
        return determineWinner() != 0;
    }

    @Override
    public String displayBoard() {
        // returns a String representing the current state of the board
        String result = "";
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3; j ++){
                if (j == 2){
                    if (arr[i][j] == '\u0000'){
                        result += "   ";
                    }
                    else{
                        result += " " + arr[i][j] + " ";
                    }
                }
                else{
                    if (arr[i][j] == '\u0000'){
                        result += "   |";
                    }
                    else{
                        result += " " + arr[i][j] + " |";
                    }
                }
            }
            result += System.lineSeparator();
            if (i != 2){
                result += "-----------" + System.lineSeparator();
            }

        }
        return result;
    }

    @Override
    public int determineWinner() {
        // if there is a winner, returns the player number of the winner (either 1 or 2); if no winner, returns 0
        if (all_moves.size() < 5){
//            System.out.println(all_moves.size());
            return 0; // not enough moves to have a winner
        }
        char winner = checkRows();
//        System.out.println(winner);
        if (winner == 'z') {
            winner = checkDiagonals();
        }
        if (winner == 'z') {
            winner = checkColumns();
        }

        if (player1 == winner){
            return 1;
        }
        else if (player2 == winner){
            return 2;
        }
        return 0;
    }

    public static void main(String [] args){
        Game game = new TicTacToeGame();

        game.executeMove("00x"); // Player x moves
        assertFalse(game.gameOver());
        game.executeMove("02o"); // Player o moves
        assertFalse(game.gameOver());
        game.executeMove("11x"); // Player x moves
        assertFalse(game.gameOver());
        game.executeMove("12o"); // Player o moves
        assertFalse(game.gameOver());
        game.executeMove("20x"); // Player x moves
        System.out.println(game.gameOver());
        game.executeMove("21o"); // Player o moves
        assertFalse(game.gameOver());
        game.executeMove("22x"); // Player x moves
        assertTrue(game.gameOver()); // Game ends, Player 1 wins

        String board =
                " x |   | o " + System.lineSeparator() +
                        "-----------" + System.lineSeparator() +
                        "   | x | o " + System.lineSeparator() +
                        "-----------" + System.lineSeparator() +
                        " x | o | x " + System.lineSeparator();
        assertEquals(board, game.displayBoard());
        assertEquals(1, game.determineWinner()); // Player 1 wins
    }

}
