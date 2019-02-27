import java.util.LinkedList;
public class MyStack <E> implements Stack<E>
{
    /**
     *	Return the Object on the top of the Stack
     *	If the Stack is empty, return null
     */
    private LinkedList<E> list;
    public MyStack()
    {
     list = new LinkedList<E>();
    }
    public E peek()
    {
        if(!isEmpty())
        {
         return list.get(list.size() -1);
        }
        return null; 
    }

    /**
     *	Add item to the top of the Stack
     */
    public void push(E item)
    {
     list.add(item);
    }

    /**
     *	Remove the Object from the top of the Stack and return it
     *	If the Stack is empty, return null
     */
    public E pop()
    {
     if(!isEmpty())
     {
       return list.remove(list.size()-1);
     }
     return null;
    }

    /**
     *	Return true is this Stack is empty
     */
    public  boolean isEmpty()
    {
     if(list.size()==0)
     {
      return true;   
     }
     return false;
    }

    /**
     *	Return the number of Objects that are in this Stack
     */
    public int size()
    {
     return list.size(); // make this just size;
    }


}