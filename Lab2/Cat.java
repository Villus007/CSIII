/**
 * @(#)Cat.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;
  public class Cat extends Actor 
{
    private int score;
    private int lives;
    public Cat() 
    {
    	setPicture("img/cat.png");
    	score = 0;
    	lives = 9;
    }   
    public void update()
    {
    	Keyboard kb = getKeyboard();
    	
    	int x = getX();
    	int y = getY();
    	int w = getWidth();
    	int h = getHeight();
    	
    	int leftEdge = w / 2;
    	int topEdge = h / 2;
    	int rightEdge = 800 - w / 2;
    	int bottomEdge = 600 - h / 2 - 28;
    	
    	if(kb.isKeyPressed("up") && y > topEdge)
    	{
    		move(5, "North");
    	}
    	if(kb.isKeyPressed("down") && y < bottomEdge)
    	{
    		move(5, "South");
    	}
    	if(kb.isKeyPressed("left") && x > leftEdge)
    	{
    		move(5, "West");
    	}
    	if(kb.isKeyPressed("right") && x < rightEdge)
    	{
    		move(5, "East");
    	} 
    	Actor[] touching = getTouching();
        for(Actor b : touching)
        {
          if(b instanceof Dog)
         {         
           
           setPosition(400, 300);
           Stage r = getStage();
           decreaseLives(1);
           if(lives == 0)
           {
            r.removeActor(this); 
           }
           
         }
        }                         
    }
    public void increaseScore (int amount)
    {
       score += amount;
    }
    public int getScore()
    {
      return score;
    }
    public void decreaseLives(int life)
    {
        lives -= life;
    }
    public int getLives()
    {
      return lives;
    }   
} 
