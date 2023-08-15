package Lesson03;

public class Lesson3 {
    Node head;
    Node tail;

    // класс Node
    private static class Node {
        int value;
        Node next;
        Node previous;
    }


    // добавление в конец
    private void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    // добавление в середину
    private void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }
    // удаление ноды
    private void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;

        if (previous == null) {
            next.previous = null;
            head = next;
        } else if (next == null) {
            previous.next = null;
            tail = previous;
        } else {
            previous.next = next;
            next.previous = previous;
        }


    }

    // нахождение элемента списка
    private Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    // revert - двух связанного списка
    private void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    // revert - одно связанного списка
    public void revert3() {
        if (head != null && head.next != null) {
            Node temp = head;
            revert2(head.next, head);
            head.next = null;
        }
    }

    private void revert2(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert2(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
//        previousNode.next = null;
    }

    // стек - LIFO => Last in first out
    // очередь - FIFO => First in first out

    // push - добавление в начало списка для стека и очереди
    // стек - одно-связанный список
    private void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    // push - добавление в начало списка для очереди
    // очередь - двух-связанный список
    private void push2(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    private Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }


    // pop - удаление из начала списка для стека
    // стек - одно-связанный список
    private Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }


}


