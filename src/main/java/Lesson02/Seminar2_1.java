package Lesson02;

//1.Необходимо написать один из простых алгоритмов сортировки,
// имеющий сложность O(n 2 ).
//2.Можно выбрать из пузырьковой сортировки, сортировки вставками и
//  сортировки выбором.
//3.Следует обратить внимание на сложность данных алгоритмов и
// указать признаки квадратичной сложности для каждого из них.

import java.util.Random;

public class Seminar2_1 {
    public static void main(String[] args) throws Exception {

        int size = 100;
        int min = 0;
        int max = 100;
        int[] arr = getRandomArr(size, min, max);

        printArr(arr);

        bubbleSort(arr);

        printArr(arr);

    }

    /**
     * @apiNote bubble sort method
     * @param arr - array to sort
     */
    static void bubbleSort(int[] arr) {
        boolean fin;
        do {
            fin = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {

                    arr[i] += arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] -= arr[i + 1];

                    fin = false;
                }
            }
        } while (!fin);
    }

    /**
     * @apiNote print array into console
     * @param arr - array to print
     */
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * create pseudo-random int array
     * @param size - size of the array to form
     * @param min - min value of array
     * @param max - max value of array
     * @return - array created
     */
    static int[] getRandomArr(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }
}
