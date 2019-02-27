import mayflower.*;
public class PieceActor extends Actor
{
    //INSTANCE VARIABLES
    TicTacToe g;
    private int r;
    private int c;
    //CONSTRUCTOR
    public PieceActor(TicTacToe game, int row, int col) 
    {
        //Initialize instance variables here
        //Set this Actor's image. Blank pieces should display the empty.png image!
       
        this.g = game;
        this.r = row;
        this.c = col;
        setPicture("img/empty.png"); 
    }

    //METHODS
    /*
     *	Checks if this piece is clicked using the isClicked() method
     *	If it is clicked then:
     *		1. Check if the game is over. No pieces can be played if the game is over.
     *		1. Check if this is an empty piece. Pieces cannot be played on top of other pieces.
     *		2. Make this PieceActor display the current player's piece.
     *		3. Tell the game to put the current player's piece in the correct row,col using the addPiece() method.
     *		3. Tell the game it is the next player's turn using the nextPlayer() method.
     */
    public void update()
    {
        if(isClicked())
        {
            if(!g.isGameOver() && g.getPiece(r, c) == null)
            {
              if(g.getCurrentPlayer() == TicTacToePiece.X)
              {
               setPicture("img/x.png");                 
              }
              else
              {
               setPicture("img/o.png");              
              }
              g.nextPlayer();
              g.addPiece(r, c);
            } 
        }
    }
}