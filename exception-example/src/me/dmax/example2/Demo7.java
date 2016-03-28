package me.dmax.example2;


public class Demo7 {
    public static void main(String[] args) {
        System.out.println(k().toString());
    }

    public static String m(){
        try {
            //System.exit(42);
            return "Hi!";
        } finally {
            System.out.println("finally");
        }
    }

    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

    public static int d() {
        try {
            throw new RuntimeException();
        } finally {
            return 1;
        }
    }

    public static StringBuilder k(){
        StringBuilder value = new StringBuilder("foo");
        try {
            return value;
        } finally {
            value.append("bar");
        }
    }

    public static String g(){
        while(true) {
            try {
                return "foo";
            } finally {
                break;
            }
        }
        return "bar";
    }
}