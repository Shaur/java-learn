package collections.example.base;


import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    /**
     * Данная реализация хранит данные в виде Ключ - Значение
     * О том, как она устроена лучше посмотрите в презентации или почитайне в интернете
     */
    public static void main(String[] args) {
        /**
         * Создаем Map  с реализацией HashMap
         * Это означает, что реализация всех методом интерфейса Map
         * будет браться из класса HashMap
         * В данном случает Ключ будет иметь тип String, а значение - Integer
         */
        Map<String, Integer> map = new HashMap<>();

        /**
         * Заполняется вот так
         * Сначада указываем ключ, потом значение
         */
        map.put("First", 1);
        map.put("Second", 2);
        map.put("Third", 3);

        /**
         * Возвращаем список значений, проходим по нему и выводим
         * Важно! Список значений может выводиться в произвольном порядке
         * (не в порядке добавления).
         * Причины в реализации HashMap
         */
        for(Integer value : map.values()) {
            System.out.println(value);
        }

        /**
         * Перебор ключей в цикле. Получаем значение по ключу
         * @see java.lang.String#format(String, Object...)
         */
        for(String key : map.keySet()) {
            System.out.println(String.format("Key: %s, Value: %s", key, map.get(key)));
        }

        /**
         * Перебор Entry в цикле.
         * Entry - контейнер, к которм хранится ключ и значение внутри реализации Map
         * Entry является интерфейсом и его реализация зависит от реализации Map
         */
        for(Map.Entry entry : map.entrySet()) {
            System.out.println(String.format("Key: %s, Value: %s", entry.getKey(), entry.getValue()));
        }

    }
}
