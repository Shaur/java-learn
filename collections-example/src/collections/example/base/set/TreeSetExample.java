package collections.example.base.set;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    /**
     * Внутри TreeSet лежит TreeMap
     * Значения Set помещаются в ключи TreeMap, а значения
     * TreeMap заполняются new Object()
     *
     * Как и в любом Set значения не дублюруются
     * Зато в данном случае мы можем определять алгоритм сортировки значений
     *
     */
    public static void main(String[] args) {
        /**
         * Создаем Set с реализацией TreeSet
         * Set хранит String
         */
        Set<String> set = new TreeSet<>();

        /**
         * Добавляем значения
         */
        set.add("Fst");
        set.add("Snd");
        set.add("Thr");
        set.addAll(Arrays.asList("Four", "Five", "Six"));

        /**
         * Перебор значений. Изначально отсортированы по алфавиту
         * (для чисел - от меньшего к большему)
         */
        for(String value : set) {
            System.out.println(value);
        }

        /**
         * Определяем алгоритм сортировки. Сортируем по hashCode хранимого значения
         */
        set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        set.addAll(Arrays.asList("Zeta", "Tetta", "Alpha", "Beta"));

        for (String value : set) {
            System.out.println(String.format("Value: %s, HashCode: %s", value, value.hashCode()));
        }

        /**
         * В Set нельзя обратиться по индексу (потому что его там нет)
         * зато его можно преобразовать в массив
         */
        Object[] nonTypedArray = set.toArray();

        String[] typedArray = set.toArray(new String[set.size()]);
    }
}
