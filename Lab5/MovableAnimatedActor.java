import mayflower.*;
public class MovableAnimatedActor extends AnimatedActor
{   
    private Animation walkRight;
    private Animation idle;
    private String currentAction;    
    public MovableAnimatedActor()
    {
       currentAction = null;
    }
    public void update()
    {
       super.update(); 
       String newAction = null;
       if(currentAction == null)
       {
         currentAction = "idle";
         setAnimation(idle);
         newAction = "idle";
       }
       Keyboard kb = getKeyboard();       
       if(kb.isKeyPressed("right"))
       {         
         if(!currentAction.equals("walkRight"))
         {
             currentAction = "walkRight";
             setAnimation(walkRight);            
         }
         move(1, "East");
       } 
       else if (!currentAction.equals("idle"))
       {
         currentAction = "idle";
         setAnimation(idle);
       }
       
    }
    public void setWalkRightAnimation(Animation ani)
    {
       walkRight = ani;
    }
    public void setIdleAnimation(Animation ani)
    {
       idle = ani;
    }
}
