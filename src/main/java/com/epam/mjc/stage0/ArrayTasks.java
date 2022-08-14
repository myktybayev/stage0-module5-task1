package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String str[] = {"winter", "spring", "summer", "autumn"};
        return str;
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int n[] = new int[length];
        for (int i = 1; i <= length; i++) {
            n[i-1] = i;
        }
        return n;

    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }
        return sum;

    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return i;
            }
        }
        return -1;

    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] secondArray = new String[arr.length];
        for (int i = arr.length-1, j = 0; i >= 0 ; i--, j++) {
            secondArray[j] = arr[i];
        }
        return secondArray;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for (int n:arr) if(n > 0) count++;
        int newArray[] = new int[count];

        for (int i = 0, j = 0; i < arr.length; i++)
            if(arr[i] > 0){
                newArray[j] = arr[i];
                j++;
            }

        return newArray;

    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                int curALength = arr[i].length;
                int nextALength = arr[i+1].length;

                if (curALength > nextALength) {
                    int temp[] = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                int curALength = arr[i].length;
                int nextALength = arr[i+1].length;
                if (curALength > nextALength) {
                    int temp[] = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int sortArray[] = arr[i];

            for (int j = 0; j < sortArray.length; j++) {
                swapped = true;
                start = 0;
                end = sortArray.length;
                while (swapped) {
                    swapped = false;
                    for (int k = start; k < end - 1; ++k) {
                        if (sortArray[k] > sortArray[k + 1]) {
                            int temp = sortArray[k];
                            sortArray[k] = sortArray[k + 1];
                            sortArray[k + 1] = temp;
                            swapped = true;
                        }
                    }
                    if (swapped == false)
                        break;

                    swapped = false;
                    end = end - 1;
                    for (int k = end - 1; k >= start; k--) {
                        if (sortArray[k] > sortArray[k + 1]) {
                            int temp = sortArray[k];
                            sortArray[k] = sortArray[k + 1];
                            sortArray[k + 1] = temp;
                            swapped = true;
                        }
                    }
                    start = start + 1;
                }
            }
            arr[i] = sortArray;
        }

        return arr;
    }
}
