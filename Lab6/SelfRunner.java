import java.util.Scanner;
import java.io.*;
public class SelfRunner
{
    public static void main(String[] args)
    {
        // You will not be adding/modifying any code in this class!!!
        
        // This code will run for YOU 
        Person me = new Person ();
        
        // Save your results in the "me.txt" file 
        me.getMoviePreferences().saveResults("me.txt");
    }
}
