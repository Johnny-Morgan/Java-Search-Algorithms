package Searches;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Johnny on 19/10/2018
 * COMMENTS ABOUT THE PROGRAM GO HERE
 */
public class SearchAlgorithms {
    // Method to print out an array
    public static void printArray(int[] pArray) {
        System.out.print("[ ");
        for (int index = 0; index < pArray.length; index++)
            System.out.print(pArray[index] + " ");
        System.out.println("]");
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
        printArray(pArray);
        boolean exchangeMade;
        int last = pArray.length - 1;
        int temp;

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
        } while ((exchangeMade) && (last >= 1));
        printArray(pArray);
    }


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        int arraySize;
        int targetIndex;
        int noOfSearches;
        int countLinear = 0;
        int countBinary = 0;

        // prompt user for array size
        System.out.print("Enter array size: ");
        arraySize = keyboard.nextInt();

        int[] myArray = new int[arraySize];

        // generate and print out array
        generateRandomAscendingArray(myArray);
        printArray(myArray);

        // prompt user for amount of searches
        System.out.println();
        System.out.print("How many searches do you require: ");
        noOfSearches = keyboard.nextInt();
        System.out.println();

        for (int search = 1; search <= noOfSearches; search++) {
            targetIndex = ((int) ((Math.random() * arraySize) + 1)) - 1;
            System.out.println("Search no." + search);
            System.out.println("The target value is " + myArray[targetIndex]);
            System.out.println("The target is at index " + targetIndex + " in the array");
            countLinear += linearSearch(myArray, targetIndex);
            countBinary += binarySearch(myArray, targetIndex);
            System.out.println();
            System.out.println("**********************************************");
            System.out.println();
        }

        System.out.println("The average number of linear searches is " + df.format((double)countLinear / noOfSearches));
        System.out.println("The average number of binary searches is " + df.format((double)countBinary / noOfSearches));

        // Test bubble sort method
        System.out.println("\n******************");
        System.out.println("TESTING bubble sort method");
        int[]newArray = {200,63,1,74,34,86};
        bubbleSort(newArray);
    }
}
