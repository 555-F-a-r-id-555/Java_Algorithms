package Lesson03;

/*1.Обновляем методы согласно новой структуре.
        2.Появилась дополнительная переменная, которую необходимо отслеживать во
        всех операциях.
        3.Так же благодаря ссылке на последний элемент списка операции работы с
        концом стали проще и их стоит заменить на логику аналогичную работе с
        началом списка*/

public class Seminar3_6 {

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

        private void addToBeginning(int value) {
            Node newNode = new Node(value);
            if (head != null) {
                head.previous = newNode;
            }
            newNode.next = head;
            head = newNode;
        }

        private void addToEnd(int value) {
            Node node = new Node(value);
            if (tail != null) {
                tail.next = node;
            }
            node.previous = tail;
            tail = node;
        }

        private void removeFromBeginning() {
            if (head != null) {
                if (head.next!=null){
                    head.next.previous =null;
                    head = head.next;
                }else {
                    head = null;
                    tail =null;
                }
            }
        }

        private void removeLast() {
            if (tail != null) {
                if (tail.previous != null) {
                    tail.previous.next = null;
                    tail = tail.previous;
                } else {
                    head =null;
                    tail =null;
                }
            }
        }

        public boolean isFind(int target) {
            Node res = find(target);
            return res != null;
        }

        public Node find(int target) {
            Node current = head;
            while (current != null) {
                if (current.value == target) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }


    }


}
