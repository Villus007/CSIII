/**
 * @(#)Yarn.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;
public class Yarn extends Actor {
    public Yarn() {
    	setPicture("img/yarn.png");
    }   
    public void update()
    {
      Actor[] touching = getTouching();
      for(Actor a : touching)
      {
        if(a instanceof Cat)
        {
         Cat c = (Cat) a;
         Stage s = getStage(); 
         s.removeActor(this);
         c.increaseScore( 1 );
        }
      }
    }    
}