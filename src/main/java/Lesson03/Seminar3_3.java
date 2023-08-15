package Lesson03;
/*1.Реализуем метод поиска элемента в односвязном списке для
    проверки наличия элемента внутри списка.
  2.Для корректной работы со связным список необходимо понимать, как именно
    можно обходить все значения внутри связного списка.
  3.Для нашего примера проще всего будет написать метод поиска значения в
    связном списке и возвращения из метода информации о наличии искомого
    внутри списка.*/


public class Seminar3_3 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        list.addAtBeginning(2);
        list.addAtBeginning(22);
        list.addAtBeginning(222);
        list.addAtBeginning(5);
        list.addAtBeginning(55);


        System.out.println("list.find(55) = " + list.find(55).value);
        System.out.println("list.isFind(56) = " + list.isFind(56));


    }
    public static class Node<T extends Number> {

        public T value;
        public Node<T> next;

        public void Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class LinkedList<T extends Number> {
        public Node<T> head;

        public LinkedList() {
            this.head = null;
        }

        public boolean isFind(int target){
            Node<T> res= find(target);
            return res!=null;
        }

        public Node find(int target) {
            while (head != null) {
                if ((Integer) head.value == target) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }
        private void addAtBeginning(int value) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
        }
    }

}
