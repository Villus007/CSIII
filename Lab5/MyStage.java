import mayflower.*;
public class MyStage extends Stage 
{
    private Cat cat;	
    public MyStage() 
    {
        setBackground("img/BG/BG.png");
        cat = new Cat();
        addActor(cat, 400, 300);
    }   
    public void update()
    {
        
    }   
}