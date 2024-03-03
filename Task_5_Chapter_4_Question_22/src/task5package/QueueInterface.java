package task5package;

public interface QueueInterface <T>{
    void enqueue(T elemnt) throws QueueOverflowException;

    T dequeue() throws QueueUnderflowException;

    boolean isFull();

    boolean isEmpty();

    int size();

    // This is the remove method in the interface. This will
    // make it be enforced.

    void remove(int count);

    // This is the toString() method in the interface. This will
    // make it be enforced.

    String toString();


    // This is the swapStart method in the interface.
     boolean swapStart();

    // This is the swapEnds method in the interface.

     boolean swapEnds();
}
