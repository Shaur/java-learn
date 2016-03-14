package collections.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Как потерять значение в HashMap?
 */
public class HashMapMissing {

    public static void main(String[] args) {
        /**
         * Создаем Map  с реализацией HashMap
         * Ключем будет наш класс
         * @see GeneratedKey
         * значением будет строка
         */
        Map<GeneratedKey, String> map = new HashMap<>();

        /**
         * Создадим экземпляр ключа
         */
        GeneratedKey key = new GeneratedKey("Last", "Last value");

        /**
         * Добавим в Map первое значение
         */
        map.put(new GeneratedKey("First", "Fist value"), "Not missing");

        /**
         * Добавим в Map значение с заранее заготовленным ключем
         */
        map.put(key, "Missing");

        /**
         * Изменим одно из полей ключа. Мы ведь его уже использовали и он нам больше не нужен, не так ли?
         */
        key.setName("Second");

        /**
         * Попытаемся получить второе значение.
         * В java все передается по ссылке, поэтому логично предположить, что ключ изменился внутри Map
         * Кстати, здесь выведется null
         * И по ключу new GeneratedKey("Last", "Last value") тоже
         */
        String value = map.get(new GeneratedKey("Second", "Last value"));
        System.out.println(value);

        /**
         * Здесь все в порядке. Выведется правильное значение
         */
        value = map.get(new GeneratedKey("First", "Fist value"));
        System.out.println(value);

        /**
         * А фокус очень простой. С изменением одного из полей изменился и hashCode всего ключа,
         * а значит мы не можем обнаружить bucket (корзину) c Entry, содержащей ключи и значение
         */
    }
}
