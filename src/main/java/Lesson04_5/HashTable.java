package Lesson04_5;

import Lesson04_2.HashTable01;

import java.util.List;

class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10; // значения по умолчанию
    private static final double LOAD_FACTOR = 0.75; // уровень заполняемости

    private int size; // текущий размер корзины
    private int capacity;  // вместимость корзины
    private LinkedList<K, V>[] buckets;

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    class LinkedList<K, V> {
        Node<K, V> head;

//        List<Node<K,V>> entries; // сложнее ?

        public LinkedList() {
            head = null;
        }

        // реализовать методы добавления элементов в связный
        public void add(K key, V value) {
            Node<K, V> newNode = new Node<>(key, value);
            if (head != null) {
                head = newNode;
            }
            newNode.next = head;
        }

        // метод поиска данных по ключу в хэш-таблице.
        public V find(K key) {
            Node<K, V> current = head;
            while (current.next != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }

        // удаления элемента с аналогичным ключом из списка
//        public void remove(K key) {
//            Node<K, V> current = head;
//            while (current.next != null) {
//                if (current.key.equals(key)){
//                    current = current.next.next;
//                    current.next = null;
//                }
//            }
//        }

        public void remove(K key) {
            Node<K, V> current = head;
            Node<K, V> prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        head = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    return;
                }
                prev = current;
                current = current.next;
            }
        }
    }



    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public V get(K key) {
        int index = hash(key);
        V value = buckets[index].find(key);
        return value;
    }

    public void put(K key, V value) {
        int index = hash(key);
        buckets[index].add(key, value);
        size++;

        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }

    public void remove(K key) {
        int index = hash(key);
        buckets[index].remove(key);
        size--;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        LinkedList<K, V>[] newBuckets = new LinkedList[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new LinkedList<>();
        }

        for (LinkedList<K, V> bucket : buckets) {
            Node<K, V> current = bucket.head;
            while (current != null) {
                int newIndex = Math.abs(current.key.hashCode()) % newCapacity;
                newBuckets[newIndex].add(current.key, current.value);
                current = current.next;
            }
        }

        buckets = newBuckets;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}

