package Lesson03AutoTest_2;


class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Answer {
    Node head;


    void reverse1() {
        if (head != null && head.next != null) {
            reverse1(head.next, head);
            head.next = null;
        }
        System.out.println("Список успешно реверсирован.");
    }

    void reverse1(Node currentNode, Node previousNode) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            reverse1(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }


    void reverse2() {
        if (head != null && head.next != null) {
            reverse2(head, head.next);
        }
    }

    private void reverse2(Node current, Node next) {
        if (next.next != null) {
            reverse2(next, next.next);
        } else {
            head = next;
        }

        next.next = current;
        current.next = null;
    }




    // Итеративный метод:

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Создание нового списка:
    Node reverse3() {
        Node newHead = null;
        Node current = head;

        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = newHead;
            newHead = newNode;

            current = current.next;
        }

        return newHead;
    }


}


class Printer {
    public static void main(String[] args) {
        Node head;
        if (args.length == 0) {
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
        } else {
            head = new Node(Integer.parseInt(args[0]));
            head.next = new Node(Integer.parseInt(args[1]));
            head.next.next = new Node(Integer.parseInt(args[2]));
            head.next.next.next = new Node(Integer.parseInt(args[3]));
        }


        // Сохраняем голову списка в поле класса Answer
        Answer ans = new Answer();
        ans.head = head;
        // Инвертируем порядок элементов списка
        ans.reverse2();

        // Выводим инвертированный порядок элементов списка
        Node current = ans.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;


        }

    }
}

