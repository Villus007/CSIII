import mayflower.*;
public class Cat extends AnimatedActor 
{
    private Animation walk;
    private String[] walkImg;
    public Cat() 
    {
    	String c = new String("img/cat/Walk (1).png");   	
    	walkImg = new String[10];   
    	for(int i = 0; i < 10; i++)
    	{
    	  walkImg[i] = "img/cat/Walk (" + (i+1) + ").png";
    	}
    	walk = new Animation(50, walkImg);
    	walk.resize(100, 87);
    	setPicture(c);
    	setAnimation(walk);
    }   
    public void update()
    {
    	super.update();
    }    
}