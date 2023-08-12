package Lesson01;
//Необходимо написать алгоритм, считающий сумму всех чисел
//        от 1 до N. Согласно свойствам линейной сложности,
//        количество итераций цикла будет линейно изменяться
//        относительно изменения размера N.
//        21:15
//        sum.soutv + tab
//        21:15
//        ctrl+alt+l
//        21:15
//        ctrl+alt+o
//        21:16
//        ctrl+alt+m


import java.util.Scanner;

public class Seminar01 {
//    public static void main(String[] args) {
//
//        System.out.println(sum(4));
//    }
//
//    /**
//     * @apiNote сумму всех чисе от 1 до N
//     * @param number = N
//     * @return sum
//     */
//
//    private static int sum(int number) {
//        int sum = 0;
//        for (int i = 0; i <= number; i++) {
//            sum += i;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = getSum(n);
        System.out.println("sum = " + sum);

    }

    /**
     * @param n число до которого необходимо ссуммировать
     * @return сумма
     * @apiNote Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N
     */
    private static int getSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

}
