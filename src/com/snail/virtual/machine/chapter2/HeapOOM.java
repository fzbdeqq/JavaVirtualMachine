package com.snail.virtual.machine.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args/options:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 堆内存溢出异常测试
 * jvisualvm.exe可以查看堆文件信息
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
