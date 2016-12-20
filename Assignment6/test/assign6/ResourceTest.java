package assign6;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author klk2
 * @author pko4
 */
public class ResourceTest {
    
    Resource movie, book;
    Member student, faculty;
    Calendar date, expResult;
    
    public ResourceTest() {
    }

    /**
     *
     */
    @Before
    public void setUp(){
        student = new Student(5566);
        faculty = new Faculty(6655);
      
        movie = new Movie(7865, "title", "000000");
        book = new Book(3434, "title", "isbn", "author");
      
        date = Calendar.getInstance();
    }

    /*/**
     * Test of calculateNewDueDate method, of class Resource.
     */
    @Test
    public void testCalculateNewDueDate() {
      
        expResult = Calendar.getInstance();
        expResult.add(Calendar.DATE, 7);
        assertEquals("The movie due date should be 7 days from now", 
                expResult, movie.calculateNewDueDate(date, student));
      
        expResult = Calendar.getInstance();
        expResult.add(Calendar.DATE, 28);
        assertEquals("The student book due date should be 28 days from now",
                expResult, book.calculateNewDueDate(date, student));

        expResult = Calendar.getInstance();
        expResult.add(Calendar.MONTH, 3);
        assertEquals("The faculty book due date should be 3 months from now",
                expResult, book.calculateNewDueDate(date, faculty));
    }
    
    /**
     * Test of calculateFine method, of class Resource.
     */
    @Test
    public void testCalculateFine() {
        Calendar maxMovieFineDD = movie.calculateNewDueDate(date, student);
        movie.setDueDate(maxMovieFineDD);
        maxMovieFineDD.add(Calendar.DATE, 20);
        assertEquals("The fine should be $5 for the movie title",
                5, movie.calculateFine(maxMovieFineDD), .01);
      
      
        Calendar minMovieFineDD = movie.calculateNewDueDate(date, faculty);
        movie.setDueDate(minMovieFineDD);
        minMovieFineDD.add(Calendar.DATE, 1);
        assertEquals("The fine should be $0.25 for the movie title",
                0.25, movie.calculateFine(minMovieFineDD), .01);

      
        Calendar maxSTBookFineDD = book.calculateNewDueDate(date, student);
        book.setDueDate(maxSTBookFineDD);
        maxSTBookFineDD.add(Calendar.DATE, 20);
        assertEquals("The fine should be $5 for the book title",
                5, book.calculateFine(maxSTBookFineDD), .01);
      
      
        Calendar minSTBookFineDD = book.calculateNewDueDate(date, student);
        book.setDueDate(minSTBookFineDD);
        minSTBookFineDD.add(Calendar.DATE, 1);
        assertEquals("The fine should be $0.25 for the book title",
                0.25,book.calculateFine(minSTBookFineDD) , .01);
      
      
        Calendar maxFABookFineDD = book.calculateNewDueDate(date, faculty);
        book.setDueDate(maxFABookFineDD);
        maxFABookFineDD.add(Calendar.DATE, 20);
        assertEquals("The fine should be $5 for the book title",
                5, book.calculateFine(maxFABookFineDD), .01);
      
      
        
        Calendar minFABookFineDD = book.calculateNewDueDate(date, faculty); 
        book.setDueDate(minFABookFineDD);
        minFABookFineDD.add(Calendar.DATE, 1);
        assertEquals("The fine should be $0.25 for the book title",
                .25, book.calculateFine(minFABookFineDD) , .01);
    }
}