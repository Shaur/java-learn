package collections.example.base.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList реализует интерфейс List
 * В основе лежит массив Object, в котором хранится значение
 */
public class ArrayListExample {

    public static void main(String[] args) {
        /**
         * Создаем List с реализацией ArrayList
         * Внутри хранятся значения типа String
         */
        List<String> list = new ArrayList<>();

        /**
         * Добавляем три значения
         */
        list.add("Fst");
        list.add("Snd");
        list.add("Thr");

        /**
         * Доступ к коллекции может быть реализован по индексу элемента
         */
        for(int i = 0; i < list.size(); i++) {
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
