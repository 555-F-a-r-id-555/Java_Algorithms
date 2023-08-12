package Lesson01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson01 {
    public static void main(String[] args) {
        // 1
//        List<Integer> availableDivider = findAvailabaleDevider(12);
//        System.out.println(availableDivider);
        // 2
//        List<Integer> simpleDivider = findSimoleNumbers(12);
//        System.out.println(simpleDivider);
        // 0,1,1,2,3,5,8,13,21,34,55,89....
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fibo(10,counter);
        System.out.println("fib = " + fib);
        System.out.println("counter = " + counter);

        counter = new AtomicInteger(0);
        fib = fibo(11,counter);
        System.out.println("fib = " + fib);
        System.out.println("counter = " + counter);

        counter = new AtomicInteger(0);
        fib = fibo(12,counter);
        System.out.println("fib = " + fib);
        System.out.println("counter = " + counter);
    }

    private static List<Integer> findAvailabaleDevider(int number) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            counter++;
            if (number % i == 0) {
                result.add(i);
            }
        }
        System.out.println(counter);
        return result;
    }

    private static List<Integer> findSimoleNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println(counter);
        return result;
    }

    private static int fibo(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) return 0;
        else if (position == 2) {
            return 1;
        }
        return fibo(position - 1, counter) + fibo(position - 2, counter);
    }

}
