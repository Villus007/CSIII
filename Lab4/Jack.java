import mayflower.*;
public class Jack extends AnimatedActor 
{
    private Animation walk;
    private String[] walkImg;
    public Jack() 
    {
    	String j = new String("img/jack/Walk (1).png");   	
    	walkImg = new String[7];   
    	for(int i = 1; i < walkImg.length; i++)
    	{
    	  walkImg[i] = "img/jack/Walk (" + (i + 1) + ").png";
    	}
    	walk = new Animation(40, walkImg);
    	walk.resize(100, 100);
    	setPicture(j);
    	setAnimation(walk);
    }   
    public void update()
    {
    	super.update();
    }    
}