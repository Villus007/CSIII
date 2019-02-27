public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    private TicTacToePiece player;
    private TicTacToePiece board[][];
    //CONSTRUCTORS
    public TicTacToe() 
    {
        //Initialize instance variables here
        player = TicTacToePiece.X;
        board = new TicTacToePiece[3][3];
    }

    //METHODS
    /*
     *	Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return player;
    }

    /*
     *	Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        player = (player == TicTacToePiece.X)?TicTacToePiece.O:TicTacToePiece.X; 
    }

    /*
     *	Add the specified piece to the board at the specified row,col and return true
     *	If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if(getPiece(row, col) == null) {
            board[row][col] = player;
            return true;
        }
        return false; 
    }

    /*
     *	Return the piece that is located at the specified row, col
     *	If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        return board[row][col];
    }

    /*
     *	Return true if there is at least 1 empty space left on the board
     *	Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        for(int i = 0; i < 9; i++) {
            if(board[i/3][i%3] == null) {
                return true;
            }
        }
        return false;
    }

    /*	Return null if there is no winner
     *	Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *	Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
        TicTacToePiece winner = null;
        winner = checkRowsForWinner();
        if(winner == null) {
            winner = checkColsForWinner();
        }
        if(winner == null) {
            winner = checkDiagsForWinner();
        }
        return winner;
    }

    /*
     *	Return true if there is a winner or if there are no empty spaces left on the board
     *	Otherwise, return false
     */
    public boolean isGameOver()
    {
        if(checkRowsForWinner() != null || checkColsForWinner() != null || checkDiagsForWinner() != null || hasEmptySpace() != true)
        {
            return true;
        }
        return false;
    }

    //HELPER METHODS
    /*
     *	If a, b, and c are all the same TicTacToe piece, then return that piece
     *	Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        if(a == b && b == c)
        {
            return b;
        }
        return null;
    }

    /*
     *	Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *	Return the first non-null winner that is found (starting from row 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        TicTacToePiece check = null;
        for(int r = 0; r < 3; r++)
        {
            check = checkForWinner(board[r][0], board[r][1], board[r][2]);
            if(check != null)
            {
                break;
            }
        }
        return check;
    }

    /*
     *	Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *	Return the first non-null winner that is found (starting from column 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        TicTacToePiece check = null;
        for(int c = 0; c < 3; c++)
        {
            check = checkForWinner(board[0][c], board[1][c], board[2][c]);
            if(check != null)
            {
                break;   
            }
        }
        return check;
    }

    /*
     *	Use the checkForWinner() helper method to check both of the diagonals for a winner
     *	Check the top left -> bottom right diagonal first
     *	Check the top right -> bottom left diagonal second
     *	Return the first non-null winner that is found
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
        TicTacToePiece check = checkForWinner(board[0][0], board[1][1], board[2][2]);
        TicTacToePiece again = checkForWinner(board[2][0], board[1][1], board[0][2]);
        if(check != null)
        {
            return check;
        }
        else if(again != null)
        {
            return again;
        }
        return null;
    }

}