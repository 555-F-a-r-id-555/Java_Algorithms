package Lesson01;
//Пишем алгоритм поиска нужного числа последовательности
// Фибоначчи, но в этот раз откажемся от рекурсии и воспользуемся
// обычным алгоритмом, что даст нам линейную сложность, т.к.
// вычисление каждого из чисел последовательности будет
// происходить ровно 1 раз.

public class Seminar06 {
    public static void main(String[] args) throws Exception {
        // сравнить алгоритмы вычисления числа Фибоначчи по номеру позиции

        for (int i = 5; i < 50; i += 5) {
            long t1 = System.currentTimeMillis();
            System.out.println(Seminar05.findFibonachy(i));
            long t2 = System.currentTimeMillis();
            System.out.println(Seminar04.fiboRecursion(i));
            long t3 = System.currentTimeMillis();

            System.out.println("Loop took: " + i + " -> " + (t2 - t1) + " ms");
            System.out.println("Fibo took: " + i + " -> " + (t3 - t2) + " ms");
        }
    }
}

//        // Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
//        Scanner iScan = new Scanner(System.in);
//        int n = iScan.nextInt();
//        iScan.close();
//
//        System.out.println(fiboRecursion(n));
//    }
//
//    /**
//     * @apiNote Algorithm of Fibonacci by recursion
//     * @param pos - position to find
//     * @return value of the element
//     */
//    public static int fiboRecursion(int pos) {
//        if (pos == 1 || pos == 2) {
//            return 1;
//        }
//
//        return fiboRecursion(pos - 1) + fiboRecursion(pos - 2);
//    }

//}

