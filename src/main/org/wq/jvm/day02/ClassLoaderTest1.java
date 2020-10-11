package org.wq.jvm.day02;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("启动类加载器");

        //获取BootstrapClassLoader能够加载api的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL u : urls) {
            System.out.println(u.toExternalForm());
        }

        //从上面路径随意选择一个类，验证它的类加载器是谁:  BootStrapClassLoader
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);


        System.out.println("扩展类加载器");
        String extDir = System.getProperty("java.ext.dirs");
        for (String path : extDir.split(":")) {
            System.out.println(path);
        }

        //验证
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
