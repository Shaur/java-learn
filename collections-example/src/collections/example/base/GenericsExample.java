package collections.example.base;



public class GenericsExample {

    public static void main(String... argv) {
        /**
         * Задаем массив строк и значения (искомое и то, на которое будем заменять)
         * Выводим получившийся массив
         */
        String[] strArray = ArraysEx.findAndReplace("lorem", "ipsum", new String[]{"lorem", "ipsum"});
        for(String str : strArray) {
            System.out.println(str);
        }

        /**
         * Делаем все тоже самое, но с Integer
         * Показываем, какой универсальный код получается с Generics
         */
        Integer[] intArray = ArraysEx.findAndReplace(3, 5, new Integer[]{3, 5, 7, 9, 3});

        /**
         * А вот и наш форматированный вывод пригодился
         */
        (new ArraysEx<Integer>()).numericPrint(intArray);
    }
}
