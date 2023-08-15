package Lesson03;
//1.Расширяем структуру односвязного списка до двухсвязного.
//2.Мы научились работать с односвязным список, теперь можно ближе
//познакомиться со структурой двухсвязного списка и особенностей его
//внутреннего строения.
//3.Стоит напомнить, что двухсвязный список представляет из себя цепочку
//элементов, которые умеют ссылаться не только на следующий элемент
//последовательности, но и на предыдущий.
//4.Вносить корректировки в уже готовые методы на текущий момент не стоит, их
//модификацией мы займемся позднее

public class Seminar3_5 {

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

    public static class LinkedList {
        public Node head;

        public Node tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }
    }

}
