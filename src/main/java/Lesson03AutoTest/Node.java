package Lesson03AutoTest;

//В классе Answer реализуйте метод reverse,
//который принимал бы на вход односвязный список и разворачивал бы его.
//Для решения данного домашнего задания вам необходимо воспользоваться
// сервисом автоматической проверки написанного кода.
//Для того, чтобы успешно выполнить задание,
// необходимо перейти по каждой из представленных ссылок
// и решить все предложенные задачи. Будьте внимательны,
// количество попыток отправки кода на проверку ограничено!
// Вам дано 5 попыток на каждую задачу.
//Прикреплять полученные решения не требуется.
// Итоговая оценка домашнего задания появится автоматически
// на платформе после решения всех задач. Полученная оценка не
// повлияет на получение итогового документа об обучении.
//

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Answer {
    Node head;
    public void reverse() {
        // Введите свое решение ниже
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
}

class Printer {
    public static void main(String[] args) {
        // Создаем связанный список 1 -> 2 -> 3 -> 4
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
        ans.reverse();

        // Выводим инвертированный порядок элементов списка
        Node current = ans.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}