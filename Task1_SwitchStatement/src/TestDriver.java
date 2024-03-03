

/*

Task 1 Test Driver MaShayla Kendrick and Anjali Patel Final Project Data Structures

Authors of this Project: Anjali Patel and MaShayla Kendrick

Program Objective: This program allows the user to choose among different
classes to interact with.


Answer for Task 9:

    Task 9: MAPS
    Question 20: In the nine-digit city code example suppose the hash function used is [(A × C) + B].
What is the hash code for each of the following cities?

    Taking A for the first four digits, B for next two digits, and C for last three digits in the city code
    found the following hash code:

    a. Hangzhou, Zhejiang, China: 001112038
        Ans: (0011 x 038) + 12 = 430
    b. Lancaster, Pennsylvania, USA: 012113103
        Ans: (0121 x 103) + 13 = 12476
    c. Yiyang, Hunan, China: 321732038
        Ans: (3217 x 038) + 32 = 122278
    d. Beaver Falls, Pennsylvania, USA: 54213103 //This city code doesn't have 9 digits so bear with our calculation.
        Ans: (5421 x 03) + 31 = 16294
    e. Seoul, Seoul, South Korea: 010313121
        Ans: (0103 x 121) + 13 = 12476
 */

// This is to use the scanner object.

import java.util.Scanner;

// These are import statements for the classes.

import task3package.EditString;
import task4package.PalindromeChecker;
import task5package.LinkedQueue;
import task6package.*;
import task7package.PrintList;
import task8package.*;


// This is the test driver class and main method that the user interacts with.

