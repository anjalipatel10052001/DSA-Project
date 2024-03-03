package task6package;

public class ArrayCollection<T> implements CollectionInterface<T>
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // array to hold collection’s elements
  protected int numElements = 0;    // number of elements in this collection

  // set by find method
  protected boolean found;  // true if target found, otherwise false
  protected int location;   // indicates location of target if found

  public ArrayCollection()
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayCollection(int capacity)
  {
    elements = (T[]) new Object[capacity];
  }

  //Reference from my program for ch5 question 30
  //Source citation from ChatGPT for creating the StringBuilder to build the string and array representation

  public String toString() {  //Question 8 part (a)
    // Creating a StringBuilder to build the string representation
    StringBuilder sb = new StringBuilder();
    sb.append("[");  // Opening bracket for array representation

    // Iterating through the elements in the array
    for (int i = 0; i < numElements; i++) {
      // Adding a comma and space for elements after the first one element
      if (i > 0) {
        sb.append(", ");
      }
      // Appending the string representation of the current element
      sb.append(elements[i].toString());
    }

    sb.append("]");  // Closing bracket for array representation
    return sb.toString();  // Converting StringBuilder to a String and returning it
  }

  public int count(T target) {  //part (b)
    int count = 0;  // Initializing a counter for occurrences of the target element
    // Iterating through the elements in the array
    for (int i = 0; i < numElements; i++) {
      // Checking if the current element equals the target element
      if (elements[i].equals(target)) {
        // Incrementing the count if a match is found
        count++;
      }
    }

    return count;  // Returning the total count of occurrences
  }

  public void removeAll(T target) {  //part (c)
    int writeIndex = 0;  // Initializing an index for writing non-target elements
    // Iterating through the elements in the array
    for (int readIndex = 0; readIndex < numElements; readIndex++) {
      // Checking if the current element equals the target element
      if (elements[readIndex].equals(target)) {
        // Skipping this element
      } else {
        // Copying non-target elements to the new array
        elements[writeIndex] = elements[readIndex];
        // Moving the writeIndex to the next position
        writeIndex++;
      }
    }

    numElements = writeIndex;  // Updating the total number of elements after removal
  }

  protected void find(T target)
  // Searches elements for an occurrence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true and location to the array index of e. If
  // not successful, sets found to false.
  {
    location = 0;
    found = false;

    while (location < numElements)
    {
      if (elements[location].equals(target))
      {
        found = true;
        return;
      }
      else
        location++;
    }
  }

  public boolean add(T element)
  // Attempts to add element to this collection.
  // Returns true if successful, false otherwise.
  {
    if (isFull())
      return false;
    else
    {
      elements[numElements] = element;
      numElements++;
      return true;
    }
  }

  public boolean remove (T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found)
    {
      elements[location] = elements[numElements - 1];
      elements[numElements - 1] = null;
      numElements--;
    }
    return found;
  }

  public boolean contains (T target)
  // Returns true if this collection contains an element e such that
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);
    if (found)
      return elements[location];
    else
      return null;
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return (numElements == elements.length);
  }

  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);
  }

  public int size()
  // Returns the number of elements in this collection.
  {
    return numElements;
  }
}
