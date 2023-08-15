package Lesson03;
/*1.Реализуем метод добавления новых элементов в начало списка и удаление
 первого элемента связного списка.
2.Односвязный список всегда имеет ссылку на первый элемент
последовательности, потому именно с реализации методов для первого
элемента последовательности стоит начать*/

public class Seminar3_2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("==============Добавление в начало списка================>");
        list.addAtBeginning(2);
        list.addAtBeginning(5);
        list.addAtBeginning(22);
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.println("currentNode = " + currentNode.value);
            currentNode = currentNode.next;
        }
        System.out.println("==============Удаление из начала списка================>");
        list.deleteFromBeginning();
        currentNode = list.head;
        while (currentNode != null) {
            System.out.println("currentNode = " + currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public Node head;


    public static class Node {
        public int value;
        public Node next;

    }

    public static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        private void addAtBeginning(int value) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
        }

        private void deleteFromBeginning() {
            if (head != null) {
                head = head.next;
            }
        }


    }


}
