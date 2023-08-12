package Lesson02;

import java.util.Arrays;

//Реализовать алгоритм пирамидальной сортировки
//        (сортировка кучей).
public class Seminar02_DZ {
    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        int[] arr1 = {4, 5, 2, 7, 1};

        heapSort(arr1);
        long t2 = System.currentTimeMillis();

        System.out.println("arr1 = " + Arrays.toString(arr1)+" sorted for " + t2 + "-" + t1 +" " + (t2 - t1) + "ms");

        t1 = System.currentTimeMillis();
        int[] arr2 = {15, 11, 10, 7, 5, 9, 2, 6, 4, 3, 1, 8, 12};

        heapSort(arr2);
        t2 = System.currentTimeMillis();

        System.out.println("arr2 = " + Arrays.toString(arr2)+" sorted for " + t2 + "-" + t1 +" " + (t2 - t1) + "ms");

    }

    /**
     * @apiNote - HeepSort - sorted array by heapSort
     * @param array - array
     */

    public static void heapSort(int[] array) {

        int arrayLength = array.length;
        buildHeap(array, arrayLength);

        while (arrayLength > 1) {

            swap(array, 0, arrayLength - 1);

            arrayLength--;

            fromBinaryTreeToHeap(array, arrayLength, 0);

        }
    }

    private static void buildHeap(int[] array, int arrayLength) {
        for (int i = arrayLength / 2; i >= 0; i--) {
            fromBinaryTreeToHeap(array, arrayLength, i);
        }
    }

    /**
     * @apiNote - create heap from array
     * @param array  - array
     * @param arrayLength - length
     * @param i - index
     */

    private static void fromBinaryTreeToHeap(int[] array, int arrayLength, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int greater;

        if (left < arrayLength && array[left] > array[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < arrayLength && array[right] > array[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(array, i, greater);
        }
    }

    /**
     * @apiNote - swap - change position
     * @param array  - array of values
     * @param i  - index of element
     * @param greater  - max value in array
     */

    private static void swap(int[] array, int i, int greater) {
        int temp = array[i];
        array[i] = array[greater];
        array[greater] = temp;
    }



}
