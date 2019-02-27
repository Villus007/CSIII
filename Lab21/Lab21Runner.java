public class Lab21Runner 
{
    public static void main(String[] args) 
    {
    	AmazonsClient client = new GUIClient();    	
    	client.connect("localhost", 1241);
    }    
}
