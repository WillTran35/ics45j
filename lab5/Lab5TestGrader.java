package labs.lab5;
import static org.junit.Assert.*;
import org.junit.Test;

public class Lab5TestGrader {
	
//score: 5pt
@Test
public void TTTGame_1() {
 /*
 Tic Tac Toe game ending in a draw
  * x | o | x
  *-----------
  * x | o | o
  *-----------
  * o | x | x
  */
 Game game = new TicTacToeGame();
 game.executeMove("00x"); // Player x moves
 assertFalse(game.gameOver());
 game.executeMove("01o"); // Player o moves
 assertFalse(game.gameOver());
 game.executeMove("02x"); // Player x moves
 assertFalse(game.gameOver());
 game.executeMove("11o"); // Player o moves
 assertFalse(game.gameOver());
 game.executeMove("10x"); // Player x moves
 assertFalse(game.gameOver());
 game.executeMove("12o"); // Player o moves
 assertFalse(game.gameOver());
 game.executeMove("21x"); // Player x moves
 assertFalse(game.gameOver());
 game.executeMove("20o"); // Player o moves
 assertFalse(game.gameOver());
 game.executeMove("22x"); // Player o moves
 assertTrue(game.gameOver());


 String board =
         " x | o | x " + System.lineSeparator() +
         "-----------" + System.lineSeparator() +
         " x | o | o " + System.lineSeparator() +
         "-----------" + System.lineSeparator() +
         " o | x | x " + System.lineSeparator();
 assertEquals(board, game.displayBoard());
 assertEquals(0, game.determineWinner()); // No winner, game ends in a draw
}
//score: 5pt
@Test
public void TTTGame_2() {
 /*
 Tic Tac Toe game where Player 1 wins (diagonal win from top-left to bottom-right)
  * x |   | o
  *-----------
  *   | x | o
  *-----------
  * x | o | x
  */
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
 assertFalse(game.gameOver());
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
//score: 5pt
@Test
public void TTTGame_3() {
 /*
 Tic Tac Toe game where Player 1 wins (horizontal win on the first row)
  * x | x | x
  *-----------
  * o | x | o
  *-----------
  *    |   |  
  */
 Game game = new TicTacToeGame();

 game.executeMove("00x"); // Player x moves (top-left)
 assertFalse(game.gameOver());
 game.executeMove("10o"); // Player o moves (middle-left)
 assertFalse(game.gameOver());
 game.executeMove("01x"); // Player x moves (top-middle)
 assertFalse(game.gameOver());
 game.executeMove("12o"); // Player o moves (middle-right)
 assertFalse(game.gameOver());
 game.executeMove("02x"); // Player x moves (top-right)
 assertTrue(game.gameOver()); // Game ends, Player 1 wins

 String board =
         " x | x | x " + System.lineSeparator() +
         "-----------" + System.lineSeparator() +
         " o |   | o " + System.lineSeparator() +
         "-----------" + System.lineSeparator() +
         "   |   |   " + System.lineSeparator();
 assertEquals(board, game.displayBoard());
 assertEquals(1, game.determineWinner()); // Player 1 wins
}

//score: 5pt
@Test
public void TTTGame_4() {
/*
Tic Tac Toe game where Player 1 wins
* o | x | x
*-----------
 * x | o| o
*-----------
* o  |  x |  o
*/
Game game = new TicTacToeGame();

game.executeMove("00o"); 
assertFalse(game.gameOver());
game.executeMove("10x"); 
assertFalse(game.gameOver());
game.executeMove("01x"); 
assertFalse(game.gameOver());
game.executeMove("12o"); 
assertFalse(game.gameOver());
game.executeMove("02x"); 
game.executeMove("20o"); 
assertFalse(game.gameOver());
game.executeMove("01x"); 
assertFalse(game.gameOver());
game.executeMove("11o"); 
assertFalse(game.gameOver());
game.executeMove("21x"); 
assertFalse(game.gameOver());
game.executeMove("22o"); 
assertTrue(game.gameOver()); 

String board =
" o | x | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x | o | o " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" o | x | o " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(1, game.determineWinner()); // Player 1 wins
}
//score: 5pt
@Test
public void TTTGame_5() {
/*
Tic Tac Toe game where Player 2 wins
* x | o | x
*-----------
* x | o|  x
*-----------
* o  | o|  
*/
Game game = new TicTacToeGame();

game.executeMove("10x"); 
assertFalse(game.gameOver());
game.executeMove("11o"); 
assertFalse(game.gameOver());
game.executeMove("02x"); 
assertFalse(game.gameOver());
game.executeMove("01o"); 
assertFalse(game.gameOver());
game.executeMove("00x"); 
game.executeMove("20o"); 
assertFalse(game.gameOver());
game.executeMove("12x"); 
assertFalse(game.gameOver());
game.executeMove("21o"); 
assertTrue(game.gameOver()); 

String board =
" x | o | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x | o | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" o | o |   " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(2, game.determineWinner()); // Player 2 wins
}

//score: 5pt
@Test
public void TTTGame_6() {
/*
Tic Tac Toe game where Player 2 wins
* o | x | x
*-----------
* o | o|  o
*-----------
* x  | x|  
*/
Game game = new TicTacToeGame();

game.executeMove("20x"); 
assertFalse(game.gameOver());
game.executeMove("00o"); 
assertFalse(game.gameOver());
game.executeMove("01x"); 
assertFalse(game.gameOver());
game.executeMove("11o"); 
assertFalse(game.gameOver());
game.executeMove("02x"); 
game.executeMove("10o"); 
assertFalse(game.gameOver());
game.executeMove("21x"); 
assertFalse(game.gameOver());
game.executeMove("12o"); 
assertTrue(game.gameOver()); 

String board =
" o | x | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" o | o | o " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x | x |   " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(2, game.determineWinner()); // Player 2 wins
}


//score: 5pt
@Test
public void TTTGame_7() {
/*
Tic Tac Toe game where Player 1 wins
* x | o | x
*-----------
* o | o|  x
*-----------
*   | |   x
*/
Game game = new TicTacToeGame();

game.executeMove("00x"); 
assertFalse(game.gameOver());
game.executeMove("01o"); 
assertFalse(game.gameOver());
game.executeMove("02x"); 
assertFalse(game.gameOver());
game.executeMove("10o"); 
assertFalse(game.gameOver());
game.executeMove("12x"); 
assertFalse(game.gameOver());
game.executeMove("11o"); 
assertFalse(game.gameOver());
game.executeMove("22x"); 
assertTrue(game.gameOver()); 

String board =
" x | o | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" o | o | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
"   |   | x " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(1, game.determineWinner()); // Player 1 wins
}
//score: 5pt
@Test
public void TTTGame_8() {
/*
Tic Tac Toe game where Player 1 wins
* x | o | x
*-----------
*  | o|  
*-----------
*   | o |   
*/
Game game = new TicTacToeGame();

game.executeMove("01o"); 
assertFalse(game.gameOver());
game.executeMove("00x"); 
assertFalse(game.gameOver());
game.executeMove("11o"); 
assertFalse(game.gameOver());
game.executeMove("02x"); 
assertFalse(game.gameOver());
game.executeMove("21o"); 
assertTrue(game.gameOver()); 

String board =
" x | o | x " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
"   | o |   " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
"   | o |   " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(1, game.determineWinner()); 
}
//score: 5pt
@Test
public void TTTGame_9() {
/*
Tic Tac Toe game where Player 2 wins
* o | o | o
*-----------
* x | x  |  
*-----------
*  x |   |   
*/
Game game = new TicTacToeGame();

game.executeMove("10x"); 
assertFalse(game.gameOver());
game.executeMove("00o"); 
assertFalse(game.gameOver());
game.executeMove("11x"); 
assertFalse(game.gameOver());
game.executeMove("01o"); 
assertFalse(game.gameOver());
game.executeMove("20x"); 
assertFalse(game.gameOver());
game.executeMove("02o"); 
assertTrue(game.gameOver()); 

String board =
" o | o | o " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x | x |   " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x |   |   " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(2, game.determineWinner()); // Player 2 wins
}
//score: 5pt
@Test
public void TTTGame_10() {
/*
Tic Tac Toe game where Player 1 wins
* x |   | 
*-----------
* o |  x  | o
*-----------
*  x |  o | x  
*/
Game game = new TicTacToeGame();

game.executeMove("20x"); 
assertFalse(game.gameOver());
game.executeMove("21o"); 
assertFalse(game.gameOver());
game.executeMove("22x"); 
assertFalse(game.gameOver());
game.executeMove("10o"); 
assertFalse(game.gameOver());
game.executeMove("11x"); 
assertFalse(game.gameOver());
game.executeMove("12o"); 
assertFalse(game.gameOver());
game.executeMove("00x"); 
assertTrue(game.gameOver()); 

String board =
" x |   |   " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" o | x | o " + System.lineSeparator() +
"-----------" + System.lineSeparator() +
" x | o | x " + System.lineSeparator();

assertEquals(board, game.displayBoard());
assertEquals(1, game.determineWinner()); // Player 1 wins
}
//Score: 5pt
@Test
public void CFGame_1() {
    /*
    first: r, second: y, r wins
    */
    Game game = new ConnectFourGame();
    game.executeMove("1r");
    game.executeMove("2y");
    game.executeMove("1r");
    game.executeMove("2y");
    game.executeMove("1r");
    game.executeMove("2y");
    game.executeMove("1r");
    assertTrue(game.gameOver());
    assertEquals(1, game.determineWinner());
    String board = 
            "   |   |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   |   |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r | y |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r | y |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r | y |   |   |   |   " + System.lineSeparator();
    assertEquals(board, game.displayBoard());
}


//Score: 5pt
@Test
public void CFGame_2() {
  /*
  first: r, second: y, r wins
  */
  Game game = new ConnectFourGame();
  game.executeMove("1r");
  game.executeMove("2y");
  game.executeMove("3r");
  game.executeMove("3y");
  game.executeMove("2r");
  game.executeMove("3y");
  game.executeMove("2r");
  game.executeMove("0y");
  game.executeMove("0r");
  game.executeMove("3y");
  game.executeMove("0r");
  game.executeMove("3y");
  
  
  assertTrue(game.gameOver());
  assertEquals(2, game.determineWinner());
  String board = 
          "   |   |   |   |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   |   |   | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   |   |   | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " r |   | r | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " r |   | r | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " y | r | y | r |   |   |   " + System.lineSeparator();
assertEquals(board, game.displayBoard());

}

@Test
public void CFGame_3() {
  /*
  first: r, second: y, r wins
  */
  Game game = new ConnectFourGame();
  game.executeMove("1r");
  game.executeMove("1y");
  game.executeMove("1r");
  game.executeMove("1y");
  game.executeMove("1r");
  game.executeMove("1y");
  
  
  game.executeMove("2r");
  game.executeMove("2y");
  game.executeMove("2r");
  game.executeMove("2y");
  game.executeMove("2r");
  game.executeMove("2y");
  
  game.executeMove("3r");
  game.executeMove("3y");
  game.executeMove("3r");
  game.executeMove("3y");
  game.executeMove("3r");
  game.executeMove("3y");
  
  game.executeMove("4r");
  
  
  assertTrue(game.gameOver());
  assertEquals(1, game.determineWinner());
  String board = 
          "   | y | y | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   | r | r | r |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   | y | y | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   | r | r | r |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   | y | y | y |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   | r | r | r | r |   |   " + System.lineSeparator();
assertEquals(board, game.displayBoard());

}
@Test
public void CFGame_4() {
  /*
  first: r, second: y, r wins
  */
  Game game = new ConnectFourGame();
  game.executeMove("0r");
  game.executeMove("1y");
  game.executeMove("2r");
  game.executeMove("3y");
  game.executeMove("4r");
  game.executeMove("5y");
  game.executeMove("6r");
  

  game.executeMove("0y");
  game.executeMove("1r");
  game.executeMove("2y");
  game.executeMove("3r");
  game.executeMove("4y");
  game.executeMove("5r");
  game.executeMove("6y");

  

  game.executeMove("0r");
  game.executeMove("1y");
  game.executeMove("2r");
  game.executeMove("3y");
  game.executeMove("4r");
  game.executeMove("5y");
  game.executeMove("6r");

  game.executeMove("0y");

  
  assertTrue(game.gameOver());
  assertEquals(2, game.determineWinner());
  String board = 
          "   |   |   |   |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          "   |   |   |   |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " y |   |   |   |   |   |   " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " r | y | r | y | r | y | r " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " y | r | y | r | y | r | y " + System.lineSeparator() +
          "---------------------------" + System.lineSeparator() +
          " r | y | r | y | r | y | r " + System.lineSeparator();

assertEquals(board, game.displayBoard());

}

@Test
public void CFGame_5() {
    Game game = new ConnectFourGame();

    // Fill the board alternately to create a draw scenario
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");

    game.executeMove("1r");
    game.executeMove("1y");
    game.executeMove("1r");
    game.executeMove("1y");
    game.executeMove("1r");
    game.executeMove("1y");

    game.executeMove("2r");
    game.executeMove("2y");
    game.executeMove("2r");
    game.executeMove("2y");
    game.executeMove("2r");
    game.executeMove("2y");
    
    game.executeMove("3r");

    

    assertTrue(game.gameOver());
    assertEquals(1, game.determineWinner()); // Assuming 0 represents a draw

    // Expected board layout
    String board = 
            " y | y | y |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r | r |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | y | y |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r | r |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | y | y |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r | r | r |   |   |   " + System.lineSeparator();

      assertEquals(board, game.displayBoard());
}


@Test
public void CFGame_6() {
    Game game = new ConnectFourGame();

    // Fill the board alternately to create a draw scenario
    game.executeMove("4r");
    game.executeMove("4y");
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("3r");
    game.executeMove("5y");

    game.executeMove("2r");
    game.executeMove("4y");
    game.executeMove("5r");
    game.executeMove("6y");
    game.executeMove("3r");
    game.executeMove("1y");

    game.executeMove("1r");
    game.executeMove("2y");
    game.executeMove("6r");
    game.executeMove("5y");
    game.executeMove("4r");
    game.executeMove("2y");
    
    game.executeMove("5r");
    game.executeMove("6y");
    
    game.executeMove("1r");
    game.executeMove("3y");
    
    

    // Validate game is over and it's a draw
    assertTrue(game.gameOver());
    assertEquals(2, game.determineWinner()); // Assuming 0 represents a draw

    // Expected board layout
 // Expected board layout
    String board = 
            "   |   |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   |   |   |   |   |   | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   |   |   |   | r | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r | y | y | y | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | r | y | r | y | r | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   | y | r | r | r | y | r " + System.lineSeparator();

    assertEquals(board, game.displayBoard());

}


@Test
public void CFGame_7() {
    Game game = new ConnectFourGame();

    // Fill the board alternately to create a draw scenario
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");

    game.executeMove("3r");
    game.executeMove("3y");
    game.executeMove("3r");
    game.executeMove("3y");
    game.executeMove("3r");
    game.executeMove("3y");

    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");
    
    
    game.executeMove("2r");
    game.executeMove("2y");
    game.executeMove("2r");
    game.executeMove("2y");
    game.executeMove("2r");
    game.executeMove("2y");
    
    
    game.executeMove("5r");
    game.executeMove("5y");
    game.executeMove("5r");
    game.executeMove("5y");
    game.executeMove("5r");
    game.executeMove("5y");
    
    
    game.executeMove("1r");
    
    
    


    assertTrue(game.gameOver());
    assertEquals(1, game.determineWinner()); // Assuming 0 represents a draw

 // Expected board layout
    String board = 
            " y |   | y | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r |   | r | r |   | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y |   | y | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r |   | r | r |   | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y |   | y | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r | r | r |   | r | r " + System.lineSeparator();

    assertEquals(board, game.displayBoard());


}

@Test
public void CFGame_8() {
    Game game = new ConnectFourGame();

    game.executeMove("4r");
    game.executeMove("5y");
    game.executeMove("6r");
    game.executeMove("1y");
    game.executeMove("2r");
    game.executeMove("3y");

    game.executeMove("4r");
    game.executeMove("5y");
    game.executeMove("6r");
    game.executeMove("0y");
    game.executeMove("1r");
    game.executeMove("0y");

    game.executeMove("3r");
    game.executeMove("2y");
    game.executeMove("0r");
    game.executeMove("1y");
    game.executeMove("2r");
    game.executeMove("3y");
    
    
    game.executeMove("4r");
    game.executeMove("5y");
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("5r");
    game.executeMove("1r");
    
    
    


    assertTrue(game.gameOver());
    assertEquals(1, game.determineWinner()); 

 // Expected board layout
    String board = 
           
            "   |   |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   |   |   |   |   |   |   " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            "   |   |   |   |   | r | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | y | r | y | r | y | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | r | y | r | r | y | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | y | r | y | r | y | r " + System.lineSeparator();

    assertEquals(board, game.displayBoard());



}

@Test
public void CFGame_9() {
    /*
    Alternating moves, resulting in a draw
    */
    Game game = new ConnectFourGame();


    game.executeMove("1r");
    game.executeMove("1y");
    game.executeMove("1r");
    game.executeMove("1y");
    game.executeMove("1r");
    game.executeMove("1y");

    game.executeMove("3r");
    game.executeMove("3y");
    game.executeMove("3r");
    game.executeMove("3y");
    game.executeMove("3r");
    game.executeMove("3y");

    game.executeMove("5r");
    game.executeMove("5y");
    game.executeMove("5r");
    game.executeMove("5y");
    game.executeMove("5r");
    game.executeMove("5y");
    
    
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");
    game.executeMove("0r");
    game.executeMove("0y");
    
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");
    
    game.executeMove("4r");
    
    


    assertTrue(game.gameOver());
    assertEquals(1, game.determineWinner()); 

 // Expected board layout
    String board = 
            " y | y |   | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r |   | r |   | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | y |   | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r |   | r |   | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | y |   | y |   | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | r |   | r | r | r | r " + System.lineSeparator();

    assertEquals(board, game.displayBoard());




}

@Test
public void CFGame_10() {
    /*
    Alternating moves, resulting in a draw
    */
    Game game = new ConnectFourGame();


    game.executeMove("0r");
    game.executeMove("1y");
    game.executeMove("0r");
    game.executeMove("1y");
    game.executeMove("0r");
    game.executeMove("1y");

    game.executeMove("1r");
    game.executeMove("0y");
    game.executeMove("1r");
    game.executeMove("0y");
    game.executeMove("1r");
    game.executeMove("0y");

    game.executeMove("2r");
    game.executeMove("3y");
    game.executeMove("2r");
    game.executeMove("3y");
    game.executeMove("2r");
    game.executeMove("3y");
    game.executeMove("3r");
    game.executeMove("2y");
    game.executeMove("3r");
    
    
    
    game.executeMove("2y");
    game.executeMove("3r");
    game.executeMove("2y");
    game.executeMove("4r");
    game.executeMove("5y");
    
    game.executeMove("4r");
    game.executeMove("5y");
    game.executeMove("4r");
    game.executeMove("5y");
    game.executeMove("5r");
    game.executeMove("4y");
    
    game.executeMove("5r");
    game.executeMove("4y");
    game.executeMove("5r");
    game.executeMove("4y");
    
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");
    game.executeMove("6r");
    game.executeMove("6y");


    assertTrue(game.gameOver());
    assertEquals(0, game.determineWinner()); 

 // Expected board layout
    String board = 
            " y | r | y | r | y | r | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | r | y | r | y | r | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " y | r | y | r | y | r | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | y | r | y | r | y | r " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | y | r | y | r | y | y " + System.lineSeparator() +
            "---------------------------" + System.lineSeparator() +
            " r | y | r | y | r | y | r " + System.lineSeparator();

    assertEquals(board, game.displayBoard());




}


}