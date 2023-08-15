package Lesson03;
/*1.Реализуем простой односвязный список.
 2.Пишем только структуру, никаких методов не требуется.*/

public class Seminar3_1 {
    Node head;
    public static class Node{
       public int value;
        public Node next;
    }

    public class Node2<T> {
        public T value;
        public Node2<T> next;

        public Node2(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public class LinkedList<T> {
        public Node2<T> head;

        public LinkedList() {
            this.head = null;
        }
    }

}
