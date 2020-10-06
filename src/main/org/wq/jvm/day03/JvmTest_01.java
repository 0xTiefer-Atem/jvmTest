package org.wq.jvm.day03;

/**
 * @Author WangQian
 * @Date 2020/10/6 下午 2:39
 */

import org.omg.CORBA.PRIVATE_MEMBER;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 测试本机直接内存溢出
 * jvm参数: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class JvmTest_01 {
    private static final int _1MB = 1024 * 1024 * 10;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }
}
