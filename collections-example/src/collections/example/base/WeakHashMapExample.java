package collections.example.base;

import java.util.*;

public class WeakHashMapExample {

    /**
     * WeakHashMap работает как HashMap
     * Но есть одно отличие - после сборки мусора его значения удаляются
     */
    public static void main(String[] args) {
        /**
         * Создаем Map у которого ключем является строка, а
         * хранимым значением некое целое числ
         */
        Map<String, Long> map = new WeakHashMap<>();

        /**
         * Заполнем десятью значениями
         */
        for(int i = 0; i < 10; i++) {
            map.put("Key" + i, (long) i);
        }

        /**
         * Насильно вызываем сборку мусора
         * Если закоментировать эту строку, то сбока мусора не произойдет
         * и значения из Map не удалятся
         */
        System.gc();

        /**
         * Проходим по значениям Map и выводим их
         * Если сборка мусора не произошла - значения останутся
         * Если сборка мусора произошла - значений не будет
         */
        for(Long value : map.values()) {
            System.out.println(value);
        }
    }
    
}
