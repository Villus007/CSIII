import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Palindrome
{
	public static void main(String[] args)
	{
		
	}
	
	public static boolean isPalindrome(String str)
	{	
	   Stack<String> one = new Stack<String>();
	   Queue<String> two = new LinkedList<String>();
	   String legal = "abcdefghijklmnopqrstuvwxyz";
	   str = str.toLowerCase();
	   String letter = "";
	   for(int i = 0; i < str.length(); i++)
	   {
	    letter = str.substring(i, i+1);
	    if(legal.indexOf(letter.toLowerCase()) > -1 && letter != "")
	    {	        
	        one.push(letter.toLowerCase());
	        two.add(letter.toLowerCase());
	    }
	   }
	   while(!two.isEmpty())
	   {
	    if( two.remove().equals(one.pop()))
	    {
	     return true;   
	    }
	   }
	   return false;
	}

}