package org.wq.jvm.day02;

public class ClinitTest1 {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Child extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        //先加载Father类，在加载Child类
        System.out.println(Child.B);
    }
}
