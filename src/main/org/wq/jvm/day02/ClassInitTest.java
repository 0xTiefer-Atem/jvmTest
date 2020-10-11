package org.wq.jvm.day02;


//有static修饰时，jvm才会生成<clinit>()方法，没有就不会生成
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
//        System.out.println(number);//报错：非法的前向引用
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
