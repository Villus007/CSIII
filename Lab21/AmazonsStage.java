import mayflower.*;

public class AmazonsStage extends Stage
{
	//INSTANCE VARIABLES
	private Amazons game;
	private AmazonsClient client;
	private PieceActor[][] board;
	private Piece myPiece;
	
	private Point from;
	private Point to;
	
	private Text turn;

	//CONSTRUCTORS
    public AmazonsStage(AmazonsClient client, Amazons game, Piece piece) 
    {
    	//initialize instance variables
    	this.game = game;
    	this.client = client;
    	this.myPiece = piece;
    	
    	int w = 50;
    	int h = 50;
    	
    	board = new PieceActor[10][10];
    	for(int r = 0; r < board.length; r++)
    	{
    		for(int c = 0; c < board[0].length; c++)
    		{
    			PieceActor actor = new PieceActor(r, c);
    			board[r][c] = actor;
    			actor.setPiece(game.getPiece(new Point(r, c)));
    			addActor(actor, c * w + 75, r * h + 75);
    		}
    	}
    	
    	setBackground("img/background.png");
    	
    	//Display your color			
    	turn = new Text("");
    	addActor(turn, 0, 0);
    	
    	//DoSomethingButton button = new DoSomethingButton(client);
    	//addActor(button, 400, 600);
    }
    
    //METHODS
	public void update()
	{
		if(game.isGameOver())
		{
			//display game over!
			turn.setText("Game Over!");
			
			if(game.getWinner() == null)
			{
				//display: Tie Game!
			}
			else if(game.getWinner() == myPiece)
			{
				//display: You win!
			}
			else
			{
				//display: You lose.
			}
		}
		else
		{
			if(game.getCurrentPlayer() == myPiece)
			{
				String color = myPiece == Piece.BLACK ? "black" : "white";
				turn.setText("It is your turn! (You are " + color + ")");
			}
			else
			{
				turn.setText("Waiting for opponent...");
			}
		}
		
	}   
	
	/**
	 *	Change the piece located a specified Point
	 */
	public void updatePiece(Point p, Piece piece)
	{
		PieceActor actor = board[p.getRow()][p.getCol()];
		actor.setPiece(piece);
	}

    public void reset()
    {
    	for(int r = 0; r < board.length; r++)
    	{
    		for(int c = 0; c < board[0].length; c++)
    		{
    			board[r][c].setPiece(game.getPiece(new Point(r, c)));
    			board[r][c].setSelected(false);
    		}
    	}
    	
    	from = null;
    	to = null;
    }
    
    public void click(int row, int col)
    {
    	Point p = new Point(row, col);
    	if(null == from)
    		clickFrom(p);
    	else if(null == to)
    		clickTo(p);
    	else
    		clickArrow(p);
    }
    
    private void clickFrom(Point p)
    {	
    	from = p;
    	
    	System.out.println("From: " + p);
    	
    	board[p.getRow()][p.getCol()].setSelected(true);
    }
    
    private void clickTo(Point p)
    {
    	to = p;
    	
    	System.out.println("To: " + p);
    	
    	board[to.getRow()][to.getCol()].setPiece(myPiece);
    	board[to.getRow()][to.getCol()].setSelected(true);
    	
    	board[from.getRow()][from.getCol()].setPiece(null);
    	board[from.getRow()][from.getCol()].setSelected(false);
    }
    
    private void clickArrow(Point p)
    {
    	Move move = new Move(from, to, p);
    	
    	System.out.println("Arrow: " + p);
    	
    	board[to.getRow()][to.getCol()].setSelected(false);
    	board[p.getRow()][p.getCol()].setPiece(Piece.ARROW);
    	
    	from = null;
    	to = null;
    	
    	client.send("move " + move.toString());
    }
}