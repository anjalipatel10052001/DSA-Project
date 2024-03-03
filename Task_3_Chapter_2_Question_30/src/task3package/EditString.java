package task3package;
/*

Assignment: Task 3 Chapter 2 Question 30 of Final Project Data Structures

Author of this Project: MaShayla Kendrick

Project Objective: This program uses an Array Bounded Stack class to prompt
the user for a string and then repeatedly prompts the user for changes until
the user presses X. It uses one letter commands to manipulate information
in the stack.


*/

// This is an import statement to make the scanner available.

import java.util.Scanner;

// This is imported to change a string into an array.

import java.lang.String;

// This is to allow the program to terminate.

import java.lang.System;

// This is the Edit String class, a class for the user
// to interact with. I used ChatGPT to do deep analysis to make
// sure everything is up to standard.

public class EditString {

    // This is the method the user will be interacting with.

    public void changeString() {

        // This is the activation of the scanner.

        Scanner scnr = new Scanner(System.in);

        // This is a variable for the capacity of the stack.
        // This is different from the size. The capacity
        // counts all open slots in the array, regardless
        // if it is filled or not.

        int capacity;

        // This is the stack to be defined.

        ArrayBoundedStack<Character> characterStack;

        // This is the string to edit.

        String stringToEdit;

        // This is a string to determine if the user wants to
        // do commands. ChatGPT recommended to me to put an empty string.

        String continueCommand = "";

        // This is the command choice the user makes.

        String commandChoice;

        // This is the default capacity.

        final int defaultSize = 100;

        // This is a stack that saves previous versions of the characterStack.
        // I got this idea from ChatGPT.

        ArrayBoundedStack<StackInterface<Character>> undoStack;

        // This print statement details the program objective.

        System.out.println("This program receives input from the\n" +
                "user and manipulates its contents\n" +
                "based on user commands.");

        System.out.println();

        // This asks the user what size they want the array stack to be.

        System.out.print("Would you like to enter a string with a size\n" +
                "of 100 or your own custom size choice? Type\n" +
                "'1' for 100 as your size or '2' for your own\n" +
                "custom size. > ");

        // This statement receives the choice of the size.

        int numberChoiceForSize = scnr.nextInt();

        // This newline character consumer was recommended to me
        // by ChatGPT.

        scnr.nextLine();

        System.out.println();

        // These are if-else statements that determine reactions to the previous input.

        if (numberChoiceForSize == 1) {

            // This creates a new Array Bounded Stack with the default capacity.

            capacity = defaultSize;

            characterStack = new ArrayBoundedStack<Character>();

            undoStack = new ArrayBoundedStack<StackInterface<Character>>();

        } else {

            // This prompts the user to type their custom size.

            System.out.print("What will your custom string size be? Consider\n" +
                    "the spaces for contributing to the capacity.  > ");

            // This receives the user's custom size.

            capacity = scnr.nextInt();

            // ChatGPT recommended this to me to catch any leftover
            // newline data.

           scnr.nextLine();

            System.out.println();

            characterStack = new ArrayBoundedStack<Character>(capacity);

            undoStack = new ArrayBoundedStack<StackInterface<Character>>();

        }

        // This prompts the user to enter the string value.

        System.out.print("Please type in your string. > ");

        // This receives the string value.

        stringToEdit = scnr.nextLine();

        System.out.println();

        // This pushes the string value into the characterStack as characters.
        // I used ChatGPT to give me advice on how to change
        // the string into an array. My source for the solution
        // to change the string into an array is ChatGPT. I did not
        // use code from it. I only requested advice or asked questions.

        char[] stringToArray = stringToEdit.toCharArray();

        for (int i = 0; i < stringToArray.length; i++) {


                characterStack.push(stringToArray[i]);

        }

        // This is the undoStack, a stack used for the undo command.
        // ChatGPT helped me with this.

        undoStack.push(deepCopyStack(characterStack));

        // This asks the user if they want to change the stack.

        System.out.print("Do you want to manipulate the stack?\n" +
                "Please type 'Yes' to continue or 'X' to stop. > ");

        continueCommand = scnr.next();

        System.out.println();

        // These are if-else statements to determine reactions to the
        // previous inputs.

        // If the user does not want any changes made, the string will be
        // printed.

        // ChatGPT recommended to me to use this while statement
        // for if the continueCommand equals "Yes".


        if (continueCommand.equals("X")) {

            printString(characterStack);

        }


        while (continueCommand.equals("Yes")) {

            // If the user wants changes made, a series of while loops, if-else
            // statements, and prompts follow to correctly change the string and
            // print the results.

            System.out.print("What will be your command to change\n" +
                    "the stack? Press 'U' to make all letters\n" +
                    "uppercase. Press 'L' to make all letters\n" +
                    "lowercase. Press 'R' to reverse the string.\n" +
                    "Press 'C' to get more prompts to replace characters.\n" +
                    "Press 'Z' to undo any changes. Type 'STOP'\n" +
                    "to end the program. > ");

            commandChoice = scnr.next();

            System.out.println();

            if (commandChoice.equals("STOP")) {

                System.exit(0);

            }

           else if (commandChoice.equals("Z")) {

                characterStack = undo(characterStack, undoStack, continueCommand);
            }

            else if (commandChoice.equals("U")) {


                int sizeCharStack = characterStack.size();

                // This is called uppercaseHoldover because it
                // holds an uppercase version of the stack.
                // ChatGPT gave me the idea to initialize
                // a character array for this purpose.

                char[] uppercaseHoldover = new char[sizeCharStack];

                // I used ChatGPT to help me make all the
                // characters in the character stack uppercase.
                // I cite ChatGPT with the help of changing
                // the characters in the stack to uppercase.
                // It suggested to me to use pop and push.

                for (int i = sizeCharStack - 1; i >= 0; i--) {

                        uppercaseHoldover[i] = Character.toUpperCase(characterStack.top());

                        characterStack.pop();

                }

                // This returns the uppercase characters to the character stack.
                //I got this idea from ChatGPT as well.

                for (int i = 0; i < sizeCharStack; i++) {

                        characterStack.push(uppercaseHoldover[i]);

                }

                // This makes a copy of the modified character stack.

                undoStack.push(deepCopyStack(characterStack));

                // This asks the user if they want to continue making changes.

                System.out.print("Do you want to make another change or print out\n" +
                        "your results? Type 'Yes' to make another change, or 'X'\n" +
                        "to print your results out. > ");

                continueCommand = scnr.next();

                if (continueCommand.equals("X")) {

                    printString(characterStack);

                }

                System.out.println();

            } else if (commandChoice.equals("L")) {


                int sizeCharStack = characterStack.size();

                // This array holds a lowercase version of the character stack.
                // As before, ChatGPT helped me with this character array as well.

                char[] lowercaseHoldover = new char[sizeCharStack];

                // This is a creation of the lowercaseHoldover array.
                // ChatGPT helped me here.

                for (int i = sizeCharStack - 1; i >= 0; i--) {

                        lowercaseHoldover[i] = Character.toLowerCase(characterStack.top());

                        characterStack.pop();

                }

                // This makes the character stack lowercase.
                // ChatGPT also helped me here.

                for (int i = 0; i < sizeCharStack; i++) {

                        characterStack.push(lowercaseHoldover[i]);

                }

                // This saves the modified version of the character stack.

                undoStack.push(deepCopyStack(characterStack));

                System.out.print("Do you want to make another change or print out\n" +
                        "your results? Type 'Yes' to make another change, or 'X'\n" +
                        "to print your results out. > ");

                continueCommand = scnr.next();

                if (continueCommand.equals("X")) {

                    printString(characterStack);

                }

                System.out.println();


            } else if (commandChoice.equals("R")) {


                int sizeCharStack = characterStack.size();

                // This creates a reverse character array.
                // ChatGPT helped me here as well.

                char[] reverseCharArray = new char[sizeCharStack];

                // This fills up the reverse array.
                // ChatGPT helped me here too.

                for (int i = 0; i < sizeCharStack; i++) {

                        reverseCharArray[i] = characterStack.top();

                        characterStack.pop();


                }

                // This refills the character stack reversed.
                // ChatGPT helped me here as well.

                for (int i = 0; i < sizeCharStack; i++) {

                        characterStack.push(reverseCharArray[i]);

                }

                // This saves a modified version of the stack.

                undoStack.push(deepCopyStack(characterStack));

                System.out.print("Do you want to make another change or print out\n" +
                        "your results? Type 'Yes' to make another change, or 'X'\n" +
                        "to print your results out. > ");

                continueCommand = scnr.next();

                if (continueCommand.equals("X")) {

                    printString(characterStack);

                }

                System.out.println();

            } else if (commandChoice.equals("C")) {

                // This prompts the user to give the inputs so the
                // replacement code can work. ChatGPT helped me
                // with the replacement code.

                System.out.print("Please first type the character you\n" +
                        "want to replace, and then type the character\n" +
                        "you want to replace it with. > ");

                // This method of the scanner catching the first index characters
                // comes from the Geeks For Geeks website.

                Character ch1 = scnr.next().charAt(0);

                Character ch2 = scnr.next().charAt(0);

                System.out.println();

                int sizeCharStack = characterStack.size();

                // The character array is to help with the replacement code.
                // ChatGPT gave me the idea for the character array.

                char[] replaceAllHoldover = new char[sizeCharStack];

                for (int i = sizeCharStack - 1; i >= 0; i--) {

                        replaceAllHoldover[i] = characterStack.top();

                        characterStack.pop();

                }

                // Since you cannot use the replaceAll method
                // on characters, I used ChatGPT to help me with
                // replacing the individual characters. ChatGPT
                // provided me with code to create a function
                // to replace characters here.

                for (int i = 0; i < sizeCharStack; i++) {

                    if (replaceAllHoldover[i] == ch1) {

                        replaceAllHoldover[i] = ch2;

                    }
                }

                // ChatGPT helped me refill the character stack.

                for (int i = 0; i < sizeCharStack; i++) {

                        characterStack.push(replaceAllHoldover[i]);

                }

                // This saves a modified version of the stack.

                undoStack.push(deepCopyStack(characterStack));

                System.out.print("Do you want to make another change or print out\n" +
                        "your results? Type 'Yes' to make another change, or 'X'\n" +
                        "to print your results out. > ");

                continueCommand = scnr.next();

                if (continueCommand.equals("X")) {

                    printString(characterStack);

                }

                System.out.println();

            }
        }
    }

