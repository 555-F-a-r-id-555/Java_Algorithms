package Lesson02;

public class Lesson2 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 8, 0, 1, 7, 3, 4, 11, 22};

        bubbleSort(array);


        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }


    }

    private static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = temp;
                    finish = false;

                }
            }
        } while (!finish);

    }


    private static void directSort(int[] array){

    }
}
