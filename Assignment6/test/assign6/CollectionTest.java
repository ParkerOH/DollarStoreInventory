package assign6;


import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 * @author klk2
 * @author pko4
 */
public class CollectionTest {

    Collection c;
    Resource r1, r2, r3, r4;

    @Before
    public void setUp() throws Exception {
        
        r1 = new Movie(7865, "title", "000000");
        r2 = new Movie(7865, "title2", "000000"); 
        r3 = new Book(3434, "title", "isbn", "author"); 
        r4 = new Book(3434, "title2", "isbn2", "author2");
        
        c = new Collection();
    }

    @After
    public void tearDown() throws Exception {
        
        c.removeResource(7865);
        c.removeResource(3434);
        
    }
    
    /**
     * Test of addResource method, of class Collection.
     */
    @Test
    public void testAddResource() {
              
        assertEquals("should return true", true, c.addResource(r1));
        assertEquals("should return false", false, c.addResource(r2));
        assertEquals("should return true", true, c.addResource(r3));
        assertEquals("should return false", false, c.addResource(r4));
    }
}
