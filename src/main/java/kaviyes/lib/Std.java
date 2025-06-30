package kaviyes.lib;

public class Std {
    
    public static void drawLine(int range, char character) {
        for (int i = 0; i < range; i ++) {
            print("%c", character);
        }
    }

    public static void clear() {
        System.out.print("\033c");
    }

    public static void print(String format) {
        System.out.print(format);
    }

    public static void print(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void newl() {
        System.out.println();
    }

    public static void newl(int range) {
        for (int i = 0; i < range; i++) {
            System.err.println();
        }
    }

}
