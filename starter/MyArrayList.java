/**
 * TODO: Add your file header
 * Name: Morales, Kyle
 * ID: a16162998
 * Email: kmmorale@ucsd.edu
 * Sources used: Zybooks, 
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

 /**
 * TODO: Add your implementation of MyArrayList here
 */

 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid elements in the array
public class MyArrayList implements MyList {
 Object[] data;
 int size;
 static final int DEFAULT_CAPACITY = 5;
 
 public MyArrayList() {
  this.data = new Object[5];
 }
 
 public MyArrayList(int initialCapacity) throws IllegalArgumentException {
   this.data = new Object[initialCapacity];
 }
 
 public MyArrayList (E[] arr) {
  this.data = arr;
  this.size = 0;
  for(int i = 0; i < data.length; i++) {
   if(data[i] != null) {
    this.size++;
   }
  } 
 }
 
 public void expandCapacity(int requiredCapacity) throws IllegalArgumentException {
 }
 public int getCapacity() {
 }
 public void insert(int index, E element) throws OutOfBoundsException {
 }
 public void append(E element) {
 }
 public void prepend(E element) {
 }
 public E get(int index) throws OutOfBoundsException {
 }
 public E set(int index, E element) throws OutOfBoundsException {
 } 
 public E remove(int index) throws OutOfBoundsException{
 }
 public int size() {
 }
 
 
 
}