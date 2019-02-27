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
    
    public double getMedian()
    {
        double middle = 0.0;
        int e = list.size();
        if(list.size()%2 == 1)
        {
          middle = list.get(e/2);
        }
        return middle;
    }
    public int getMode()
    {
        int count1 = 0;
        int count2 = 0;
        int pop1 = 0;
        int pop2 = 0;
        for(int i = 0; i < list.size(); i++)
        {
          pop1 = list.get(i);
          count1 = 1;
          for(int j = i+1; j < list.size(); j++)
          {
            if(pop1 == list.get(j))
            {
                count1++;
            }  
          }
          if(count1 > count2)
          {
            pop2 = pop1;
            count2 = count1;
          }
          else if(count1 == count2)
          {
            pop2 = Math.min(pop2, pop1);  
          }
        }
        return pop2;
    }
    
    public String toString()
    {
        //a format of the arrays.
        String output="SUM:: "+ getSum()+"\n";
        output += "MEAN:: "+ getMean()+"\n";
        output += "MEDIAN:: "+getMedian()+"\n";
        output += "MODE:: "+getMode()+"\n";
        return output;
    }
}