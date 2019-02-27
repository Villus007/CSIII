import mayflower.*;
import java.awt.Color;
//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text header;
    private Text status;
    private Text winner;
    //CONSTRUCTOR
    public TicTacToeStage() 
    {
        setBackground("img/background.png");

        game = new TicTacToe();

        //Add a label to the top of the screen that displays the name of the game
        header = new Text("Tic Tac Toe", Color.WHITE);
        addActor(header, 0, 0);
        status = new Text("X turn", Color.WHITE);
        addActor(status, 0, 25);
        //TODO: Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        //	    Each PieceActor needs a reference to the TicTacToe object
        for(int tic = 0; tic < 3; tic++)
        {
            for(int tac = 0; tac < 3; tac++)
            {
                addActor(new PieceActor(game, tic, tac), 150 + 105 * tic, 150 + 105 * tac);  
            }   
        }
    }

    //METHODS
    /*
     *	Check if the game is over
     *		If the game is over, display the text "Game Over!" on the screen
     *		If there is a winner, display the text "X wins!" or "O wins!" on the screen
     *		If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
     *		Display the current player's turn on the screen: "It is X's turn" or "It is O's turn"
     */
    public void update()
    {
        if(game.isGameOver())
        {
            status.setText("Game Over!");
            if(!game.hasEmptySpace() && game.getWinner() != null)
            {
                if(game.getCurrentPlayer() == TicTacToePiece.O)
                {
                    status.setText("X Wins");
                }
                else if(game.getCurrentPlayer() == TicTacToePiece.X)
                {
                    status.setText("O Wins");
                }
            }
            if(game.getWinner() != null )
            {
                if(game.getWinner() == TicTacToePiece.O)
                {
                    status.setText("X Wins");
                }
                else if(game.getWinner() == TicTacToePiece.X)
                {
                    status.setText("O Wins");
                }
            }
            else
            {
                status.setText("Tie Game!");
            }
        }
        else
        {
            status.setText(game.getCurrentPlayer().name() + " turn");
        }
    }
}