package ru.javalearn.singleton;


public final class LazyInitialization {
    private static volatile LazyInitialization instance;
    private LazyInitialization() { }

    public static LazyInitialization getInstance() {
        if (instance == null ) {
            synchronized (LazyInitialization.class) {
                if (instance == null) {
                    instance = new LazyInitialization();
                }
            }
        }

        return instance;
    }
}
