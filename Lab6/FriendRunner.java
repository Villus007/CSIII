public class FriendRunner
{
    public static void main(String[] args)
    {
        // You will not be adding/modifying any code in this class!!!
        
        // This code will run for a FRIEND
        Person friend = new Person ();
        System.out.print("Thanks for answering!  What is your name? ");
        friend.askName();
        
        // Use the "fromFile" method in MoviePreferences.java 
        // to read in a file and save the answers for the "me" object
        Person me = new Person(false);
        int[] myResults = me.getMoviePreferences().fromFile ("me.txt");
        me.getMoviePreferences().setAnswers(myResults);
        
        // Update the "createReport" method in Report.java that uses 
        // the correlation coefficient and scatterplot to create a document of the results
        Report report = new Report (me, friend);  
        report.createReport("movieCompatibilityResults.txt");
    }
}
