package labs.lab5;

public class ConnectFourGame implements Game{
    private char player1;
    private char player2;
    private char [][] allMoves = new char [6][7];
    private char curr = 'z';
    private int numMoves = 0;


    public int getMin(int col){
        int min = 5;
        while (min > 0){
            if (allMoves[min][col] == 'z'){
                return min;
            }
            min --;
        }
        if (allMoves[min][col] != 'z'){
            return -1;
        }
        return min;
    }

    @Override
    public boolean isValidMove(String move) {
//        A "move" in ConnectFourGame is valid if:
//        The column number represents a valid column on the board that is not already full
//        The mark is 'r' if it is r's turn, or 'y' if it is y's turn.

//        A "move" in ConnectFourGame is a string that contains the column number (0-6), and
//        the character to mark the space with (either 'r' or 'y').
//        For example, placing a red piece down the last column would be done with the command: "6r".
        int col = move.charAt(0) - '0';
        char player = move.charAt(1);

        if (numMoves == 0) {
            assignCells();
        }

        if (move.length() > 2){
            return false;
        }

        if (col > 6 || col < 0 ){
            //out of bounds
            return false;
        }
        if (player != 'r' && player != 'y'){
            // need red or yellow
            return false;
        }

        if (player == curr){
            return false;
        }

        // goes all the way down to the spot you want
        int min = getMin(col);
        return min != -1;
    }

    public void addToMoves(int row, int col, char player){
        allMoves[row][col] = player;
    }

    public void assignCells(){
        for (int i = 0 ; i < 6; i ++ ){
            for (int j = 0 ; j < 7; j++){
                allMoves[i][j] = 'z';
            }
        }
    }
    @Override
    public void executeMove(String move) {
        // need to check if board is empty then reassign all cells to 'z' then

        if (isValidMove(move)){
            int col = move.charAt(0) - '0';
            char player = move.charAt(1);
            int min = getMin(col);
            if (numMoves == 0) {
                assignCells();
                player1 = player;
            }
            else if (numMoves == 1){
                player2 = player;
            }
            addToMoves(min,col, player);
            curr = player;
            numMoves++;
        }

    }

    @Override
    public boolean gameOver() {
        //if there is a winner or board is full
        return determineWinner() != 0 || numMoves == 42;
    }

    @Override
    public String displayBoard() {
        // returns a String representing the current state of the board
        String result = "";
        for (int i = 0 ; i < 6 ; i ++){
            for (int j = 0 ; j < 7; j ++){
                if (j == 6){
                    if (allMoves[i][j] == 'z'){
                        result += "   ";
                    }
                    else{
                        result += " " + allMoves[i][j] + " ";
                    }
                }
                else{
                    if (allMoves[i][j] == 'z'){
                        result += "   |";
                    }
                    else{
                        result += " " + allMoves[i][j] + " |";
                    }
                }
            }
            result += System.lineSeparator();
            if (i != 5){
                result += "---------------------------" + System.lineSeparator();
            }

        }
        return result;
    }

    private boolean checkDirection(int row, int col, int rowDir, int colDir, char player){
        int count = 0 ;
        for (int i = 0; i < 4; i ++){
            int newRow = row + i * rowDir;
            int newCol = col + i * colDir;

            if (newRow < 0 || newRow >= 6 || newCol < 0 || newCol >= 6 || allMoves[newRow][newCol] != player) {
                return false;
            }
            count ++;
        }
        return count == 4;
    }

    @Override
    public int determineWinner() {
        for (int i = 0 ; i < 6 ; i ++){
            for (int j = 0 ; j < 7; j ++){
                if (allMoves[i][j] != 'z'){
                    //non-empty cell
                   if (checkDirection(i, j, 1 , 0, allMoves[i][j]) ||  // check horiz
                           checkDirection(i, j, 0 , 1, allMoves[i][j]) || // check vert
                           checkDirection(i, j, 1 , 1, allMoves[i][j])  || // check diag
                           checkDirection(i, j, 1 , -1, allMoves[i][j])){
                       if (player1 == allMoves[i][j]){
                           return 1;
                       }
                       else if (player2 == allMoves[i][j]){
                           return 2;
                       }
                   }

                }
            }
        }
        return 0;
    }

}
