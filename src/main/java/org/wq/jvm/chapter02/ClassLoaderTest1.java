package org.wq.jvm.chapter02;

import java.net.URL;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("启动类加载器");

        //获取BootstrapClassLoader能够加载api的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL u:urls) {
            System.out.println(u.toExternalForm());
        }
    }
}
