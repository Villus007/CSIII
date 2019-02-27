public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head;
    private int indexOf(E obj){
        int i = 0;
        Node<E> n = head.getNext();
        if(n==null){
            return -1;
        }
        while(n!= null && n.getValue().equals(obj)){
            i++;
            n = n.getNext();
        }
        return i;
    }

    private Node<E> getNode(int index){
        int count = 0;
        if(index < 0 || index >= size())
        {
            return null;
        }
        Node<E> n = head.getNext();
        while(n!= null && count < index)
        {
            count++;
            n = n.getNext();     
        }
        return n;
    }

    public MyLinkedList(){
        head = new Node<E>(null);
    }

    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(E obj){
        Node<E> n = head;
        while(n.getNext()!=null){
            n=n.getNext();
        }
        n.setNext(new Node<E> (obj));
        return true;
    }

    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj){
        Node n = head;
        Node foo = new Node<E>(obj);
        Node temp = new Node<E>(null);
        int count = 0;
        if(index >= size()){
            index = size();  
        }
        else if (index < 0){
            index = 0;
        }
        while(n.getNext() != null && count != index)
        {
            n = n.getNext();
            temp = n;
            count++;
        }
        temp = n.getNext();
        n.setNext(foo);
        foo.setNext(temp);
    }

    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj)
    {
        Node m = head;
        while( m.getNext() != null)
        {
          m = m.getNext();
          if(m.getValue().equals(obj))
        {
            return true; 
        }
        }
        return false;
    }

    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public E get(int index)
    {      
        if(index >= size() || index < 0)
        {
            return null;   
        }
        Node<E> n = getNode(index);
        return n.getValue();
    }

    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        if(size() > 0 )
        {
            return false;
        }
        return true;
    }

    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index)
    {
        Node <E> f = getNode(index - 1);
        Node <E> m = getNode(index);
        Node <E> e = getNode(index + 1);
        if(index >= size() || index < 0 || isEmpty())
        {
            return null;
        }
        else
        {
            if(f == null)
            {
                if(e == null)
                {
                    head.setNext(null);
                }
                else
                {
                    head.setNext(e);
                }
            }
            else{
                if(e == null)
                {
                    f.setNext(null);
                }
                else
                {
                    f.setNext(e);
                }
            }
        }
        return m.getValue(); 
    }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(E obj)
    {
        Node r = head; 
        int count = 0;
        while(r.getNext() != null)
        {
            r = r.getNext();
            count++;
            if(r.getValue().equals(obj))
            {
                remove(count);  
            }
        }
        return true;
    }

    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     *  If index is too big or too smalll, do not change and values and return null
     */
    public E set(int index, E obj)
    {
        if(index >= 0 && index <= size())
        {
            int l=0;
            Node n = head;
            while(n.getNext()!=null)
            {
                n=n.getNext();
                if (l==index)
                {
                    Node g = new Node<E>(null);
                    g.setValue(n.getValue());
                    n.setValue(obj);
                    return (E)g.getValue();
                }
                l++;
            }
        }
        return null;
    }

    /**
     *  Return the number of elements that are in the list
     */
    public int size()
    {
        Node n = head.getNext();
        int count = 0;
        while(n != null)
        {
            count++; 
            n = n.getNext();
        }
        return count;
    }
    class Node<E>
    {
        private E value;
        private Node<E> next;    
        public Node(E data)
        {
            value = data;
        }

        public E getValue()
        {
            return value;
        }

        public E setValue(E data)
        {
            E temp = value;
            value = data;
            return temp;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public Node<E> setNext(Node<E> node)
        {
            Node<E> temp = next;
            next = node;
            return temp;
        }
    }
}