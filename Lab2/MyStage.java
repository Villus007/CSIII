/**
 * @(#)MyStage.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;
public class MyStage extends Stage {
    private Cat cat; 
    private Text scoreText;
    private Text livesText;
    private Dog dog;
    public MyStage() 
    {
    	setBackground("img/bluebonnets.jpg");
    	
    	cat = new Cat();
    	addActor(cat, 400, 300);
    	
    	dog = new Dog();
    	addActor(dog, 200, 150);
    	
    	Yarn y1 = new Yarn();
    	addActor(y1, 600, 150);
    	
    	Yarn y2 = new Yarn();
    	addActor(y2, 200, 450);
    	
    	Yarn y3 = new Yarn();
    	addActor(y3, 600, 450);
    	scoreText = new Text("Score: ?");
        addActor(scoreText, 0, 0);
        livesText = new Text("Lives: ");
        addActor(livesText, 0, 20);
    }   
    public void update()
    {
        scoreText.setText("Score: " + cat.getScore() );
        livesText.setText("Lives: " + cat.getLives() );
    }   
}