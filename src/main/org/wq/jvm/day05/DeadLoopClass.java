package org.wq.jvm.day05;

/**
 * @Author WangQian
 * @Date 2020/10/11 下午 4:34
 */

/**
 * 深入理解java虚拟机-第二版 P226 代码清单 7-7 字段解析
 */
public class DeadLoopClass {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + "start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + "run over");
        };

        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);

        t1.start();
        t2.start();
    }
}
