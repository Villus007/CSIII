import mayflower.*;
public class Cat extends MovableAnimatedActor 
{
    Animation walk;	
    Animation idle;
    public Cat() 
    {
    	walk = new Animation(50, new String[] 
    	{
    	  "img/cat/Walk (1).png",
    	  "img/cat/Walk (2).png",
          "img/cat/Walk (3).png",
    	  "img/cat/Walk (4).png",
    	  "img/cat/Walk (5).png",
    	  "img/cat/Walk (6).png",
    	  "img/cat/Walk (7).png",
          "img/cat/Walk (8).png",
    	  "img/cat/Walk (9).png",
    	  "img/cat/Walk (10).png"
    	});
           walk.resize(100, 87);
    	   setWalkRightAnimation(walk);
    	idle = new Animation(50, new String[]
    	{
    	  "img/cat/Idle (1).png",
    	  "img/cat/Idle (2).png", 
    	  "img/cat/Idle (3).png",
    	  "img/cat/Idle (4).png",
    	  "img/cat/Idle (5).png",
          "img/cat/Idle (6).png",
    	  "img/cat/Idle (7).png",
    	  "img/cat/Idle (8).png",
    	  "img/cat/Idle (9).png",
          "img/cat/Idle (10).png"
    	 });
    	   idle.resize(100, 87);
    	   setIdleAnimation(idle);
    }   
    public void update()
    {
    	super.update();
    }      
}