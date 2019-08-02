package Searches;

/**
 * Created by Johnny on 02/08/2019
 * Program to record time taken to sort an array with various sorting algorithms
 */
public class SearchTimes {

    public static long bubbleSort(int[] pArray) {

        boolean exchangeMade;
        int last = pArray.length - 1;
        int temp;

        long start = System.nanoTime();
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

        return System.nanoTime() - start;
    }


    public static long selectionSort(int[] pArray) {
        int size = pArray.length - 1;
        int minPos, minValue;
        long start = System.nanoTime();

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
        return System.nanoTime() - start;
    }

    public static long insertionSort(int[] pArray) {
        int saved, mover;
        long start = System.nanoTime();
        for (int pos = 1; pos < pArray.length; pos++) {
            saved = pArray[pos];
            mover = pos;
            while ((mover > 0) && (saved < pArray[mover - 1])) {
                pArray[mover] = pArray[mover - 1];
                mover--;
            }
            pArray[mover] = saved;
        }
        return System.nanoTime() - start;
    }

    public static long mergeSort(int[] input, int start, int end) {
        long startTime = System.nanoTime();
        if(end - start < 2)
            return System.nanoTime() - startTime;

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
        return System.nanoTime() - startTime;
    }

    public static void merge(int[] input, int start, int mid, int end) {

        if(input[mid - 1] <= input[mid])
            return;

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while(i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }

    public static void main(String[] args) {

        final int SIZE_OF_ARRAY = 1_000_000;
        int[] array = SearchAlgorithms.generateRandomArray(new int[SIZE_OF_ARRAY]);
        System.out.println("\nTime to sort array (nanoseconds)");
        System.out.println("--------------------------------");
        System.out.println("Bubble sort:\t" + bubbleSort(array.clone()));
        System.out.println("Selection sort:\t" + selectionSort(array.clone()));
        System.out.println("Insertion sort:\t" + insertionSort(array.clone()));
        System.out.println("Merge sort:\t\t" + mergeSort(array.clone(), 0, array.length));
    }
}
