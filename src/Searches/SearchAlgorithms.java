package Searches;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Johnny on 19/10/2018
 * COMMENTS ABOUT THE PROGRAM GO HERE
 */
public class SearchAlgorithms {
     static Scanner keyboard = new Scanner(System.in);

    // Method to print out an array
    public static void printArray(int[] pArray) {
        System.out.print("[ ");
        for (int index = 0; index < pArray.length; index++)
            System.out.print(pArray[index] + " ");
        System.out.println("]");
    }

    // Method to generate a random array
    public static int[] generateRandomArray(int[] pArray) {
        for (int index = 0; index < pArray.length; index++) {
            pArray[index] = (int) ((Math.random() * 100) + 1);
        }
        return pArray;
    }

    // Method to generate a random ascending array
    public static void generateRandomAscendingArray(int[] pArray) {
        pArray[0] = (int) ((Math.random() * 5) + 1);
        for (int index = 1; index < pArray.length; index++) {
            pArray[index] = pArray[index - 1] + (int) ((Math.random() * 5) + 1);
        }
    }

    // LINEAR search method
    public static int linearSearch(int[] pArray, int pTarget) {
        boolean found = false;
        int pos = 0;
        int countLoop = 0;
        int target = pArray[pTarget];
        while ((!found) && (pos <= pArray.length)) {
            countLoop++;
            if (pArray[pos] == target)
                found = true;
            else
                pos++;
        }
        System.out.println("The number of linear search comparisons was " + countLoop);
        return countLoop;
    }



    // BINARY search method
    public static int binarySearch(int[] pArray, int pTarget) {
        int bottom = 0;
        int middle;
        int top = pArray.length - 1;
        int countLoop = 0;
        boolean found = false;

        while ((!found) && (bottom <= top)) {
            countLoop++;
            middle = (bottom + top) / 2;
            if (pArray[middle] == pTarget)
                found = true;
            else {
                if (pArray[middle] > pTarget)
                    top = middle - 1;
                else
                    bottom = middle + 1;
            }
        }
        System.out.println("The number of binary search comparisons was " + countLoop);
        return countLoop;
    }


    public static void bubbleSort(int[] pArray) {

        boolean exchangeMade;
        int last = pArray.length - 1;
        int temp;
        int iterations = 0;

        do {
            exchangeMade = false;
            for (int loop = 0; loop < last; loop++) {
                if (pArray[loop] > pArray[loop + 1]) {
                    temp = pArray[loop];
                    pArray[loop] = pArray[loop + 1];
                    pArray[loop + 1] = temp;
                    exchangeMade = true;
                }
            }
            last = last - 1;
            iterations++;

        } while ((exchangeMade) && (last >= 1));
        System.out.println("Bubble sorted array:");
        printArray(pArray);
        System.out.println("It took " + iterations + " iterations to sort this array\n");

    }

    public static void selectionSort(int[] pArray) {
        int size = pArray.length - 1;
        int minPos, minValue;

        for (int pass = 0; pass < size; pass++) {
            minValue = pArray[pass];
            minPos = pass;
            for (int location = pass + 1; location <= size; location++) {
                if (pArray[location] < minValue) {
                    minValue = pArray[location];
                    minPos = location;
                }
            }
            pArray[minPos] = pArray[pass];
            pArray[pass] = minValue;

        }
        printArray(pArray);
    }

    public static void insertionSort(int[] pArray) {
        int saved, mover;
        for (int pos = 1; pos < pArray.length; pos++) {
            saved = pArray[pos];
            mover = pos;
            while ((mover > 0) && (saved < pArray[mover - 1])) {
                pArray[mover] = pArray[mover - 1];
                mover--;
            }
            pArray[mover] = saved;

        }printArray(pArray);
    }

    public static void menu(int[]array){

        int selection;

        do {
            System.out.println("MENU");
            System.out.println("Your SORTING options are as follows:");
            System.out.println("\t1\tSelection");
            System.out.println("\t2\tBubble");
            System.out.println("\t3\tInsertion");
            System.out.println("\t4\tExit Program");
            System.out.print("Please select your preferred sorting technique (enter 1, 2, 3 or 4): ");

            selection = keyboard.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("\nYou have chosen Selection Sorting.");
                    selectionSort(array);
                    break;
                case 2:
                    System.out.println("\nYou have chosen Bubble Sorting.");
                    bubbleSort(array);
                    break;
                case 3:
                    System.out.println("\nYou have chosen Insertion Sorting.");
                    insertionSort(array);
                    break;
                case 4:
                    System.out.println("\nExit Program");
                    break;
                default:
                    System.out.println("\nInvalid entry, try again.");
                    System.out.println();
            }
        } while (selection != 4);

    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        int arraySize;
        int targetIndex;
        int noOfSearches;
        int countLinear = 0;
        int countBinary = 0;

        System.out.println("Welcome");
        System.out.println("Do you wish to search an array or sort an array:");
        System.out.println("\t1\tSearch");
        System.out.println("\t2\tSort");
        System.out.print("Please enter 1 or 2: ");
        int searchOrSort = keyboard.nextInt();

        if(searchOrSort == 1){
            System.out.println("You have chosen to search an array");
            System.out.println("Do you wish to search an ordered or unordered array:");
            System.out.println("\t1\tOrdered");
            System.out.println("\t2\tUnordered");
            System.out.print("Please enter 1 or 2: ");
            int orderedOrUnordered = keyboard.nextInt();
            if(orderedOrUnordered == 1){
                System.out.println("You have chosen to search an ordered array");
            }
        }else {
            System.out.println("\nYou have chosen to sort an array");
            // prompt user for array size
            System.out.print("\nEnter array size: ");
            arraySize = keyboard.nextInt();

            int[] myArray = new int[arraySize];

            // generate and print out array
            generateRandomArray(myArray);
            System.out.println();
            printArray(myArray);
            menu(myArray);
        }



//        // prompt user for amount of searches
//        System.out.println();
//        System.out.print("How many searches do you require: ");
//        noOfSearches = keyboard.nextInt();
//        System.out.println();
//
//        for (int search = 1; search <= noOfSearches; search++) {
//            targetIndex = ((int) ((Math.random() * arraySize) + 1)) - 1;
//            System.out.println("Search no." + search);
//            System.out.println("The target value is " + myArray[targetIndex]);
//            System.out.println("The target is at index " + targetIndex + " in the array");
//            countLinear += linearSearch(myArray, targetIndex);
//            countBinary += binarySearch(myArray, targetIndex);
//            System.out.println();
//            System.out.println("**********************************************");
//            System.out.println();
//        }
//
//        System.out.println("The average number of linear searches is " + df.format((double)countLinear / noOfSearches));
//        System.out.println("The average number of binary searches is " + df.format((double)countBinary / noOfSearches));
//
//        generateRandomArray(myArray);
//        printArray(myArray);

    }
}
