package com.snail.virtual.machine.chapter3;

/**
 * @Author: SnailBBB
 * @Description: 大对象直接分配进老年代
 * vm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @Date 2020/8/28 9:02
 */
public class TestPretenure {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    private static void testPretenureSizeThreshold() {
        byte[]allocation;
        allocation=new byte[7*_1MB];
    }
}
