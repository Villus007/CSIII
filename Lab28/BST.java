import java.util.List;

public class BST<E extends Comparable>
{
    private BNode<E> root;

    public BST() 
    {
        root = null;
    }

    //add data to this BST
    public void add(E data)
    {        
        if(root == null)
        {
         root =  new BNode<E>(data);
        }
        else
        {
         addHelper(root, new BNode<E>(data));
        }
    }

    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
        if(addMe.getData().compareTo(node.getData()) < 0)
        {
          if(node.getLeft() != null)
          {
             addHelper(node.getLeft(), addMe);
          }
          else
          {
             node.setLeft(addMe);
          }
        }
        if(addMe.getData().compareTo(node.getData()) >= 0)
        {
         if(node.getRight() != null)
         {
            addHelper(node.getRight(), addMe);
         }
         else
         {
            node.setRight(addMe);
         }
        }
    }

    public void addAll(List<E> data)
    {
      for(E all : data)
      {
        add(all);
      }
    }

    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
        int s = 1;
        if(root.hasRightChild())
        {
         s += sizeHelper(root.getRight());
        }
        if(root.hasLeftChild())
        {
         s += sizeHelper(root.getLeft());
        }
        return s;
    }

    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        int i = 1;
        if(node.hasRightChild())
        {
         i += sizeHelper(node.getRight());
        }
        if(node.hasLeftChild())
        {
         i += sizeHelper(node.getLeft());
        }
        return i;
    }

    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String pre = new String();
        pre = preorderHelper(root, "");
        pre = "["+pre+"]";
        return pre;
    }

    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {
        ret += node.getData();
        if(node.hasLeftChild())
        {
         ret += ", " + preorderHelper(node.getLeft(), "");
        }
        if(node.hasRightChild())
        {
         ret += ", " + preorderHelper(node.getRight(), "");
        }
        return ret;
    }

    //Return a string with the data of this BST in order
    public String inorder()
    {
        String in = new String();
        in = inorderHelper(root, "");
        in = "["+in+"]";
        return in;
    }

    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {
        
        if(node.hasLeftChild())
        {
         ret += inorderHelper(node.getLeft(), "")+", ";
        }
        ret += node.getData();
        if(node.hasRightChild())
        {
         ret += ", " + inorderHelper(node.getRight(), "");
        }
        return ret;
    }

    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String post = new String();
        post = postorderHelper(root, "");
        post = "["+post+"]";
        return post;
    }

    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
        if(node.hasLeftChild())
        {
         ret += postorderHelper(node.getLeft(), "") + ", ";
        }
        if(node.hasRightChild())
        {
         ret += postorderHelper(node.getRight(), "") + ", ";
        }
        ret += node.getData();
        return ret;
    }

    //Check if this BST contains the specified data
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }

    //Recursive helper method for contains
    private boolean containsHelper(BNode<E> node, E data)
    {
        if(node.getData().compareTo(data) > 0)
        {
         if(node.hasLeftChild())
         {
          return containsHelper(node.getLeft(), data);   
         }
        }
        else if(node.getData().compareTo(data) < 0)
        {
         if(node.hasRightChild())
         {
          return containsHelper(node.getRight(), data);   
         }
        }
        else
        {
         return true;
        }
        return false;
    }

    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.
    public boolean remove(E data)
    {
        BNode<E> temp = root;
        BNode<E> dad = null;
        while(root != null && root.getData() != data)
        {
         dad = root;
         if(temp.getData().compareTo(data) > 0)
         {
          temp = root.getLeft();   
         }
         if(temp.getData().compareTo(data) < 0)
         {
          temp = root.getRight();   
         }
        }
        if(temp == null)
        {
          return false;
        }
        int count = temp.getNumChildren();
        if(count == 0)
        {
         if(temp.getData().compareTo(dad.getData()) > 0)
         {
          dad.setRight(null);
         }
         else
         {
          dad.setLeft(null);   
         }
        }
        else if(count == 1)
        {
         if(dad.getRight().equals(temp))
         {
          dad.setLeft(temp.getRight());   
         }
         else
         {
          dad.setRight(temp.getRight());   
         }
         if(dad.getLeft().equals(temp))
         {
          dad.setLeft(temp.getLeft());   
         }
         else
         {
          dad.setLeft(temp.getLeft());   
         }
        }
        else
        {
         BNode<E> x = combine(temp.getLeft(), temp.getRight());
         if(root == temp)
         {
             dad = removeSmallestChild(temp.getRight());
         }
         else
         {
             if(dad.getLeft() == temp)
             {
              dad.setLeft(x);   
             }
             else
             {
              dad.setRight(x);   
             }
         }
         return true;
        }
        return false;
    }
    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {
        if(node.hasLeftChild()==false)
        {
         return node;
        }
        if(node.hasLeftChild())
        {
         BNode<E> ret = removeSmallestChild(node.getLeft());
         if(ret.equals(node.getLeft()))
         {
          ret.setRight(node);   
         }
         return node;
        }
        return node;
    }

    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        BNode<E> c = removeSmallestChild(right);
        if(c == right)
        {
         right = right.getRight();
        }
        c.setLeft(left);
        c.setRight(right);
        return c; 
    }

    ///////////////////
    //	Helper Class //
    ///////////////////
    class BNode<E extends Comparable>
    {
        private E data;
        private BNode<E> left, right;

        public BNode(E data)
        {this.data = data;}

        public E getData()
        {return data;}

        public BNode<E> getLeft()
        {return left;}

        public BNode<E> getRight()
        {return right;}

        public void setLeft(BNode<E> left)
        {this.left = left;}

        public void setRight(BNode<E> right)
        {this.right = right;}

        public boolean hasLeftChild()
        {return null != left;}

        public boolean hasRightChild()
        {return null != right;}

        public boolean hasChildren()
        {return getNumChildren() > 0;}

        public int getNumChildren()
        {
            int ret = 0;
            if(hasLeftChild())  ret++;
            if(hasRightChild()) ret++;
            return ret;
        }
    }
}