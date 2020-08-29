package com.snail.virtual.machine.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: SnailBBB
 * @Description:
 * vmOptions:-Xms100m -Xmx100m -XX:+UseSerialGC
 * @Date: 2020/8/29 16:24
 */
public class OOMObjectTest {

    /**
     * 内存占位符对象，一个OOMObjcet大约占64KB
     */
    static class OOMObject{
        public byte[] placeholder=new byte[64*1024];
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();
        System.out.println("done");
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list=new ArrayList<>();
        for (int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
