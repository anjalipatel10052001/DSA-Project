package task5package;
/*

Assignment: Task 5 Chapter 4 Question 22 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Program Objective: This is a test driver that tests the
efficiency of the toString() method of the LinkedQueue class.

*/


// This is the class that will carry the test driver.

public class toStringLinkedQueueTester {

    // This is the main method test driver.

    public static void main (String [] args) {

        // This is the creation of a tester
        // Linked Queue.

        LinkedQueue<String> stringTester =

                new LinkedQueue<String>();

        String sentence = "";

        // These are enqueue statements to help
        // test the toString() method.

        stringTester.enqueue("Hello. Hey.");

        stringTester.enqueue("My");

        stringTester.enqueue("name");

        stringTester.enqueue("is");

        stringTester.enqueue("MaShayla.");

        stringTester.enqueue("I");

        stringTester.enqueue("like");

        stringTester.enqueue("programming.");

        // This is the first test of the toString()
        // method.

      sentence = stringTester.toString();

      System.out.println(sentence);

       // This removes the front node containing
       // the information "Hello. Hey."

       stringTester.dequeue();

       // This is the second test of the toString()
       // method to see if anything has changed.

        sentence = stringTester.toString();


        System.out.println(sentence);





    }
}