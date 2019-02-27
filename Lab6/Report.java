/**
 * @author (your name) 
 * @version (date)
 */

import java.util.Scanner;
import java.io.*;

public class Report
{
    private ScatterPlot graph;
    private Person person1;
    private Person person2;

    public Report(Person p1, Person p2)
    {
        // initialize instance variables
        person1 = p1; 
        person2 = p2;
        // create the graph
        graph = new ScatterPlot (p1.getMoviePreferences().getAnswers(), p2.getMoviePreferences().getAnswers());
    }

    /**
     * Creates the report and saves it to 'filename'. 
     */
    public void createReport(String fileName)
    {
        // TO-DO: Write the report.  Save in a file named 'filename'.
        // 
        // Use the writeToFile method!  
        // See the LAB DESCRIPTION for the layout/requirements of the report

        // HINT: Here is how to call "writeToFile" so the scatterplot displays correctly       
        String s = "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";
        s +="              -+- Movie Compatibility -+-                    \n";
        s +="-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";
        s +="Dear "+ person2.getName();
        s += "* According to the game results, our movie compatibility is "+ graph.getDescription() + "\n";
        s +="The correlation coefficient (r) between our tastes in movies is" + graph.getCorrelationCoefficient() + "\n";
        s +="The strength of the association in movie compatibility is\n";
        s +="determined by the absolute value of the correlation coefficient.\n";
        s +="For a strong association: 0.8 < |r| < 1.0 \n";
        s +="For a moderately strong association: 0.5 < |r| < 0.8\n";
        s +="For a weak association: 0.0 < |r| < 0.5 \n";
        s +="* Here is a scatter plot of our results: \n"; 
        writeToFile(fileName, s, false);
        s = "";
        for (int r=graph.getScatterPlot().length-1; r>=0; r--)
        {
            s = "";
            for (int c = 0; c<graph.getScatterPlot()[r].length; c++)
            {
                s += graph.getScatterPlot()[r][c] + " ";
            }
            writeToFile(fileName, s, true);
        }
        s = "";
        s += "\n";
        s +="Thank you for playing the game. See you at the movies!\n ";
        s +="Sincerely,\n";
        s += "Vishwas";
        writeToFile(fileName, s, true);
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
        //
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
}
