package com.snail.virtual.machine.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: SnailBBB
 * @Description:直接内存
 * VM Args/options: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Date: 2020/8/23 12:00
 */
public class DirectMemoryOOM {
    private static  final int  _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField= Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe= (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
