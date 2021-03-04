package org.wq.jvm.day04;

/**
 * @Author WangQian
 * @Date 2020/10/10 下午 6:54
 */

/**
 * 长期存活的对象进入老年代
 * VM参数: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:+PrintTenuringDistribution
 * -XX:MaxTenuringThreshold=1 对象晋升老年代的年龄阈值
 */
public class TestAllocation_02 {

    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte[] allocation1 = new byte[_1MB / 4];
        //进入老年代取决于:
        byte[] allocation2 = new byte[4 * _1MB];
        byte[] allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        byte[] allocation4 = new byte[4 * _1MB];
    }
}