    // This is an undo function that reverts the current stack to a previous stack.
    // ChatGPT recommended this to me.


    private static ArrayBoundedStack<Character> undo(ArrayBoundedStack<Character> characterStack,
                             ArrayBoundedStack<StackInterface<Character>> undoStack,
                             String continueCommand) {

        Scanner scnr = new Scanner(System.in);

        // Check if there is a previous state to undo.

        if (!undoStack.isEmpty()) {

            undoStack.pop(); // Discard the current state.

            if (!undoStack.isEmpty()) {

                ArrayBoundedStack<Character> previousState =

                        (ArrayBoundedStack<Character>) undoStack.top();

                // This is a temporary stack for reversing order.

                ArrayBoundedStack<Character> tempStack =

                        new ArrayBoundedStack<>(previousState.size());

                // Empty the current characterStack and reverse previousState into tempStack.

                while (!characterStack.isEmpty()) {

                    characterStack.pop();

                }
                while (!previousState.isEmpty()) {

                    Character ch = previousState.top();

                    previousState.pop();

                    tempStack.push(ch);

                }

                // Refill characterStack and previousState from tempStack.

                while (!tempStack.isEmpty()) {

                    Character ch = tempStack.top();

                    tempStack.pop();

                    characterStack.push(ch);

                    previousState.push(ch);

                }

                System.out.println("Undo successful. Stack reverted to the previous state.");

                System.out.println();

                System.out.print("Do you want to make another change or print out\n" +
                        "your results? Type 'Yes' to make another change, or 'X'\n" +
                        "to print your results out. > ");

                continueCommand = scnr.next();

                if (continueCommand.equals("X")) {

                    printString(characterStack);

                }

                System.out.println();

            }

            else {
                System.out.println("No previous state to undo.");
            }
        }
        return characterStack;
    }





