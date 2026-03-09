package org.linearDataStructures;

class VectorList {

    private int[] data;   // масив елементів
    private int size;     // кількість елементів у списку

    public VectorList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Перевірка: список повний?
    public boolean isFull() {
        return size == data.length;
    }

    // Перевірка: список порожній?
    public boolean isEmpty() {
        return size == 0;
    }

    // Вставка елемента в кінець списку
    // Повертає true якщо успішно, false якщо список повний
    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Список повний! Неможливо додати: " + value);
            return false;
        }
        data[size] = value;
        size++;
        return true;
    }

    // Видалення елемента за індексом
    // Повертає видалений елемент або кидає виняток якщо список порожній / індекс невірний
    public int remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Список порожній! Неможливо видалити елемент.");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Невірний індекс: " + index);
        }
        int removed = data[index];
        // Зсув усіх елементів праворуч від видаленого — на одну позицію ліворуч
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    // Отримати елемент за індексом без видалення
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Невірний індекс: " + index);
        }
        return data[index];
    }

    public int getSize() {
        return size;
    }

    // Вивід вмісту списку
    public void print() {
        if (isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.print("Список [" + size + " елем.]: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }
}


// ============================================================
// РІВЕНЬ 2 — Стек зі ЗВ'ЯЗАНИМ способом розміщення
// Вузол зв'язаного стеку
// ============================================================
class StackNode {
    String data;        // рядок з числом у вісімковій системі
    StackNode next;     // посилання на наступний вузол

    public StackNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedStack {

    private StackNode top;   // вершина стеку (null якщо стек порожній)

    public LinkedStack() {
        top = null;
    }

    // Перевірка: стек порожній?
    public boolean isEmpty() {
        return top == null;
    }

    // Перевірка коректності вісімкового рядка (лише цифри 0–7)
    private boolean isValidOctal(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '7') return false;
        }
        return true;
    }

    // Вставка елемента на вершину стеку (push)
    // Повертає true якщо успішно, false якщо рядок — не вісімкове число
    public boolean push(String value) {
        if (!isValidOctal(value)) {
            System.out.println("Помилка: \"" + value
                    + "\" — не є додатнім числом у вісімковій системі!");
            return false;
        }
        StackNode newNode = new StackNode(value);
        newNode.next = top;
        top = newNode;
        return true;
    }

    // Видалення елемента з вершини стеку (pop)
    // Повертає видалений елемент або кидає виняток якщо стек порожній
    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній! Неможливо виконати pop.");
        }
        String value = top.data;
        top = top.next;
        return value;
    }

    // Перегляд вершини без видалення (peek)
    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек порожній! Неможливо виконати peek.");
        }
        return top.data;
    }

    // Вивід вмісту стеку від вершини до дна
    public void print() {
        if (isEmpty()) {
            System.out.println("Стек порожній.");
            return;
        }
        System.out.print("Стек (вершина → дно): [ ");
        StackNode current = top;
        while (current != null) {
            System.out.print(current.data + "(8)");
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.println(" ]");
    }
}



