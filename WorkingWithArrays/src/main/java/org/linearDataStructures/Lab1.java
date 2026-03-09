package org.linearDataStructures;

public class Lab1 {

    public static void main(String[] args) {

        // ====================================================
        // РІВЕНЬ 1
        // Список (векторний), елементи — int
        // ====================================================
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  РІВЕНЬ 1: Список — векторний спосіб (int)       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        VectorList list1 = new VectorList(10);

        // --- Вставка ---
        System.out.println("\n[ Вставка елементів ]");
        list1.add(15);
        list1.add(-3);
        list1.add(42);
        list1.add(7);
        list1.add(-18);
        list1.add(100);
        list1.add(56);
        list1.print();

        // --- Видалення ---
        System.out.println("\n[ Видалення елементів ]");
        System.out.println("Видаляємо елемент за індексом 0: " + list1.remove(0));
        list1.print();
        System.out.println("Видаляємо елемент за індексом 2: " + list1.remove(2));
        list1.print();
        System.out.println("Видаляємо останній елемент: "
                + list1.remove(list1.getSize() - 1));
        list1.print();


        // ====================================================
        // РІВЕНЬ 2
        // Стек (зв'язаний), елементи — String (вісімкові числа)
        // ====================================================
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║  РІВЕНЬ 2: Стек — зв'язаний спосіб (вісімкові)  ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        LinkedStack stack2 = new LinkedStack();

        // --- Вставка ---
        System.out.println("\n[ Вставка елементів (push) ]");
        stack2.push("17");   // 17(8) = 15(10)
        stack2.push("52");   // 52(8) = 42(10)
        stack2.push("7");    //  7(8) =  7(10)
        stack2.push("144");  // 144(8) = 100(10)
        stack2.push("70");   // 70(8)  = 56(10)
        stack2.push("89");   // ПОМИЛКА: 8, 9 — не вісімкові цифри
        stack2.print();

        // --- Видалення ---
        System.out.println("\n[ Видалення елементів (pop) ]");
        System.out.println("Знятий з вершини: " + stack2.pop() + "(8)");
        stack2.print();
        System.out.println("Знятий з вершини: " + stack2.pop() + "(8)");
        stack2.print();


        // ====================================================
        // РІВЕНЬ 3
        // Перша структура: VectorList (int) з табл. Д1.1
        // Друга структура: LinkedStack (String вісімкові) з табл. Д1.2
        //
        // Завдання: видалити від'ємні елементи зі списку,
        //           решту перетворити у вісімкову систему
        //           та перемістити у стек
        // ====================================================
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║  РІВЕНЬ 3: Обробка двох структур (варіант 7)     ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        VectorList firstList = new VectorList(15);
        firstList.add(25);
        firstList.add(-7);
        firstList.add(64);
        firstList.add(-12);
        firstList.add(8);
        firstList.add(33);
        firstList.add(-5);
        firstList.add(100);
        firstList.add(16);
        firstList.add(-30);

        LinkedStack secondStack = new LinkedStack();

        System.out.println("\n[ Початковий стан ]");
        System.out.print("Перша структура  → ");
        firstList.print();
        System.out.print("Друга структура  → ");
        secondStack.print();

        // --- Обробка ---
        System.out.println("\n[ Обробка: видалення від'ємних, решта → вісімкова у стек ]");
        int i = 0;
        while (i < firstList.getSize()) {
            int value = firstList.get(i);
            if (value < 0) {
                firstList.remove(i);
                System.out.println("  Видалено від'ємний: " + value);
                // індекс не збільшуємо — елемент зсунувся на це місце
            } else {
                String octal = Integer.toOctalString(value);
                secondStack.push(octal);
                firstList.remove(i);
                System.out.println("  Переміщено " + value
                        + "(10) → " + octal + "(8) → у стек");
                // індекс не збільшуємо
            }
        }

        System.out.println("\n[ Результат ]");
        System.out.print("Перша структура  → ");
        firstList.print();
        System.out.print("Друга структура  → ");
        secondStack.print();
    }
}



