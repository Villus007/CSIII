public class MyArrayList implements MyList{
    private Object[] o;
    public MyArrayList(){

    }

    /**
     *	Add obj to the end of the list.
     *	This method always returns true
     */
    public boolean add(Object obj){
        Object [] tempv = new Object[size() + 1];
        for(int t = 0; t < size() ; t++){
         tempv[t] = o[t];
        }
        tempv[size()] = obj;
        o = tempv;
        return true;   
    }

    /**
     *	Add obj to the specified index of the list.
     *	If index is too big, then add obj to the end of the list
     *	If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj){
        if(index >= size()){
         add(obj);
        }
        else{
         Object[] temp = new Object[size()+1];
         for(int i = 0; i < index; i++){
            temp[i] = o[i];
            }
         temp[index] = obj;
         for(int j = index + 1; j < temp.length; j++){
            temp[j] = o[j - 1];
            }
            o = temp;
        }
    }

    /**
     *	Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj){
        for(int i = 0; i < size(); i++){
         if(o[i].equals(obj)){
            return true;
            }
        }
        return false;
    }	

    /**
     *	Return the Object located at the specified index
     *	If index is too big or too small, return null
     */
    public Object get(int index){
        if(index >=  size()  || index < 0){
            return null;
        }
        return o[index];
    }	

    /**
     *	Return true if there are no elements in the list
     */
    public boolean isEmpty(){
        if(size() == 0){
        return true;
    }
        return false;
    }

    /**
     *	Remove the Object at the specified index from the list
     *	Return the Object that was removed
     *	If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public Object remove(int index){
       if(size() == 0 || index >= size() || index < 0){
        return null;
        }
        Object obj = o[index];
        Object[] or = new Object[size() - 1];
        for(int i =  0; i < or.length; i++){
         if(i<index){
            or[i] = o[i];
        }
        else{
         or[i] = o[i+1];
        }
        }
        o = or;
        return obj;
    }

    /**
     *	Remove the first Object that is .equals() to obj
     *	Return true if an object was removed
     */
    public boolean remove(Object obj){
        for(int j = 0; j < size(); j ++){
        if(o[j] != null && o[j].equals(obj)){
         remove(j);
         return true;
        }
        }
        return false;
    }

    /**
     *	Change the value stored at index to obj
     *	Return the value that was replaced
     *	If index is too big or too smalll, do not change and values and return null
     */
    public Object set(int index, Object obj){
        if(index >= size() || index < 0){
         return null;
        }
        Object n = o[index];
        o[index] = obj;
        return n;
    }	

    /**
     *	Return the number of elements that are in the list
     */
    public int size(){
        if(o == null){
        return 0;
    }
    return o.length;
    }
}