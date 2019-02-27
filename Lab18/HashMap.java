import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V>
{
    private List<Map.Node<K, V>>[] list;

    public HashMap()
    {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int n)
    {
        list = (ArrayList<Map.Node<K, V>>[])new ArrayList[n];

        //populate the array with Lists
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<Map.Node<K, V>>();
    }

    /*
     *	Helper Method: Calculate the index that an object will be stored in an array using its hashCode
     *
     *	Returns the index where key belongs in the instance variable array using the key's hashCode
     *	Becareful about objects that have a negative hashCode! Remember, you can't have a negative index!
     */
    private int getIndex(Object key)
    {
        int index = key.hashCode();
        index = Math.abs(index);
        index = index % list.length;
        return index;
    }

    /*
     *	Return true if this map contains the specified key
     *	Precondition: key != null
     */
    public boolean containsKey(Object key)
    {
        return keySet().contains(key);
    }

    /*
     *	Return true if this map contins the specified value
     *	Precondition: value != null
     */
    public boolean containsValue(Object value)
    {
        return values().contains(value);
    }
    
    /*
     *	Return true is this map contains no Nodes
     */
    public boolean isEmpty()
    {
        if(size() <= 0)
        {
            return true;  
        }
        return false;
    }

    /*
     *	Return the number of Nodes this map contains
     */
    public int size()
    {
        int count = 0;
        for(int i = 0; i < list.length; i++)
        {
            count += list[i].size();  
        } 
        return count; 
    }

    /*
     *	Return the value of the Node that has the specified key
     *	If there is no Node with the specified key, then return null
     */
    public V get(Object key)
    {
        for(List<Map.Node<K, V>> g : list)
        {
            for(Map.Node<K, V> e : g)
            {
                if(e.getKey().equals(key))
                {
                    return e.getValue();   
                }
            }
        }
        return null;
    }

    /*
     *	Associate the specified value with the specified key
     *	If the map already contains the specified key, the replace 
     *	the value of that key and return the original value.
     *	Otherwise add a new Node to the map and return null.
     *	Precondition: key != null && value != null
     */
    public V put(K key, V value)
    {
        ArrayList<Map.Node<K, V>> p = (ArrayList) list[getIndex(key)];
        for(Map.Node<K, V> u : p)
        {
            if(u.getKey().equals(key))
            {
                return u.setValue(value);
            } 
        }
        p.add(new Map.Node<K, V>(key, value));
        return null;
    }

    /*
     *	Remove the association for the specified key from this map.
     *	Return the value that was associated with the specified key
     *	Or return null if no value was associated with the key.
     *	Precondition: key != null
     */
    public V remove(Object key)
    {
        V rem = null;
        for(List<Map.Node<K, V>> q : list)
        {
            for(Map.Node<K, V> w : q)
            {
                if(w.getKey().equals(key))
                {
                    rem = w.getValue();  
                    q.remove(w);
                    break;
                }    
            }
        }
        return rem;
    }

    /*
     *	Return a List<V> of the values that are stored in this map
     */
    public List<V> values()
    {
        List<V> ret = new ArrayList<V>();
        for(List<Map.Node<K, V>> s : list)
        {
            for(Map.Node<K, V> t : s)
            {
                ret.add(t.getValue()); 
            }
        }
        return ret;
    }

    /*
     *	Return a Set<E> of the keys that have associations in this map
     */
    public Set<K> keySet()
    {                
        Set<K> rut = new ListSet<K>();
        for(List<Map.Node<K, V>> l : list)
        {
            for(Map.Node<K, V> i : l)
            {
                rut.add(i.getKey());
            }   
        }
        return rut;
    }       
}
