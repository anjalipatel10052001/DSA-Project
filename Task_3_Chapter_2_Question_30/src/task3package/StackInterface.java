package task3package;

public interface StackInterface<T> {
    void push(T element) throws StackOverflowException;
    // Throws main.java.Task3_Directory.Task3_Package.task3package.StackOverflowException if this stack is full.
    // otherwise places element at the top of this stack.

    void pop() throws StackUnderflowException;
    // Throws main.java.Task3_Directory.Task3_Package.task3package.StackUnderflowException if this stack is empty.
    // otherwise removes top element from this stack.

    T top() throws StackUnderflowException;
    // Throws main.java.Task3_Directory.Task3_Package.task3package.StackUnderflowException if this stack is empty.
    // otherwise returns top element of this stack.

    boolean isFull();
    // Returns true if this stack is full, otherwise returns false.

    boolean isEmpty();
    // Returns true if this stack is empty, otherwise returns false.


    int size();
    // Returns the size of the stack.



}
