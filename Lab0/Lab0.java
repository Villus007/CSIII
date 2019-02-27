// name: 
// date:
// per:  

public class Lab0
{

    public Lab0()
    {
        // do not update the constructor
    }

    public  void display (int min, int max)
    {
      for(int i = min; i <= max; i++)
      {
        String s = this.checkValue(i);
        System.out.println(s);
      }
    }

    public String checkValue(int value)
    {
      if(value%5==0 && value%3==0)
      {
       return "Pokemon";
      }
      else if(value%3==0)
      {
       return "Poke";  
      }
      else if(value%5==0)
      {
       return "mon";  
      }
      else
      {
       return Integer.toString(value);  
      }
    }
}
