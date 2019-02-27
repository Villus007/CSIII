import mayflower.*;
public class MyStage extends Stage 
{
    private Cat cat;	
    private Dog dog;
    private Jack jack;
    public MyStage() 
    {
    	setBackground("img/BG/BG.png");    	
    	cat = new Cat();
    	addActor(cat, 300, 300);
    	dog = new Dog();
    	addActor(dog, 400, 400);
    	jack = new Jack();
    	addActor(jack, 400, 200);
    }   
    public void update()
    {
    }    
}