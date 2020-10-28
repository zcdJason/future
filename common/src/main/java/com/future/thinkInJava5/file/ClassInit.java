package com.future.thinkInJava5.file;

/**
 * @author Cock-a-doodle-doo!
 */
public class ClassInit {
    private int a ;
    private Object c ;
    private final   Object o;
    private boolean bb = false;

    public ClassInit(int a, Object c, Object o) {
        this.a = a;
        this.c = c;
        this.o = o;
    }

    @Override
    public String toString() {
        return "ClassInit{" +
                "a=" + a +
                ", c=" + c +
                ", o=" + o +
                ", bb=" + bb +
                '}';
    }

    public static void main(String[] args) {
        ClassInit cit = new ClassInit(3, 3, 4);
        System.out.println(cit);
    }
}
