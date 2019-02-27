import java.util.List;
import mayflower.*;

public class GUIClient extends AmazonsClient
{
	private AmazonsStage stage;
	private Mayflower mayflower;
	
	public GUIClient()
	{
		stage = null;
		mayflower = null;
	}
	
	/**
	 *	Getter for stage instance variable
	 */
	public AmazonsStage getStage()
	{
		return stage;
	}
	
	/**
	 *	Create a new AmazonStage and open a Mayflower window
	 */
	public void onYouAre(Piece piece)
	{
		super.onYouAre(piece);
		
		stage = new AmazonsStage(this, getGame(), getMyPiece());
		if(null == mayflower)
			mayflower = new Mayflower("Amazons & Arrows", 800, 800, stage);
		else
			mayflower.setStage(stage);
	}
	
	/**
	 *	Move the pieces on the AmazonsStage
	 */
	public void onMove(Piece piece, int fromRow, int fromCol, int toRow, int toCol, int arrowRow, int arrowCol)
	{		
		super.onMove(piece, fromRow, fromCol, toRow, toCol, arrowRow, arrowCol);
		
		stage.updatePiece(new Point(fromRow, fromCol), null);
		stage.updatePiece(new Point(toRow, toCol), piece);
		stage.updatePiece(new Point(arrowRow, arrowCol), Piece.ARROW);
	}
    
}