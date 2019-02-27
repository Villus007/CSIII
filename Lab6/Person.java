/**
 * @author (your name) 
 * @version (date)
 */
import java.io.*;
import java.util.Scanner;

public class Person
{
    // You will not be adding/modifying any code in this class!!!
    private String name;
    private MoviePreferences movies;

    public Person()
    {
        setup(true);
    }

    public Person(boolean b)
    {
        setup(b);
    }

    private void setup(boolean b)
    {
        String name = "";
        movies = new MoviePreferences(b);
    }

    public void askName()
    {
        //Create Scanner object to read user input
        Scanner s = new Scanner(System.in);
        //Prompt user for input
        name = s.next();
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public MoviePreferences getMoviePreferences()
    {
        return movies;
    }

    public void setMoviePreferences(MoviePreferences m)
    {
        movies = m;
    }
}
