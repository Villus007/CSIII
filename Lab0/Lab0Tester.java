import junit.framework.*; 
import java.util.*;

/**
 * The test class Lab0Tester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Lab0Tester extends TestCase
{
    public void testMod3()
    {
        Lab0 lab = new Lab0();
        String s = lab.checkValue(3);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Poke", s);

        s = lab.checkValue(18);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Poke", s);

        s = lab.checkValue(303);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Poke", s);

    }

    public void testMod5()
    {
        Lab0 lab = new Lab0();
        String s = lab.checkValue(5);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "mon", s);

        s = lab.checkValue(100);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "mon", s);

        s = lab.checkValue(65);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "mon", s);

    }

    public void testMod3And5()
    {
        Lab0 lab = new Lab0();
        String s = lab.checkValue(15);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Pokemon", s);

        s = lab.checkValue(1485);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Pokemon", s);

        s = lab.checkValue(60);

        assertNotNull("Should not be null", s);
        assertEquals("Should return the string Poke", "Pokemon", s);

    }
}
