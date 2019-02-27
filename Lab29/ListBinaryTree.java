import java.util.List;
import java.util.ArrayList;

public class ListBinaryTree <E>
{
	protected List<E> list;
	
    public ListBinaryTree() 
    {
    	list = new ArrayList<E>();
    }
    
    //add data to this Complete Binary Tree
    public void add(E data)
    {
        
    }
    
    //Add all the elements from the provided list to this Complete Binary Tree
    public void addAll(List<E> data)
    {
    	
    }
    
    //Return the size of this tree
    public int size()
    {
    	return -1;
    }
    
    public String preorder()
    {
    	return preorderHelper(0, "");
    }
    
    private String preorderHelper(int index, String ret)
    {
    	return "";
    }
    
    public String inorder()
    {
    	return inorderHelper(0, "");
    }
    
    private String inorderHelper(int index, String ret)
    {
    	return "";
    }
    
    public String postorder()
    {
    	return postorderHelper(0, "");
    }
    
    private String postorderHelper(int index, String ret)
    {
    	return "";
    }
    
    //return the value stored at the specified index
    //or null if the index is out of bounds
    public E getValueAt(int index)
    {
    	return null;
    }
    
    //return the index of the parent of the node located at the specified index
    //if index is out of bounds, return -1
    //if the node at the specified index does not have a parent, return -1
    public int getParentIndex(int index)
    {
    	return -1;
    }
    
    //return the index of the left child of the node at the specified index
    //if there is no left child, return -1
    public int getLeftIndex(int parentIndex)
    {
    	return -1;
    }
    
    //return the index of the right child of the node at the specified index
    //if there is no right child, return -1
    public int getRightIndex(int parentIndex)
    {
    	return -1;
    }
    
    //a useful utility function to swap two nodes in the tree
    //swap the values located at indexA and indexB
    public void swap(int indexA, int indexB)
    {
    	
    }
    		
}