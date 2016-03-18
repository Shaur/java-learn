package collections.example.base.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    /**
     * Данная реализация хранит данные в виде Ключ - Значение
     * О том, как она устроена лучше посмотрите в презентации или почитайне в интернете
     */
    public static void main(String[] args) {
        /**
         * Создаем Map  с реализацией LinkedHashMap
         * Это означает, что реализация всех методом интерфейса Map
         * будет браться из класса LinkedHashMap
         * В данном случает Ключ будет иметь тип String, а значение - Integer
         */
        Map<String, Integer> map = new LinkedHashMap<>();

        /**
         * Заполняется вот так
         * Сначада указываем ключ, потом значение
         */
        map.put("First", 1);
        map.put("Second", 2);
        map.put("Third", 3);

        /**
         * Возвращаем список значений, проходим по нему и выводим
         * Важно! Список значений будет выводиться в порядке добавления,
         * в отличии от реализации HashMap
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
