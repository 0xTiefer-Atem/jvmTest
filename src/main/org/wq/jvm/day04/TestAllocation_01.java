package org.wq.jvm.day04;

/**
 * @Author WangQian
 * @Date 2020/10/10 下午 5:26
 */

/**
 * 内存回收策略-对象优先在Eden分配
 * VM参数: -XX:+UseParallelOldGC -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class TestAllocation_01 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];//出现一次 Minor GC
    }
}
