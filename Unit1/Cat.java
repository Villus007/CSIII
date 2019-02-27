import mayflower.*; 
public class Cat extends Actor
{
    public Cat()
    {
      setPicture("img/cat.png");
    }
    public void update()
    {
      int x = getX();
      int y = getY();
      int w = getWidth();
      int h = getHeight();
      Keyboard kb = getKeyboard();
      if(kb.isKeyPressed("up") && y > 50)
      {
       move(10, "North");  
      }
      else if(kb.isKeyPressed("left") && x > 50)
      {
       move(10, "West");  
      }
      else if(kb.isKeyPressed("right") && x < 840 - w)
      {
       move(10, "East");
      }
      else if(kb.isKeyPressed("down") && y < 600 - h)
      {
       move(10, "South");
      }
    }
}
