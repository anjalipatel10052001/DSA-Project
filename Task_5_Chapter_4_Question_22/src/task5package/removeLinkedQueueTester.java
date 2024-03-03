package task5package;
/*

Assignment: Task 5 Chapter 4 Question 22 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Program Objective: This test driver is designed to test
the efficiency of the remove method in the LinkedQueue class.

*/

// This is the class and method that will hold the
// test driver.

public class removeLinkedQueueTester {

    public static void main (String[] args) {

        // This is the sentence variable that will
        // hold the string.

        String sentence = "";

        // This is the creation of a tester
        // Linked Queue.

        QueueInterface<String> removeTester =
                new LinkedQueue<String>();

        // These are enqueue statements to help
        // test the remove() method.

        removeTester.enqueue("Hello. Hey.");

        removeTester.enqueue("My");

        removeTester.enqueue("name");

        removeTester.enqueue("is");

        removeTester.enqueue("MaShayla.");

        removeTester.enqueue("I");

        removeTester.enqueue("like");

        removeTester.enqueue("programming.");

        // This is a toString() method the provides
        // a "before" snapshot of the queue as a string.

       sentence = removeTester.toString();

       System.out.println(sentence);

        // This is the remove method statement.

        removeTester.remove(5);

        // This a toString() method that provides
        // an "after" snapshot of the queue as a string.

        sentence = removeTester.toString();

        System.out.println(sentence);

    }
}
