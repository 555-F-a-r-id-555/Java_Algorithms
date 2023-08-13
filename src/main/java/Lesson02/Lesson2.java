package Lesson02;

import java.util.Arrays;
import java.util.Random;

public class Lesson2 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 8, 0, 1, 7, 3, 4, 11, 22};


        int[] numbers = new int[25];
        randomNUmber(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("------------------------>");

        // BubbleSort;
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array) +" ");
        //DirectSort - сортировка выбором;
//        directSort(numbers);
//        System.out.println(Arrays.toString(numbers) + " ");
        // InsertSort - сортировка вставками;
//        insertSort(numbers);
//        System.out.println(Arrays.toString(numbers) + " ");
        // InsertSort2 - сортировка вставками;
//        insertSort2(numbers);
//        System.out.println(Arrays.toString(numbers) + " ");
        //
        System.out.println("------------------------>");
        // find num
        System.out.println("find() = " + find(array, 22));

        System.out.println("------------------------>");
        //BinarySearch
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("binarySearch() = " + binarySearch(array1, 8));

        System.out.println("------------------------>");
        //HeapSort
         heapSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;

                }
            }
        } while (!finish);

    }


    private static void directSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minPosition] > array[j]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }

    }

    private static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }
        }

    }

    private static void insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    private static int[] randomNUmber(int[] number) {
        Random random = new Random();
        for (int i = 0; i < number.length; i++) {
            int rand = random.nextInt(100);
            number[i] = rand;
        }
        return number;
    }

    private static int find(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;

        if (min > max) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }

        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        } else if (array[midPoint] > value) {
            return binarySearch(array, value, min, midPoint - 1);
        } else {
            return midPoint;
        }
    }

    private static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }

        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if (rightChild<heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево;
            heapify(array,heapSize,largest);
        }

    }

    private static void heapSort(int[] array){
        // Просеивание кучи (перегруппируем массив)
        for (int i = array.length/2 - 1; i >=0 ; i--) {
            heapify(array,array.length,i);
        }

        // один за другим извлекаем элементы из кучи
        for (int i =array.length -1 ; i >=0 ; i--) {
            // Перемещяем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(array,i,0);
        }
    }


}
