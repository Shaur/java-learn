package collections.example.base;

/**
 * Данный класс будет работать с типом X, являющимся насдеником Number
 * Generics принято обозначать одной заглавной буквой
 * Обычно этого достаточно, но никто не мешает называть их как обчные переменные
 * Как работает данный класс см.
 * @see GenericsExample#main(String...)
 *
 * @param <X> тип, с которым будет работать класс
 */
public class ArraysEx<X extends Number> {

    /**
     * Метод для форматированного вывода чисел типа X
     *
     * @param numbers массив чисел типа X
     */
    public void numericPrint(X... numbers) {
        System.out.print("Numbers: ");
        for (Number s : numbers) {
            System.out.print(String.format("%s ", s));
        }

        System.out.println();
    }

    /**
     * В рамках одноко класса мы можем работать с несколькими дополнительными типами
     * Например в данном методе мы берем некий тип T, который может быть любым
     * Однако такая запись гарантирует, что массив array, переменные find и replace
     * будут одного типа, а значит исключен ClassCastException
     *
     * @param find значение, которое требуется заменить
     * @param replace значение, на которое будем менять
     * @param array массив, в котором нужно найти и заменить значение
     * @param <T> тип данных
     * @return массив с замененными значениями
     */
    public static <T> T[] findAndReplace(T find, T replace, T... array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(find))
                array[i] = replace;
        }

        return array;
    }
}
