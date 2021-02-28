package org.wq.jvm.day02;

public class ClinitTest {
    private int a = 1;
    private static int c = 2;

    public ClinitTest() {
        a = 10;
        int d = 20;
    }

    public static void main(String[] args) {
        int b = 2;
    }
}
