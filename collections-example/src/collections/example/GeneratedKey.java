package collections.example;

/**
 * Некий составной ключ для HashMap
 */
public class GeneratedKey {
    private String name;
    private String value;

    public GeneratedKey(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneratedKey that = (GeneratedKey) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;

    }

    /**
     * Переопределяем метод hashCode, чтобы он считался на основе наших двух полей
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeneratedKey{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
