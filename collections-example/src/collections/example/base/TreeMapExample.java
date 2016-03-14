package collections.example.base;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    /**
     * TreeMap хранит данные в бинарном красно-черном дереве
     * но при работы с ним мы этого не поймем
     */
    public static void main(String[] args) {
        /**
         * Map с реализацией TreeMap, у которой клечем является строка
         * а значением некое целое число типа Integer
         */
        Map<String, Integer> tree = new TreeMap<>();

        /**
         * Заполняем значениями. По умолчание значения отсортрованы по ключам в натуральном порядке
         * (строки - по алфавиту, числа - от меньшего к большему)
         * Важно! Сортровка происходит по ключам!
         */
        tree.put("First", 1);
        tree.put("Second", 2);
        tree.put("Third", 3);
        tree.put("Fouth", 4);
        tree.put("Fifth", 5);
        tree.put("Six", 6);

        /**
         * Вывод значений, путем взятия всех значений из Map
         */
        for(Integer value : tree.values()) {
            System.out.println(value);
        }

        /**
         * Вывод значений, путем перебора ключений и получения по ключу его значения
         * @see java.lang.String#format(String, Object...)
         */
        for(String key : tree.keySet()) {
            System.out.println(String.format("Key: %s, Value: %s", key, tree.get(key)));
        }

        /**
         * Вывод путем перебора Entry - внутренних контейнеров Map
         * в которых хранятся ключи и значения
         * @see java.lang.String#format(String, Object...)
         */
        for(Map.Entry entry : tree.entrySet()) {
            System.out.println(String.format("Key: %s, Value: %s", entry.getKey(), entry.getValue()));
        }

        /**
         * Объявляем TreeMap с реализацией интерфейса Comparator
         * в данном случае мы сортируем ключи по hashCode
         * Зачем? Потому что мы можем
         */
        tree = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        tree.put("First", 1);
        tree.put("Second", 2);
        tree.put("Third", 3);
        tree.put("Fouth", 4);
        tree.put("Fifth", 5);
        tree.put("Six", 6);

        /**
         * Вывод с hashCode
         */
        for(String key : tree.keySet()) {
            System.out.println(String.format("Key: %s, Value: %s, HashCode: %s", key, tree.get(key), key.hashCode()));
        }
    }
}
