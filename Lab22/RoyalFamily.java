import java.util.Scanner;
import java.io.File;

public class RoyalFamily
{
    public static void main(String[] args)
    {
        //Define a variable to store the root node
        TNode<String> root = null;
        try
        {

            //TODO: SETUP TREE DATA
            //1. Use Scanner to read the data.txt file
            //2. The first line in data.txt is the root node
            //3. For each line in data.txt in the format A > B
            //		- *find* the A node
            //		- add B as a child of A
            String data = "";
            File fk = new File("data.txt");
            Scanner scam = new Scanner(fk);
            root = new TNode<String>(scam.nextLine());
            while(scam.hasNextLine())
            {
                String[] lock = scam.nextLine().split(" > ");
                TNode<String> nile = find(root, lock[0]);
                nile.addChild(new TNode<String>(lock[1]));
            }
            //TODO: test printPath method

        }
        catch(Exception x)
        {
            x.printStackTrace();
        }
        TNode<String> child = find(root, "Princess Beatrice of York");
        String path = getPath( child );
        System.out.println(path);
    }

    /**
     *	@return node if its data matches name, or return a child node with data that matches name
     */
    public static TNode<String> find(TNode<String> node, String name)
    {
        //use recursion to check this node and all of its children to see if their data matches the specified name
        if(name.equals(node.getData()))
        {
         return node;
        }
        else
        {
          for(TNode<String> found : node.getChildren())
          {
            TNode<String> need = find(found, name);
            if(need != null)
            {
                return need; 
            }  
          }
        }
        return null;
    }

    /**
     *	@return a String containing the path from the root node to the specified node, separeated by ->
     */
    public static String getPath(TNode<String> node)
    {
        //use recursion to concatenate the getPath of this node's parent with this node's data
        String s = node.getData();
        while(node.getParent() != null)
        {
            node = node.getParent();
            s = node.getData() + " -> " + s;
        }
        return s;
    }
}