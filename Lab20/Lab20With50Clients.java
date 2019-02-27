import mayflower.*;
public class Lab20With50Clients
{
  public static void main(String[] args) 
    {
        
       for(int i = 0; i < 25; i++)
        {
         System.out.println(i);
            new TicTacToeClient();
        }
        
    }
}