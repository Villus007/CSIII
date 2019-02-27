import mayflower.*;
public class Dog extends AnimatedActor 
{
    private Animation walk;
    private String[] walkImg;
    public Dog() 
    {
    	String d = new String("img/dog/Walk (1).png");   	
    	walkImg = new String[10];   
    	for(int i = 0; i < 10; i++)
    	{
    	  walkImg[i] = "img/dog/Walk (" + (i+1) + ").png";
    	}
    	walk = new Animation(50, walkImg);
    	walk.resize(100, 150);
    	setPicture(d);
    	setAnimation(walk);
    }   
    public void update()
    {
    	super.update();
    }    
}