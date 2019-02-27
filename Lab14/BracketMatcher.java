import java.util.Stack;
public class BracketMatcher
{
    public static void main(String[] args)
    {

    }

    public static String matchBrackets(String str)
    {	    
        Stack<String> leftStack = new Stack<String>();
        String leftB = "[{(";
        String rightB = "]})";
        for(int i = 0; i < str.length(); i++)
        {
            String letter = str.substring(i,i+1);
            if(leftB.indexOf(letter) > -1)
            {
                leftStack.push(letter);
            }
            if(rightB.indexOf(letter)>-1)
            {
                if(leftStack.isEmpty())
                {
                    return "Too many closing brackets";
                } 
                if(letter.equals(")"))
                {
                    if(!leftStack.peek().equals("("))
                    {
                        return "Bracket mismatch";   
                    }
                    leftStack.pop();
                }
                if(letter.equals("]"))
                {
                    if(!leftStack.peek().equals("["))
                    {
                        return "Bracket mismatch";   
                    }
                    leftStack.pop();
                }
                if(letter.equals("}"))
                {
                    if(!leftStack.peek().equals("{"))
                    {
                        return "Bracket mismatch";       
                    }
                    leftStack.pop();
                }
            }
        }
        if(leftStack.isEmpty())
        {
            return "Balanced";
        }
        else
        {
            return "Not enough closing brackets";
        }
    }
}
