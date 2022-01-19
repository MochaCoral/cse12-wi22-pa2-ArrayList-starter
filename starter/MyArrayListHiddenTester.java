/**
 * TODO: Add your file header
 * Name: Morales, Kyle
 * ID: A16162998
 * Email: kmmorale@ucsd.edu
 * Sources used: Piazza, Zybooks
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {

    static final int INVALID_INPUT = -1;
    static final int DEFAULT_CAPACITY = 5;

    private MyArrayList listDefaultCap, listInvalidIn, listExpanded;
    private boolean exceptionThrown;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        listDefaultCap = new MyArrayList(DEFAULT_CAPACITY);
        listInvalidIn = new MyArrayList(INVALID_INPUT);
        listExpanded = new MyArrayList()
        exceptionThrown = false
        
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        assertEquals("Invalid input should return null", IllegalArgumentException, listInvalidIn);
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        assertEquals("Null input should return default capacity", listDefaultCap, null);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        assertEquals("append should expand arraylist capacity", , )
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
       
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 0; i < 1000; i++) {
            listDefaultCap.insert(i, 1);
        }
        assertEquals("Check that size reflects insert", 1000, listDefaultCap.size);
        assertEquals("Check that capacity reflects insert", 1280, listDefaultCap.getCapacity());
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        try {
            listDefaultCap.get(10);
        }
        catch(IndexOutOfBoundsException B){
            exceptionThrown = True;
        }
        assertTrue("Check that an out of bounds exception is thrown (get)", exceptionThrown);
        
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        try {
            listDefaultCap.set(10, 69);
        }
        catch(IndexOutOfBoundsException B){
            exceptionThrown = True;
        }
        assertTrue("Check that an out of bounds exception is thrown (set)", exceptionThrown); 
        
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        try {
            listDefaultCap.remove(10);
        }
        catch(indexOutOfBoundsException B) {
            exceptionThrown = True;
        }
        assertTrue("Check that an out of bounds exception is thrown (remove)", exceptionThrown);
        
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        try {
            listDefaultCap.expandCapacity(4);
        }
        catch(IllegalArgumentException) {
            exceptionThrown = True;
        }
        assertTrue("Check that an illegal argument exception is thrown (expandCapacity)", exceptionThrown);
       
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        listDefaultCap.expandCapacity(1080);
        assertEquals("Check that capacity is set to requiredCapacity", 1080, listDefaultCap.getCapacity());
    }

}
