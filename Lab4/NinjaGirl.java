import mayflower.*;
public class NinjaGirl extends AnimatedActor 
{
    private Animation walk;
    private String[] walkImg;
    public NinjaGirl() 
    {
    	String d = new String("img/ninjagirl/Jump_000.png");   	
    	walkImg = new String[10];   
    	for(int i = 0; i < 10; i++)
    	{
    	  walkImg[i] = "img/ninjagirl/Jump_00 (" + (i+1) + ").png";
    	}
    	walk = new Animation(50, walkImg);
    	walk.resize(100, 90);
    	setPicture(d);
    	setAnimation(walk);
    }   
    public void update()
    {
    	super.update();
    }    
}
