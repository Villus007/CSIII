import java.lang.Math;
/**
 * @author (your name) 
 * @version (date)
 */
public class ScatterPlot
{
    // You will not be adding/modifying any code in this class!!!
    private int[][] scatterplot;
    private int[] viewer1;
    private int[] viewer2;
    private double r;
    private String[][] displayScatterPlot;
    private String rDescription;
    public ScatterPlot(int[] v1, int[] v2)
    {
        viewer1 = v1;
        viewer2 = v2;
        calculateCorrelationCoefficient();
        createScatterplot();
    } 

    private void createScatterplot()
    {
        // create the scatterPlot
        scatterplot = new int [10][10];
        displayScatterPlot = new String [10][10];
        for (int r=9; r>=0; r--)
        {
            for (int c=0; c<10; c++)
            {
                if (viewer1[r] == viewer2[c])
                {
                    scatterplot[r][c] = 1;
                    displayScatterPlot[r][c] = "x";
                    System.out.print("x");
                }
                else 
                {
                    displayScatterPlot[r][c] = "  ";
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    private void calculateCorrelationCoefficient()
    {
        // since the user must input 1-10, 
        // without repeating and without skipping, 
        // the sample's mean for both data sets is 5.5 and
        // the sample's standard deviation is 3.0276503
        r = 0;
        int n = 10;
        double prefix = (1/(n-1)); 
        double sum = 0;
        for (int i=0; i<10; i++)
        {
            sum += ((viewer1[i] - 5.5) / (3.0276503)) * ((viewer2[i] - 5.5) / (3.0276503));
        }
        r = sum / (n-1);
        setDescription();
        // source: https://www.wikihow.com/Find-the-Correlation-Coefficient 
    }

    public double getCorrelationCoefficient()
    {
        return r;
    }

    private void setDescription()
    {
        if (Math.abs(r) > 0.8)
            rDescription = "strong";
        else if (Math.abs(r) > 0.5)
            rDescription = "moderately strong";
        else 
            rDescription = "weak";
        if (r > 0)
            rDescription += " and positive";
        else
            rDescription += " and negative";
    }

    public String getDescription()
    {
        return rDescription;
    }

    public String[][] getScatterPlot()
    {
        return displayScatterPlot;
    }
}
