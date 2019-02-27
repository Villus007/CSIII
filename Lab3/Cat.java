import mayflower.*;
public class Cat extends Actor 
{
    private Picture[] frames;
    private int currentFrames; 
    private Timer animationTimer;
    public Cat() 
    {        
    	//Create a Picture object from the specified image file
    	Picture p = new Picture("img/cat/Walk (1).png");    	
    	//Set this Actor's image to the Picture object p
    	setPicture(p);
    	frames = new Picture[10];
    	currentFrames = 0;
    	animationTimer = new Timer();
    	for(int i = 0; i < 10; i++)
    	{ 
    	  frames[i] = new Picture("img/cat/Walk (" + (i+1) + ").png");
    	  frames[i].resize(100, 87);
    	}
    }    
    public void update()
    {
        if(animationTimer.hasTimePassed(90))
        {
          animationTimer.reset();
          currentFrames = (currentFrames + 1)%(frames.length);
          setPicture(frames [currentFrames]);
          currentFrames++;
        }
    }        
}