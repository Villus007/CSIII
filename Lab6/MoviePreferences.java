
/**
 * Write a description of class MoviePreferences here.
 * 
 * @author (your name) 
 * @version (date)
 */

import java.util.Scanner;
import java.io.*;

public class MoviePreferences
{
    // instance variables 
    private int[] movie;
    private String[] intro;
    private String[] movieTypes;
    private String[] movieDescriptions;

    public MoviePreferences()
    {
        setup(true);
    }

    public MoviePreferences(boolean b)
    {
        setup(b);
    }

    private void setup(boolean b)
    {
        // initialize instance variables
        movie = new int[10];

        if (b)
        {
            // Call methods intro and answerQuestions
            createMovies();
            intro();
            answerQuestions(); 
        }        
        // else: assume the user has already answered the questions
        // you will be writing the code for reading the results in from a file 
        // in the 'fromFile' method
    }

    /**
     * Have the user answer the questions
     */
    public void answerQuestions()
    {
        //Create Scanner object to read user input
        Scanner s = new Scanner(System.in);
        System.out.println("Make your choices: \n");
        //Prompt user for input
        for (int i=0; i<movie.length; i++)
        {
            System.out.print(movieTypes[i] + ": ");
            movie[i] = s.nextInt();
        }
    }

    /**
     * Return the user's answers
     */
    public int[] getAnswers()
    {
        return movie;
    }

    /**
     * Set the user's answers
     */
    public void setAnswers(int[] m)
    {
        movie = m;
    }

    /**
     * Return the user's answers
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < movie.length; i++)
        {
            if (i==movie.length -1)
            { 
                s += movie[i];
            }
            else 
            {
                s += movie[i] + " ";
            }
        }
        return s;
    }

    /**
     * Return the user's answers from a saved file
     */
    public int[] fromFile(String fileName)
    {
        // TO-DO: convert the file to a int[]
        int ifile[] = new int[10];
        int i = 0;      
        try
        {
            //Open a Stream to a file you can read from
            Scanner s = new Scanner(new File(fileName));
            //Loop through each line of the file
            while( s.hasNextInt() )
            {
                //Read each line and append it to a String
                ifile[i] = s.nextInt();
                i++;
            }
            //Close the stream
            s.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return ifile;
    }

    public void saveResults (String fileName)
    {
        // TO-DO
        // Call the private 'writeToFile' method
        // (Think about what string you are writing)
        String o = toString();

        writeToFile(fileName, o, false);         
    }

    /**
     * writeToFile method
     * 
     * Write the string 's' and saves it to 'filename'. 
     * If append is 'true', it will append to the file 'fileName'.
     * If append is 'false', it will write over the file 'fileName'.
     */
    private void writeToFile(String fileName, String s, boolean append)
    {
        // TO-DO
        // Don't forget to close the stream after you are done!
        try
        {
            FileWriter fw = new  FileWriter(fileName,  append);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter now = new PrintWriter(bw, true);
            now.println(s);
            now.close();
        }
        catch(IOException x)
        {
            x.printStackTrace();
        }
    }

    /**
     * Tell the user about the program and how to select answers
     */
    private void intro()
    {
        createIntro();
        for (int i = 0; i<intro.length; i++)
        {
            System.out.println(intro[i]);
        }       
        System.out.println("*************************************************************************");
        System.out.println("Here are the categories: \n");
        for (int i=0; i<movie.length; i++)
        {
            System.out.print(movieTypes[i] + ": ");
            System.out.println(movieDescriptions[i] );
        }
        System.out.println("*************************************************************************");
    }    

    /**
     * Create the string arrays that hold movie types and descriptions
     */
    private void createIntro()
    {
        intro = new String [5];
        intro[0] = "Rank each of the following 10 types of movies 1-10 in order of preference, from \n";
        intro[1] = "\t 1 - enjoy this kind of movie the most.  \n\t10 - enjoy this kind of movie the least.\n";
        intro[2] = "You MUST use EVERY number from 1 through 10.  THERE ARE *NO* TIES. \n";
        intro[3] = "Pick your favorite, then your second favorite, then your third favorite, ";
        intro[4] = "and so on till you get to your least favorite.\n";
    }

    /**
     * Create the string arrays that hold movie types and descriptions
     */
    private void createMovies()
    {
        movieTypes = new String [10];
        movieDescriptions = new String [10];

        movieTypes[0] = "Historical Thriller or Drama";
        movieDescriptions[0] = "The Social Network, Lincoln, The Imitation Game";

        movieTypes[1] = "Popular Vulgar Comedy";
        movieDescriptions[1] = "American Pie, The Hangover";

        movieTypes[2] = "Sports Themed";
        movieDescriptions[2] = "Rocky, Field of Dreams, The Wrestler";

        movieTypes[3] = "Epic Cinematic Classics";
        movieDescriptions[3] = "Casablanca, Gone with the Wind";

        movieTypes[4] = "Horror";
        movieDescriptions[4] = "Insidious, the SAW movies, IT";

        movieTypes[5] = "Effects-driven Sci Fi";
        movieDescriptions[5] = "Star Wars, Star Trek, The Matrix";

        movieTypes[6] = "Romantic Comedies";
        movieDescriptions[6] = "When Harry Met Sally, The Princess Bride, Sleepless in Seattle";

        movieTypes[7] = "Superhero Movies";
        movieDescriptions[7] = "The Avengers, Man of Steel, The Dark Knight";

        movieTypes[8] = "Summer Adventure";
        movieDescriptions[8] = "The Fast and the Furious, The Bourne Movies";

        movieTypes[9] = "Pixar Style Animation";
        movieDescriptions[9] = "Toy Story, Cars, Finding Nemo";        
    }
}
