package task3package;


public class ArrayBoundedStack<T> implements StackInterface<T> {
    protected final int DEFCAP = 100;

    protected T[] elements;
    protected int topIndex = -1;

    public ArrayBoundedStack() {
        elements = (T[]) new Object[DEFCAP];
    }

    public ArrayBoundedStack(int maxSize) {
        elements = (T[]) new Object [maxSize];
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false
    {
        return (topIndex == -1);
    }

    public boolean isFull()
    // Returns true if this stack is full, otherwise returns false.
    {
        return (topIndex == (elements.length - 1));
    }

    public void push(T element)
        // Throws main.java.Task3_Directory.Task3_Package.task3package.StackOverflowException if this stack is full.
        // otherwise places element at the top of this stack.
    {
        if (isFull()) {
            throw new StackOverflowException("Push attempted on a full stack.");
        }

        else {

            topIndex++;
            elements[topIndex] = element;
        }

    }

    public void pop()
        // Throws main.java.Task3_Directory.Task3_Package.task3package.StackUnderflowException if this stack is empty.
        // otherwise removes top element from this stack.

    {
        if (isEmpty()) {
            throw new StackUnderflowException("Pop attempted on empty stack.");
        }

        else
        {
            elements[topIndex] = null;
            topIndex--;
        }


    }

    public T top()
        // Throws main.java.Task3_Directory.Task3_Package.task3package.StackUnderflowException if this stack is empty.
        // otherwise returns top element of this stack.
    {
        T topOfStack = null;

        if (isEmpty()) {
            throw new StackUnderflowException("Top attempted on empty stack");
        }
        else {
            topOfStack = elements[topIndex];
            return topOfStack;
        }
    }

    // I used ChatGPT to provide me with a size method. I cite ChatGPT for this size method.

    public int size() {
        return topIndex + 1;
    }




}
