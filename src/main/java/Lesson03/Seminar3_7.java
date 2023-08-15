package Lesson03;
//1.Добавляем метод сортировки для связного списка.
//        2.Можно использовать любой алгоритм, что мы использовали на предыдущем
//        семинаре, но с точки зрения работы связного списка лучше ориентироваться на
//        пузырьковую сортировку, т.к. она взаимодействует с соседними элементами, а
//        не только по индексам, как делают все остальные сортировки.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Seminar3_7 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addToEnd(5);
        list.addToEnd(3);
        list.addToEnd(8);
        list.addToEnd(1);
        list.addToEnd(7);

        System.out.println("До сортировки:");
        list.printList();

        list.bubbleSort();

        System.out.println("После сортировки:");
        list.printList();
    }
    public Node head;
    public static class Node {
        public int value;
        public Node next;
        public Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // ... другие методы и операции с списком ...

        public void bubbleSort() {
            if (head == null || head.next == null) {
                return; // Если список пуст или содержит только один элемент, сортировать нечего
            }

            boolean flag;
            do {
                flag = false;
                Node current = head;

                while (current.next != null) {
                    if (current.value > current.next.value) {
                        swapNodes(current, current.next);
                        flag = true;
                    }
                    current = current.next;
                }
            } while (flag);
        }

        private void swapNodes(Node node1, Node node2) {
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }

        private void addToEnd(int value) {
            Node newNode = new Node(value);
            if (tail != null) {
                tail.next = newNode;
            }
            newNode.previous = tail;
            tail = newNode;
        }
        private void printList() {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.next;
            }
            System.out.println(); // Перейти на следующую строку после вывода всех элементов
        }

        private List<Integer> printList2() {
            List<Integer> result = new ArrayList<>();
            Node currentNode = head;
            while (currentNode != null) {
                result.add(currentNode.value);
                currentNode = currentNode.next;
            }
            return result;
        }
    }

}
