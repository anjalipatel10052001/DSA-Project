package task5package;
/*

Assignment: Task 5 Chapter 4 Question 22 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Program Objective: This program is used to test the
efficiency of the swapStart method in the LinkedQueue
class.

*/

// This is the class that will hold the test driver

public class swapStartLinkedQueueTester {

    // This is the method that will hold the test driver.

    public static void main(String [] args) {

        // This is the sentence variable to hold the string.

        String sentence = "";

        // This is the creation of a tester
        // Linked Queue.

        QueueInterface<String> swapStartTester =
                new LinkedQueue<String>();

        // These are enqueue statements to help
        // test the swapStart() method.

        swapStartTester.enqueue("Hello.");

        swapStartTester.enqueue("Hey. Hey.");

        swapStartTester.enqueue("My");

        swapStartTester.enqueue("name");

        swapStartTester.enqueue("is");

        swapStartTester.enqueue("MaShayla.");

        swapStartTester.enqueue("I");

        swapStartTester.enqueue("like");

        swapStartTester.enqueue("programming.");

        // This provides a "before" snapshot of the
        // queue.

        sentence = swapStartTester.toString();

        System.out.println(sentence);

        // This is the method call.

        swapStartTester.swapStart();

        // This provides an "after" snapshot of the
        // queue.

        sentence = swapStartTester.toString();

        System.out.println(sentence);

    }

}
