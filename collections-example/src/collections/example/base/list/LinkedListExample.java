package collections.example.base.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList реализует интерфейс List
 * В основе лежит двунаправленный список Node
 * Внутри Node хранится значение и ссылки на следующий и предыдущий элементы
 */
public class LinkedListExample {

    public static void main(String[] args) {
        /**
         * Создаем List с реализацией LinkedList
         * Внутри хранятся значения типа String
         */
        List<String> list = new LinkedList<>();

        /**
         * Добавляем три значения
         */
        list.add("Fst");
        list.add("Snd");
        list.add("Thr");

        /**
         * Доступ к коллекции может быть реализован по индексу элемента
         * Важно! Стоит помнить, что это двусвязный список, а значит доступ по индексу
         * эмулируется - на самом деле мы пробегаем от начала или от конца (в зависимости от индекса)
         * на i элементов, где i - необходимый индекс
         */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /**
         * Так же можно использовать альтернативную версию for для перебора элементов
         */
        for (String value : list) {
            System.out.println(value);
        }

        /**
         * Удаление может происходить по индексу и по значению
         */
        list.remove(0);
        list.remove("Snd");

        /**
         * Можно добавлять и удалять целыми коллекциями
         */
        list.addAll(Arrays.asList("Four", "Five", "Six"));
        list.removeAll(Arrays.asList("Four", "Five"));
    }
}
