package com.snail.virtual.machine.chapter3;

/**
 * @Author: SnailBBB
 * @Description: 对象有限在Eden分配
 * vm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Date 2020/8/28 8:16
 */
public class TestAllocation {
    private static final int _1MB=1024*1024;

    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation(){
        byte[]allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
        //发生一次Minor GC
        allocation4=new byte[4*_1MB];
    }

}
