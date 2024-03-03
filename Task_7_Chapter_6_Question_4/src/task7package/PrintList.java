package task7package;
/*

Task 7 Chapter 6 Question 4 of Final Project Data Structures

Author of the project: MaShayla Kendrick

Program Objective: This program prints elements of a list using a
list iterator, a while loop, and list and iterator operations.
I used ChatGPT with this program.

*/


// This is an import statement for the user to enter
// inputs.


import java.util.Scanner;

// This is an import statement to be able to use the ArrayList.
// ArrayLists are lists that implement the ListInterface and use
// list operations.

import java.util.ArrayList;

// This is an import statement to use the Iterator tool.

import java.util.Iterator;

// This is the main method/test driver that will ask the user
// for inputs to print the list of strings.

public class PrintList {

    public void printList () {

        // This is the initiation and definition
        // of the scanner object.

        Scanner scnr = new Scanner(System.in);

        // This asks the user for inputs.

        System.out.print("Enter a line of text: ");

        String inputLine = scnr.nextLine();

        // Split the input line into words and store them in an ArrayList.

        ArrayList<String> strings = new ArrayList<>();

        int startIndex = 0;

        int endIndex = inputLine.indexOf(' ');

        while (endIndex != -1) {

            String word = inputLine.substring(startIndex, endIndex);

            strings.add(word);

            startIndex = endIndex + 1;

            endIndex = inputLine.indexOf(' ', startIndex);

        }

        // Add the last word (or the only word if there are no spaces).

        if (startIndex < inputLine.length()) {

            String lastWord = inputLine.substring(startIndex);

            strings.add(lastWord);

        }

        // Create an iterator to iterate through the list.

        Iterator<String> iterator = strings.iterator();

        // Use a while loop to print each word using the iterator.

        while (iterator.hasNext()) {

            String word = iterator.next();

            System.out.println(word);

        }
    }
}
