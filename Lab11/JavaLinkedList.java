public class JavaLinkedList
{
    private MyLinkedList<Integer> list;

    /**
     *  Default Constructor
     *  Create a new MyLinkedList of Integers
     */
    public JavaLinkedList()
    {
        list = new MyLinkedList<Integer>();
    }

    /**
     *  Create a new MyLinkedList of Integers from the array
     */
    public JavaLinkedList(int[] nums)
    {  
        list = new MyLinkedList<Integer>();
        //adds all the numbers form nums[] in list.
        for(int i = 0; i < nums.length; i++)
        {
          list.add(nums[i]);
        }
    }

    /**
     *  Return the sum of all the items in the list
     */
    public double getSum(  )
    {
        double total=0;
        //adds all the individual numbers in the list.
        for(int k = 0; k < list.size(); k++)
        {
          total += list.get(k);
        }
        return total;
    }

    /**
     *  Return the mean of all the items in the list
     */
    public double getMean(  )
    {
        //gets the total from getSum() and divides it by length for average.
        return getSum()/list.size();
    }
    
    /**
     *  Return the largest item in the list
     */
    public int getLargest()
    {
        int largest=Integer.MIN_VALUE;
        //loops through list
        for(int g = 0; g < list.size(); g++)
        {
          //sees if anything is larger then largest
          if(largest < list.get(g))
          {
            largest = list.get(g); 
          }
        }
        return largest;
    }

    /**
     *  Return the smallest item in the list
     */
    public int getSmallest()
    {
        int smallest = smallest=Integer.MAX_VALUE;
        //loops througth list
        for(int s = 0; s < list.size(); s++)
        {
         //sees if anything is smaller then smallest
         if(smallest > list.get(s))
         {
           smallest = list.get(s);   
         }
        }
        return smallest;
    }

    /**
     *  Return a string with this format:
     *  
     *  SUM:: 10.0
     *  MEAN:: 4.65
     *  SMALLEST:: -1.23
     *  LARGEST:: 5.0
     */
    public String toString()
    {
        //a format of the arrays.
        String output="SUM:: "+ getSum()+"\n";
        output += "MEAN:: "+ getMean()+"\n";
        output += "SMALLEST:: "+ getSmallest()+"\n";
        output += "LARGEST:: "+ getLargest()+"\n";
        return output;
    }
}