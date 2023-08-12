package Lesson02;
//1.После успешной сортировки массива на нем можно использовать бинарный
// поиск. Необходимо реализовать алгоритм бинарного поиска по
//  элементам.
//2.Стоит акцентировать внимание, что т.к. алгоритм использует подход
//  «разделяй и властвуй», его удобно писать с помощью рекурсии.
//3.Так что стоит акцентировать внимание на алгоритмическую сложность
// данного алгоритма, что его выполнение многократно быстрее простого
// перебора на больших массивах
import java.util.Arrays;

public class Seminar3_4 {
    public static void main(String[] args) {
        int size = 100;
        int min  = 1;
        int max = 100;
        int [] array = Seminar2_1.getRandomArr(size, min, max);
        Arrays.sort(array);
        Seminar2_1.printArr(array);
        System.out.println(search(array, 5, 0, array.length - 1));
    }
    public static int search(int [] array, int value, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = (max - min) / 2 + min;
        }
        if (array[middle] < value) {
            return search(array, value, middle + 1, max);
        } else {
            if (array[middle] > value) {
                return search(array,value, min, middle - 1);
            } else {
                return middle;
            }
        }
    }
}
