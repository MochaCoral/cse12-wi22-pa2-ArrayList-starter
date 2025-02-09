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
    static final int EXPANDED_CAPACITY = 7;

    private MyArrayList<Integer> listDefaultCap, listExpanded, listNullArg, listPrependNull;
    private boolean exceptionThrown;


    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        listDefaultCap = new MyArrayList<Integer>(DEFAULT_CAPACITY);
        listExpanded = new MyArrayList<Integer>();
        listPrependNull = new MyArrayList<Integer>();
        exceptionThrown = false;
        for(int i = 0; i < listDefaultCap.getCapacity(); i++) {
            listDefaultCap.append(2);
        }

    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        try {
            MyArrayList<Integer> listInvalidIn = new MyArrayList<Integer>(INVALID_INPUT);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Exception thrown for invalid input", exceptionThrown);
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        listNullArg = new MyArrayList<Integer>(null);
        assertEquals("Null input should return default capacity", 5, listNullArg.getCapacity());
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        listDefaultCap.append(8);
         assertEquals("append should expand arraylist capacity", 10, listExpanded.getCapacity());
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        listPrependNull.prepend(null);
        assertEquals("check list size after prepend", 6, listPrependNull.size());
        assertEquals("check list capacity after prepend", 10,listPrependNull.getCapacity());
        assertEquals("check that first element is null", null, listPrependNull.data[0]);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        try {
            listDefaultCap.insert(EXPANDED_CAPACITY, 420);
        }
        catch (IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Check that out of bounds insertion throws an exception.", exceptionThrown);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i = 0; i < 1000; i++) {
            listDefaultCap.insert(4, 1);
        }
        assertEquals("Check that size reflects insert", 1005, listDefaultCap.size());
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
            exceptionThrown = true;
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
        catch(IndexOutOfBoundsException e){
            exceptionThrown = true;
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
        catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
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
        catch(IllegalArgumentException e) {
            exceptionThrown = true;
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
