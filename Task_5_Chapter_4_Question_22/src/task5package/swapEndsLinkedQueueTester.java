package task5package;
/*

Assignment: Task 5 Chapter 4 Question 22 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Program Objective: This tests the efficiency of the
swapEnds method in the LinkedQueue class.

*/


// This is the class that holds the test driver.

public class swapEndsLinkedQueueTester {



    // This is the method that holds the test driver.

    public static void main (String [] args) {

        // This is a sentence variable.

        String sentence = "";

        // This is the creation of a tester
        // Linked Queue.

        QueueInterface<String> swapEndsTester =
                new LinkedQueue<String>();

        // These are enqueue statements to help
        // test the swapEnds() method.

        swapEndsTester.enqueue("Jam ");

        swapEndsTester.enqueue("Cheese ");

        swapEndsTester.enqueue("Pepperoni ");

        swapEndsTester.enqueue("Ritz crackers ");


        // This provides a "before" snapshot of the
        // queue.

        sentence = swapEndsTester.toString();

        System.out.println(sentence);

        // This is the method call.

        swapEndsTester.swapEnds();

        // This provides an "after" snapshot of the
        // queue.

        sentence = swapEndsTester.toString();

        System.out.println(sentence);
    }

}
