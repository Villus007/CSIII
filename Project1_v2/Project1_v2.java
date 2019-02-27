import junit.framework.*; 
import java.util.*;

public class Project1_v2 extends TestCase
{

    public void testIsEmpty()
    {
        JavaLinkedList list = new JavaLinkedList();
        assertEquals("new list sums to zero", 0.0, list.getSum());        
    }

    public void testOne()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{11, 15, 15, 26, 27});
        assertEquals("list sums to 94.0", 94.0, list.getSum());
        assertEquals("mean is 18.8", 18.8, list.getMean());
        assertEquals("median is 15.0", 15.0, list.getMedian());
        assertEquals("mode is 15", 15, list.getMode());      
    }

    public void testTwo()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{1, 5, 5, 5, 6, 8, 9, 11, 13});
        assertEquals("list sums to 63.0", 63.0, list.getSum());
        assertEquals("mean is 7.0", 7.0, list.getMean());
        assertEquals("median is 6.0", 6.0, list.getMedian());
        assertEquals("mode is 5", 5, list.getMode());         
    }

    public void testThree()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{1, 1, 1, 3, 4, 5, 6, 7, 8, 9, 10});
        assertEquals("list sums to 55.0", 55.0, list.getSum());
        assertEquals("mean is 5.0", 5.0, list.getMean());
        assertEquals("median is 5.0", 5.0, list.getMedian());
        assertEquals("mode is 1", 1, list.getMode());      
    }
    
    public void testFour()
    {
        JavaLinkedList list = new JavaLinkedList();
        list = new JavaLinkedList(new int[]{0, 0, 1, 7, 8, 9, 10});
        assertEquals("list sums to 35.0", 35.0, list.getSum());
        assertEquals("mean is 5.0", 5.0, list.getMean());
        assertEquals("median is 7.0", 7.0, list.getMedian());
        assertEquals("mode is 0", 0, list.getMode());      
    }
}
