package org.wq.jvm.day04;

/**
 * @Author WangQian
 * @Date 2020/10/10 下午 7:15
 */

/**
 * 动态对象年龄判定: 如果在Survivor空间中相同年龄所有对象
 * 大小的总和大于Survivor空间的一半，年龄大于或等于
 * 该年龄的对象就可以直接进入老年代
 * VM参数: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -verbose:gc -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 */
public class TestAllocation_03 {

    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte[] allocation1 = new byte[_1MB / 4];
        //
        byte[] allocation2 = new byte[_1MB / 4];
        byte[] allocation3 = new byte[4 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        byte[] allocation5 = new byte[4 * _1MB];
    }
}
