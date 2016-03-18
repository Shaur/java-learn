package collections.example.base.set;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

    /**
     * LinkedHashSet внутри себя имеет экземпляр LinkedHashMap
     * ключи которого заполняет значениями, а в качестве значений
     * подсовывает ему new Object()
     *
     * Интересный факт - Set отсекает дубликаты значений
     * Почему? Смотри как работает LinkedHashMap
     */
    public static void main(String[] args) {
        /**
         * Создаем Set  с реализацией LinkedHashSet
         */
        Set<String> set = new LinkedHashSet<>();

        /**
         * Добавляем значения
         */
        set.add("Fst");
        set.add("Snd");
        set.add("Thr");
        set.addAll(Arrays.asList("Four", "Five", "Six"));

        /**
         * Вывод значений путем итерирования (перебора) в цикле
         * В данной реализации порядок сохраняется (первый добавленный - первый взятый)
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
