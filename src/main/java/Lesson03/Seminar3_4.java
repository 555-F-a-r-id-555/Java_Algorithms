package Lesson03;

/*1.Реализуем метод добавления новых элементов в конец односвязного списка и добавить удаление
        последнего элемента односвязного списка.
        2.Теперь, когда мы понимаем, как можно искать значения внутри связного списка,
        мы можем сделать методы добавления и удаления элементов в конец нашего
        односвязного списка.*/

public class Seminar3_4 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtEnd(2);
        list.addAtEnd(5);
        list.addAtEnd(220);

        Node currentNode = list.head;
        int count = 1;
        while (currentNode != null) {
            System.out.print(count +":" +currentNode.value +" ");
            count++;
            currentNode = currentNode.next;
        }
    }

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        private Node findPrevious() {
            Node current = head;
            Node prev = null;
            while (current != null && current.next != null) {
                prev = current;
                current = current.next;
            }
            return prev;
        }

        private void addAtEnd(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                return;
            }
            Node prev = findPrevious();
            Node tail = prev.next;
            tail.next = newNode;
        }


        private Node findTail2() {
            Node current = head;
            Node prev = null;

            while (current != null && current.next != null) {
                prev = current;
                current = current.next;
            }

            return prev;
        }

        public void removeFromEnd() {
            if (head == null) {
                return;
            }

            Node prev = findTail2();
            if (prev == null) {
                head = null; // только один узел
            } else {
                prev.next = null;
            }
        }
    }

}