public class TestDriver {


    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);


        // This is the data type the user wants for the LinkedQueue task5Activator.

        String task5Datatype;

        // This is an integer that will decide which task 5 method is chosen.

        int task5Choice;

        // This is the size of the queue.

        int task5QueueSize;

        // This is the data type the user wants for the LinkedQueue task5Activator.

        String task6Datatype;

        // This is the number of elements in the task 6 array collection.

        int task6ArraySize;

        // This is an integer that will decide which task 6 method is chosen.

        int task6Choice;

        System.out.println("This is a program that will test the task scenarios.");

        // This gives the user the option of choosing a task scenario.

        System.out.print("Please type 3 to edit a string stack,\n" +
                "type 4 to interact with the recursive or iterative palindrome checker,\n" +
                "type 5 to choose different LinkedQueue methods,\n" +
                "type 6 to choose different ArrayCollection methods,\n" +
                "type 7 to print a user-defined list, and\n" +
                "type 8 to use a recursive method for the Binary Search Tree. > ");

        // This receives user input.

        int taskNum = scnr.nextInt();

        System.out.println();

        // This is the switch/case section that determines reactions to the previous input.

        switch (taskNum) {

            // If the user chooses task 3, an object is created to activate the class.

            case 3:

                // The following statements create an instance of the class and then
                // activates a method(s).

                EditString task3Activator = new EditString();

                task3Activator.changeString();

                break;

            // If the user chooses task 4, an object is created to activate the class.

            case 4:

                // The following statements create an instance of the class and then
                // activates a method(s).

                PalindromeChecker task4Activator = new PalindromeChecker();

                task4Activator.palindromeChecker();

                break;

            // If the user chooses task 5, an object is created to activate the class.

            case 5:

                // The following statements create an instance of the class and then
                // activates a method after a user types their string and
                // chooses a method. The user can choose a data type.

                System.out.print("Choose which data type you want the LinkedQueue class to be.\n" +
                        "Type 'String' or 'Integer'. >  ");


                task5Datatype = scnr.next();

                System.out.println();

                System.out.print("Enter the size of your queue. > ");

                task5QueueSize = scnr.nextInt();

                scnr.nextLine();

                System.out.println();

                if (task5Datatype.equals("String")) {

                    LinkedQueue<String> task5Activator = new LinkedQueue<>();

                    for (int i = 0; i < task5QueueSize; i++) {

                        System.out.print("Enter every string of your queue. Type a word and then press Enter for " +
                                "each of your inputs. > ");

                        String word = scnr.next();

                        task5Activator.enqueue(word);

                        System.out.println();

                    }

                    System.out.print("Enter your method number choice:\n" +
                            "1. toString()\n" +
                            "2. remove()\n" +
                            "3. swapStart()\n" +
                            "4. swapEnds() > ");

                    task5Choice = scnr.nextInt();

                    scnr.nextLine();

                    if (task5Choice == 1) {

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else if (task5Choice == 2) {

                        int count;

                        System.out.print("How many elements do you want to remove? > ");

                        count = scnr.nextInt();

                        scnr.nextLine();

                        task5Activator.remove(count);

                        System.out.println();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else if (task5Choice == 3) {

                        task5Activator.swapStart();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else {

                        task5Activator.swapEnds();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }


                }

                else {

                    LinkedQueue<Integer> task5Activator = new LinkedQueue<>();

                    for (int i = 0; i < task5QueueSize; i++) {

                        System.out.print("Enter every integer of your queue. Type a number and then press Enter for " +
                                "each of your inputs. > ");

                        Integer number = scnr.nextInt();

                        scnr.nextLine();

                        task5Activator.enqueue(number);

                        System.out.println();

                    }

                    System.out.print("Enter your method number choice:\n" +
                            "1. toString()\n" +
                            "2. remove()\n" +
                            "3. swapStart()\n" +
                            "4. swapEnds() > ");

                    task5Choice = scnr.nextInt();

                    scnr.nextLine();

                    System.out.println();

                    if (task5Choice == 1) {

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else if (task5Choice == 2) {

                        int count;

                        System.out.print("How many elements do you want to remove? > ");

                        count = scnr.nextInt();

                        scnr.nextLine();

                        task5Activator.remove(count);

                        System.out.println();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else if (task5Choice == 3) {

                        task5Activator.swapStart();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                    else {

                        task5Activator.swapEnds();

                        String queueString = task5Activator.toString();

                        System.out.println(queueString);

                    }

                }



                break;

            case 6:

                // This test driver is from ChatGPT.
                // This tests the task scenario if the user choose task 6.
                // The following statements create an instance of the class and then
                // activates a method after a user types their string and
                // chooses a method. The user can choose a data type.

                System.out.print("Choose which data type you want the LinkedQueue class to be.\n" +
                        "Type 'String' or 'Integer'. >  ");


                task6Datatype = scnr.next();

                System.out.println();

                System.out.print("How many elements are in your array collection? > ");

                task6ArraySize = scnr.nextInt();

                scnr.nextLine();

                System.out.println();


                if (task6Datatype.equals("String")) {

                    ArrayCollection<String> task6Activator = new ArrayCollection<>();

                    for (int i = 0; i < task6ArraySize; i++) {

                        System.out.print("Enter a string to add into the array collection.\n" +
                                "Press Enter after you type every word. > ");

                        task6Activator.add(scnr.next());

                        System.out.println();

                    }

                    System.out.print("Which method do you want to choose? Type a number choice:\n" +
                            "1. toString()\n" +
                            "2. count()\n" +
                            "3. removeAll() > ");

                    task6Choice = scnr.nextInt();

                    scnr.nextLine();

                    if (task6Choice == 1) {

                        String task6String = task6Activator.toString();

                        System.out.println();

                        System.out.println("The array consists of: " + task6String);

                    }

                    else if (task6Choice == 2) {

                        String whatToCount;

                        System.out.print("What element do you want to count in the array collection? > ");

                        whatToCount = scnr.next();

                        System.out.println();

                        System.out.println("There are " + task6Activator.count(whatToCount) + " " + whatToCount +
                                "(s).");


                    }

                    else {

                        String whatToRemove;

                        System.out.print("What element do you want to remove in the array collection? > ");

                        whatToRemove = scnr.next();

                        task6Activator.removeAll(whatToRemove);

                        System.out.println();

                        String task6String = task6Activator.toString();

                        System.out.println("The array consists of: " + task6String);


                    }

                }

                else {

                    ArrayCollection<Integer> task6Activator = new ArrayCollection<>();

                    for (int i = 0; i < task6ArraySize; i++) {

                        System.out.print("Enter an integer to add into the array collection.\n" +
                                "Press Enter after you type every number. > ");

                        task6Activator.add(scnr.nextInt());

                        System.out.println();

                    }

                    System.out.print("Which method do you want to choose? Type a number choice:\n" +
                            "1. toString()\n" +
                            "2. count()\n" +
                            "3. removeAll() > ");

                    task6Choice = scnr.nextInt();

                    scnr.nextLine();

                    if (task6Choice == 1) {

                        String task6String = task6Activator.toString();

                        System.out.println();

                        System.out.println("The array consists of: " + task6String);

                    }

                    else if (task6Choice == 2) {

                        Integer whatToCount;

                        System.out.print("What element do you want to count in the array collection? > ");

                        whatToCount = scnr.nextInt();

                        System.out.println();

                        System.out.println("There is/are " + task6Activator.count(whatToCount) + " instance(s) of " +
                                        whatToCount + " in the array collection.");


                    }

                    else {

                        Integer whatToRemove;

                        System.out.print("What element do you want to remove in the array collection? > ");

                        whatToRemove = scnr.nextInt();

                        task6Activator.removeAll(whatToRemove);

                        System.out.println();

                        String task6String = task6Activator.toString();

                        System.out.println("The array consists of: " + task6String);


                    }


                }

                break;

                // This activates if the user choose task 7.

            case 7:

                // This creates the task7Activator.

                PrintList task7Activator = new PrintList();

                // This prints the list.

                task7Activator.printList();

                break;

                // This activates if the user chooses the Binary Search Tree option.

            case 8:

                System.out.print("Choose which data type you want the BinarySearchTree class to be.\n" +
                        "Type 'String' or 'Integer'. >  ");

                String dataType = scnr.next();

                if (dataType.equals("String")) {

                    BinarySearchTree<String> bst = new BinarySearchTree<>();

                    System.out.println();

                    System.out.print("How many elements are in your BST? > ");

                    int bstSize = scnr.nextInt();

                    System.out.println();

                    for (int i = 0; i < bstSize; i++) {

                        System.out.print("Enter a string to add into the BST.\n" +
                                "Press Enter after you type every word. > ");

                        bst.add(scnr.next());

                        System.out.println();
                    }

                    // Test min and min2

                    System.out.println("Using min the minimum element is: " + bst.min()); // Should print the minimum element

                    System.out.println("Using min2 the minimum element is: " + ((BinarySearchTree<?>) bst).min2()); // Should also print the minimum element

                } else {

                    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

                    System.out.println();

                    System.out.print("How many elements are in your BST? > ");

                    int bstSize = scnr.nextInt();

                    for (int i = 0; i < bstSize; i++) {

                        System.out.print("Enter an integer to add into the BST.\n" +
                                "Press Enter after you type every number. > ");

                        bst.add(scnr.nextInt());

                        System.out.println();
                    }

                    // Test min and min2

                    System.out.println("Using min the minimum element is: " + bst.min()); // Should print the minimum element

                    System.out.println("Using min2 the minimum element is: " + ((BinarySearchTree<?>) bst).min2()); // Should also print the minimum element
                }

                break;

        }
    }
    }
