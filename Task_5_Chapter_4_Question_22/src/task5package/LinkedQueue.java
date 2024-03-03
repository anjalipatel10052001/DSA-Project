package task5package;//---------------------------------------------------------------------------
// task5package.LinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
//---------------------------------------------------------------------------

/*

Assignment: Task 5 Chapter 4 Question 22 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Project Objective: This program adds new methods to the LinkedQueue class.
The methods are toString(), remove(int count), swapStart(), and swapEnds().

*/



public class LinkedQueue<T> implements QueueInterface<T>
{
  protected LLNode<T> front;     // reference to the front of this queue
  protected LLNode<T> rear;      // reference to the rear of this queue
  protected int numElements = 0; // number of elements in this queue

  public LinkedQueue()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
    numElements++;
  }

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;
      numElements--;
      return element;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {
    return (front == null);
  }

  public boolean isFull()
  // Returns false - a linked queue is never full.
  {
    return false;
  }

  public int size()
  // Returns the number of elements in this queue.
  {
    return numElements;
  }




  // This is the toString() method.


  public String toString() {

    // This is the queueString variable, which holds
    // the string version of values in the queue.

    String queueString = "";

    // These are variables that hold copies of the
    // queue's attribute values without actually
    // affecting the queue. This block has
    // elements inspired by ChatGPT, like the
    // assignment with frontCopy and front.

    int numElementsCopy = numElements;


    LLNode<T> frontCopy = front;


    // If a queue is empty, then the method returns
    // an empty queueString.

    if (numElementsCopy == 0) {

      return queueString;

    }

    // If the queue is not empty, the queue values
    // are made into strings by a while loop.

    else {

      // This is the while loop beginning. 

      while (numElementsCopy != 0 && frontCopy != null) {

        // For neatness, a space is added to the
        // queueString. ChatGPT helped me with this.

        queueString += frontCopy.getInfo() + " ";


        // To travel through the queue, information
        // of the next node is put into frontCopy,
        // allowing node travel without affecting
        // the node in the original queue. ChatGPT helped
        // me with this as well.

       frontCopy = frontCopy.getLink();


        // numElementsCopy is decreased to allow
        // an eventual end to the while loop.

        numElementsCopy--;

      }

      // The string is returned.

      return queueString;
    }

  }

  // This is the remove method that removes a certain
  // count of elements from the front.

  public void remove(int count) {

    // This is an if-else statement that can throw
    // an exception if the numElements is less than
    // the count. If not, then the else statement
    // contains statements that remove a certain
    // count of elements from the front.

    if (count > numElements) {

      // A QueueUnderflowException is thrown if the
      // count is more than numElements.

      throw new QueueUnderflowException("There are not " +
              "enough elements to remove from the queue.");
    }

    // If the count is less than or equal to numElements,
    // the proper amount of elements is removed from the
    // queue.

    else {

      // The integer variable i is initialized
      // to provide a travel method for the
      // for loop.

      int i;

      // A for loop is used to remove elements from the
      // front.

      for (i = 0; i < count; i++) {
          front = front.getLink();
      }
    }
  }
  // This is the swapStart method which returns true if the
  // first two elements in the queue are properly swapped.
  // Otherwise, it returns false. 

  public boolean swapStart() {

    // This is an integer variable that
    // determines if the queue contains
    // at least two elements.

    final int minNum = 2;

    // This is an if statement that determines
    // the outcome of the boolean method.

    // If there are less than 2 elements in the queue, it returns
    // false.

    if (numElements < minNum) {
      return false;
    }

    // If there are at least 2 elements in the queue, it
    // proceeds to swap the first and second elements.

    // Create temporary variables to hold the values.
    T frontValue = front.getInfo();
    T secondValue = front.getLink().getInfo();

    // Swap the values of the first and second nodes.
    front.setInfo(secondValue);
    front.getLink().setInfo(frontValue);

    return true; // Swap was successful.

  }

  // This is the swapEnds method which swaps the
  // front and rear values of the queue.

  public boolean swapEnds() {

    // This is an integer variable that
    // determines if the queue contains
    // at least two elements.

    final int minNum = 2;

    // This is an if-else statement that determines
    // the outcome of the boolean method.

    // If there are less than 2 elements in the queue, it returns
    // false.

    if (numElements < minNum) {
      return false;
    }

    // If there are at least 2 elements in the queue, the
    // else statement swaps the front and rear elements
    // of the queue.

    else {

      // This is a variable that carries the info in
      // the front node.

      T frontCarry = front.getInfo();

      // This is a variable that carries the info in
      // the rear node.

      T rearCarry = rear.getInfo();

      // This swaps the info values of the front
      // and rear nodes.

      front.setInfo(rearCarry);

      rear.setInfo(frontCarry);

      // This returns true to indicate that the
      // swap was successful.

      return true;


    }

  }


}

