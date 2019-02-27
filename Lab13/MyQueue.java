
import java.util.LinkedList;
public class MyQueue<E> implements Queue<E>
{
    private LinkedList<E> list;
    public MyQueue()
    {
        list = new LinkedList<E>();
    }

    public E peek()
    {
        if(list.size() == 0)
        {
            return null;
        }
        return list.get(0); 
    }

    public boolean add(E obj)
    {
        list.add(obj);
        return true;
    }

    /**
     *	Remove the Object from the front of this Queue and return it.
     *	If the Queue is empty, return null
     */
    public E remove()
    {
       if(list.size() == 0)
       {
        return null; 
       }
       return list.remove(0);
    }

    /**
     *	Return true if this Queue is empty
     */
    public boolean isEmpty()
    {
        if(list.size()==0)
        {
            return true;   
        }
        return false;
    }

    /**
     *	Return the number of Objects in this Queue
     */
    public int size()
    {
        return list.size();
    }

}