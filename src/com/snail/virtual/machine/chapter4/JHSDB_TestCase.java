package com.snail.virtual.machine.chapter4;

/**
 * @Author: SnailBBB
 * @Description: staticObj、instanceObj、localObj放在哪里
 * vmOptions:-Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * 命令：没有 尴了个尬了
 * jps -l
 * jhsdb hsdb --pid 16788
 * @Date: 2020/8/29 16:14
 */
public class JHSDB_TestCase {
    static class Test{
    static ObjectHolder staticObj=new ObjectHolder();
    ObjectHolder instanceObj=new ObjectHolder();
        public void foo() {
            ObjectHolder localObj=new ObjectHolder();
            //设置断点
            System.out.println("done");
        }
    }

    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test=new Test();
        test.foo();
    }
}
