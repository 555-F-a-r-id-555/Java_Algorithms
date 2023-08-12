package Lesson01;
// Необходимо написать алгоритм поиска всех доступных комбинаций
// (посчитать количество) для количества кубиков
//  K с количеством граней N.
//      2. У вас есть 2 варианта на выбор –
// количество кубиков может быть строго
// ограничено (4 кубика, например), либо их количество будет
// динамическим. Выбор за вами.
//     3. Если вы реализуете простой вариант,
// обращает внимание, что данное
// решение имеет сложность O(n 4 ), но если количество
// кубиков сделать
// переменной, то она трансформируется в O(n k ),
// что будет представлять
// собой экспоненциальную сложность. Для второго решения очевидно,
// что его сложность O(n k ) с самого начала.

import java.util.Scanner;

public class Seminar03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int count = getCount(n);
        System.out.println("count = " + count);
    }

    /**
     * Алгоритм поиска всех доступных комбинаций для 4 кубиков с количеством граней N.
     * @param n - количество граней
     * @return - возвращаем счетчик
     */

    private static int getCount(int n) {
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        count++;
                    }

                }

            }
        }
        return count;
    }
}

//package ru.geekbrains.lesson1.example;
//
//        import java.util.Scanner;
//
//public class Ex3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int facet = scanner.nextInt();
//        scanner.close();
//        System.out.println(getCount(facet));
//    }
//
//    /**
//     * Алгоритм поиска всех доступных комбинаций для 4 кубиков с количеством граней N.
//     * @param facet - количество граней
//     * @return - возвращаем счетчик
//     */
//    private static int getCount(int facet) {
//        int count = 0;
//        for (int i = 0; i < facet; i++) {
//            for (int j = 0; j < facet; j++) {
//                for (int k = 0; k < facet; k++) {
//                    for (int l = 0; l < facet; l++) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//    }
//}
