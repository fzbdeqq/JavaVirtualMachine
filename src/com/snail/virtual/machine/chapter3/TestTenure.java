package com.snail.virtual.machine.chapter3;

/**
 * @Author: SnailBBB
 * @Description:长期存活的对象将进入老年代
 * vm options:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * minor GC后仍然存活并且能被Survivor容纳的话，该对象会被移动到Survivor空间中，切将对象年龄设置为1岁，年龄增加到一定程度(15默认)，晋升到老年代中
 * -XX:MaxTenuringThreshold=1 对象晋升老年代年龄阈值
 * @Date 2020/8/28 8:49
 */
public class TestTenure {
    private final static int _1MB=1024*1024;
    public static void main(String[] args) {
//        testTenuringThreshold();
        testTenuringThreshold2();
    }

    /**
     * 动态对象年龄判定
     */
    private static void testTenuringThreshold2() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[_1MB/4];
        allocation2=new byte[_1MB/4];
//        allocation1、allocation2大于Survivo空间一半
        allocation3=new byte[4*_1MB];
        allocation4=new byte[4*_1MB];
        allocation4=null;
        allocation4=new byte[4*_1MB];
    }

    private static void testTenuringThreshold() {
        byte[]allocation1,allocation2,allocation3;
//        -XX:MaxTenuringThreshold=1 对象晋升老年代年龄阈值
        allocation1=new byte[_1MB / 4];
        allocation2=new byte[4*_1MB];
        allocation3=null;
        allocation3=new byte[4*_1MB];

    }

}
