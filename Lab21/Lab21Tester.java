import junit.framework.*; 
import java.util.*;

public class Lab21Tester extends TestCase
{
	public void testGetPath()
	{
		Amazons game = new Amazons();
		
		List<Point> path;
		
		path = game.getPath(new Point(5, 5), new Point(3, 4));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points when path should be empty (NorthWest)", 0, path.size());
		
		path = game.getPath(new Point(5, 5), new Point(7, 4));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points when path should be empty (SouthWest)", 0, path.size());
		
		path = game.getPath(new Point(5, 5), new Point(7, 6));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points when path should be empty (SouthEast)", 0, path.size());
		
		path = game.getPath(new Point(5, 5), new Point(3, 6));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points when path should be empty (NorthEast)", 0, path.size());
		
		path = game.getPath(new Point(5, 5), new Point(5, 5));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points when to and from are the same point", 1, path.size());
		assertEquals("getPath.get(0) is not the correct point", path.get(0), new Point(5, 5));
		
		path = game.getPath(new Point(0, 0), new Point(0, 3));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 4, path.size());
		assertEquals("getPath.get(0) is not the correct point (left to right)", path.get(0), new Point(0, 0));
		assertEquals("getPath.get(1) is not the correct point (left to right)", path.get(1), new Point(0, 1));
		assertEquals("getPath.get(2) is not the correct point (left to right)", path.get(2), new Point(0, 2));
		assertEquals("getPath.get(3) is not the correct point (left to right)", path.get(3), new Point(0, 3));
		
		path = game.getPath(new Point(0, 3), new Point(0, 0));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 4, path.size());
		assertEquals("getPath.get(0) is not the correct point (right to left)", path.get(0), new Point(0, 3));
		assertEquals("getPath.get(1) is not the correct point (right to left)", path.get(1), new Point(0, 2));
		assertEquals("getPath.get(2) is not the correct point (right to left)", path.get(2), new Point(0, 1));
		assertEquals("getPath.get(3) is not the correct point (right to left)", path.get(3), new Point(0, 0));
		
		path = game.getPath(new Point(0, 0), new Point(3, 0));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 4, path.size());
		assertEquals("getPath.get(0) is not the correct point (top to bottom)", path.get(0), new Point(0, 0));
		assertEquals("getPath.get(1) is not the correct point (top to bottom)", path.get(1), new Point(1, 0));
		assertEquals("getPath.get(2) is not the correct point (top to bottom)", path.get(2), new Point(2, 0));
		assertEquals("getPath.get(3) is not the correct point (top to bottom)", path.get(3), new Point(3, 0));
		
		path = game.getPath(new Point(3, 0), new Point(0, 0));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 4, path.size());
		assertEquals("getPath.get(0) is not the correct point (bottom to top)", path.get(0), new Point(3, 0));
		assertEquals("getPath.get(1) is not the correct point (bottom to top)", path.get(1), new Point(2, 0));
		assertEquals("getPath.get(2) is not the correct point (bottom to top)", path.get(2), new Point(1, 0));
		assertEquals("getPath.get(3) is not the correct point (bottom to top)", path.get(3), new Point(0, 0));
		
		path = game.getPath(new Point(5, 5), new Point(3, 3));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 3, path.size());
		assertEquals("getPath.get(0) is not the correct point (North West)", path.get(0), new Point(5, 5));
		assertEquals("getPath.get(1) is not the correct point (North West)", path.get(1), new Point(4, 4));
		assertEquals("getPath.get(2) is not the correct point (North West)", path.get(2), new Point(3, 3));
		
		path = game.getPath(new Point(5, 5), new Point(3, 7));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 3, path.size());
		assertEquals("getPath.get(0) is not the correct point (North East)", path.get(0), new Point(5, 5));
		assertEquals("getPath.get(1) is not the correct point (North East)", path.get(1), new Point(4, 6));
		assertEquals("getPath.get(2) is not the correct point (North East)", path.get(2), new Point(3, 7));
		
		path = game.getPath(new Point(5, 5), new Point(7, 3));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 3, path.size());
		assertEquals("getPath.get(0) is not the correct point (South West)", path.get(0), new Point(5, 5));
		assertEquals("getPath.get(1) is not the correct point (South West)", path.get(1), new Point(6, 4));
		assertEquals("getPath.get(2) is not the correct point (South West)", path.get(2), new Point(7, 3));
		
		path = game.getPath(new Point(5, 5), new Point(7, 7));
		assertEquals("getPath should never return null", true, path != null);
		assertEquals("getPath does not return the correct number of points", 3, path.size());
		assertEquals("getPath.get(0) is not the correct point (South East)", path.get(0), new Point(5, 5));
		assertEquals("getPath.get(1) is not the correct point (South East)", path.get(1), new Point(6, 6));
		assertEquals("getPath.get(2) is not the correct point (South East)", path.get(2), new Point(7, 7));
	}
	
	public void testIsPathEmpty()
	{
		Amazons game = new Amazons();
		
		game.arrow(new Point(5, 5));
		game.move(new Point(0, 3), new Point(5, 3));
		game.move(new Point(9, 3), new Point(5, 7));
		
		List<Point> path;
		boolean empty;
		
		path = game.getPath(new Point(5, 3), new Point(5, 4));
		empty = game.isPathEmpty(path);
		assertEquals("isPathEmpty should not check the Point at index 0", true, empty);
		
		path = game.getPath(new Point(5, 3), new Point(5, 5));
		empty = game.isPathEmpty(path);
		assertEquals("isPathEmpty should check the last Point in the path", false, empty);
		
		path = game.getPath(new Point(5, 3), new Point(5, 6));
		empty = game.isPathEmpty(path);
		assertEquals("isPathEmpty should check the middle Points in the path", false, empty);
	}
}