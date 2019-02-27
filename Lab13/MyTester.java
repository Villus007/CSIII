import junit.framework.*; 
import java.util.*;
public class MyTester extends TestCase
{
    public void testVillus()
    {
        MyStack<String> s = new MyStack<String>();
        s.push("villus");		
        s.push("dragoon");		
        s.push("lionheart");

        String obj = s.pop();
        assertEquals("pop() should return the last Object added to the Stack", "lionheart", obj);

    }
}