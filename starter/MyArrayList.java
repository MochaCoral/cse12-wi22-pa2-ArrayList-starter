/**
 * TODO: Add your file header
 * Name: Morales, Kyle
 * ID: a16162998
 * Email: kmmorale@ucsd.edu
 * Sources used: Zybooks, 
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * MyArrayList is a generic arraylist implementation of the mylist interface, implementing various ArrayList ADTs.
 */

 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid elements in the array
public class MyArrayList<E> implements MyList<E> {
  Object[] data;
  int size;
  static final int DEFAULT_CAPACITY = 5;
 
 public MyArrayList () {
    this.data = new Object[DEFAULT_CAPACITY];
    this.size = 0;
 }
 
 public MyArrayList (int initialCapacity) throws IllegalArgumentException {
    if(initialCapacity > 0) {
      this.data = new Object[initialCapacity];
      this.size = 0;
    }
    else {
      throw new IllegalArgumentException();
    }
 }
 
 public MyArrayList (E[] arr) {
    if(!arr.equals(null)) {
      this.data = arr;
      this.size = arr.length;
    }
    else {
      this.data = new Object[DEFAULT_CAPACITY];
      this.size = 0;
    }
  }
 
 public void expandCapacity(int requiredCapacity) throws IllegalArgumentException {
    Object[] tempData;
    if(this.getCapacity() > 0) {
      if(this.getCapacity() * 2 >= requiredCapacity) {
        tempData = new Object[this.getCapacity() * 2];
      }
      else {
        tempData = new Object[requiredCapacity];
      }
      for(int i = 0; i < this.getCapacity(); i++) {
        tempData[i] = this.data[i];
      }
      this.data = tempData;
    }
    else if(this.getCapacity() == 0){
      this.data = new Object[DEFAULT_CAPACITY];
    }
    else {
      throw new IllegalArgumentException();
    }
 }

 public int getCapacity() {
   return this.data.length;
 }

 public void insert(int index, E element) throws IndexOutOfBoundsException {
    if(index >= 0 && index < this.getCapacity()) {
      if(this.size() >= this.getCapacity()) {
        this.expandCapacity(this.getCapacity() + 1);
      }
      for(int i = this.getCapacity() - 1; i >= index; i--) { //iterating backwards from the end of the array, move each element one index position forward
        this.data[i + 1] = this.data[i]; 
      }
      this.data[index] = element;
    }
    else {
      throw new IndexOutOfBoundsException();
    }
 }

 public void append(E element) {
   if(this.size() >= this.getCapacity()) { //if array list is at capacity
     this.expandCapacity(this.getCapacity() + 1);
   }
   this.data[this.size() + 1] = element;
   this.size++;

 }

 public void prepend(E element) {
    if(this.size() >= this.getCapacity()) {
      this.expandCapacity(this.getCapacity() + 1);
    }
    for(int i = this.getCapacity() - 1; i >= 0; i--) { //move every element forward one index position 
      this.data[i + 1] = this.data[i];
    }
    this.data[0] = element;
    this.size++;
 }

 @SuppressWarnings("Unchecked")
 public E get(int index) throws IndexOutOfBoundsException {
    if(index >= 0 && index < this.getCapacity()) { //if index is within bounds
      return (E) this.data[index];
    }
    else {
      throw new IndexOutOfBoundsException();
    }
 }

 @SuppressWarnings("Unchecked")
 public E set(int index, E element) throws IndexOutOfBoundsException {
    E output;
    if(index >= 0 && index < this.getCapacity()) { //if index is within bounds
      output = (E) this.data[index];
      data[index] = element;
      return output;
   }
   else {
     throw new IndexOutOfBoundsException();
   }
 } 

 @SuppressWarnings("Unchecked")
 public E remove(int index) throws IndexOutOfBoundsException{
   E output;
   if(index >= 0 && index < this.getCapacity()) { //if index is within bounds
     output = (E) this.data[index];
     for(int i = index; i < this.getCapacity() - 1; i++) { //iterating from index, move each element back one index position
       this.data[i] = this.data[i + 1];
     }
     this.size--;
     return output;
   }
   else {
     throw new IndexOutOfBoundsException();
   }
  }

 public int size() {
    return this.size;
 }
}