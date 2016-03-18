package collections.example.base.set;

import java.util.HashSet;
import java.util.Set;


public class HashSetExample {

    /**
     * HashSet внутри себя имеет экземпляр HashMap
     * ключи которого заполняет значениями, а в качестве значений
     * подсовывает ему new Object()
     *
     * Интересный факт - Set отсекает дубликаты значений
     * Почему? Смотри как работает HashMap
     */
    public static void main(String[] args) {
        /**
         * Создаем Set с реализацией HashSet
         * Значения данного Set будут типа String
         */
        Set<String> set = new HashSet<>();

        /**
         * Добавляем в него значения
         */
        set.add("Fst");
        set.add("Snd");
        set.add("Snd");
        set.add("Thr");
        set.add("Fst");

        /**
         * Вывод значений путем итерирования (перебора) в цикле
         */
        for(String value : set) {
            System.out.println(value);
        }

        /**
         * В Set нельзя обратиться по индексу (потому что его там нет)
         * зато его можно преобразовать в массив
         */
        Object[] nonTypedArray = set.toArray();

        String[] typedArray = set.toArray(new String[set.size()]);
    }
}