        private static void printString(StackInterface<Character> characterStack) {

            // ChatGPT helped me construct this print block.

            // ChatGPT suggested to me to use the StringBuilder.

            System.out.print("Your final output is: ");

            // Create a StringBuilder to build the string representation of the characterStack.

            StringBuilder finalOutput = new StringBuilder();

            // Create a variable to keep track of the number of elements in characterStack.

            int size = characterStack.size();

            // Create an array to temporarily store the elements in characterStack.

            Character[] tempArray = new Character[size];

            // Copy elements from characterStack to tempArray while preserving the original order.

            for (int i = size -1; i >= 0; i--) {

                tempArray[i] = characterStack.top();

                characterStack.pop();

            }

            // Revert the elements back to characterStack.

            for (int i = 0; i < size; i++) {

                characterStack.push(tempArray[i]);

            }

            // Build the string representation by appending characters from tempArray.

            for (int i = 0; i < size; i++) {

                finalOutput.append(tempArray[i]);

            }

            // Print the final output as a string.

            System.out.println(finalOutput.toString());


        }

    // This is to copy stacks and provide a snapshot of the user-defined stack.
    // This is so the user can go to a previously defined version of the stack.
    // I used ChatGPT to help me with this deepCopyStack method.

    static StackInterface<Character> deepCopyStack(StackInterface<Character> original) {

        // This is a temporary stack to create the stack copy.

        StackInterface<Character> temporaryStack = new ArrayBoundedStack<>(original.size());

        // This is the stack copy.

        StackInterface<Character> copy = new ArrayBoundedStack<>(original.size());

        // This is to transfer elements from the original stack
        // to the temporary stack (reversing order).

        while (!original.isEmpty()) {

            Character topElement = original.top();

            original.pop();

            temporaryStack.push(topElement);

        }

        // This is to transfer back to the original stack
        // (restoring order) and copy to the new stack.

        while (!temporaryStack.isEmpty()) {

            Character topElement = temporaryStack.top();

            temporaryStack.pop();

            original.push(topElement);

            copy.push(topElement);

        }

        // This returns a copy (snapshot) of a stack.

        return copy;
    }
}