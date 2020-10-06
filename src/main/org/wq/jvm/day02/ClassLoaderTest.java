package org.wq.jvm.day02;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取其上层：扩展类加载器
        ClassLoader extLoader = systemClassLoader.getParent();
        System.out.println(extLoader);

        //获取引导类加载其：获取不到
        ClassLoader bootLoader = extLoader.getParent();
        System.out.println(bootLoader);

        //对于用户自定义类来说: 默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);


        //String类使用引导类加载器进行加载的 ----> java的核心类库使用的是引导类加载器加载的
        System.out.println(String.class.getClassLoader());
    }
}
