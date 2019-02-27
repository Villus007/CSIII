import java.util.LinkedList;
public class MySet<E> implements Set<E>
{
    private LinkedList<E> list;
    public MySet()
    {
        list = new LinkedList<E>();
    }

    public boolean isEmpty()
    {
        if(list.size()==0)
        {
            return true;   
        }
        return false;
    }

    public int size()
    {
        return list.size();
    }

    public boolean contains(Object obj)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).equals(obj))
            {
                return true; 
            }   
        }
        return false;
    }

    public boolean remove(Object obj)
    {
     for(int i = 0; i < list.size(); i++)
     {
      if(list.get(i).equals(obj))
      {
         list.remove(i);
         return true;
      }   
     }
     return false;
    }

    public boolean add(E item)
    {
        if(!list.contains(item))
        {
            return list.add(item);
        }
        return false;
    }
}