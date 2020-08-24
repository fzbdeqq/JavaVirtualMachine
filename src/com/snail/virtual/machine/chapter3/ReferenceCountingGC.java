package com.snail.virtual.machine.chapter3;

import java.util.Scanner;

/**
 * @Author: SnailBBB
 * @Description:引用计算算法的缺陷
 * @Date: 2020/8/23 15:38
 */
public class ReferenceCountingGC {

    public Object instance=null;

    private static final  int _1MB=1024*1024;

    private byte[] bigSize=new byte[2*_1MB];

    public static void testGC(){
        ReferenceCountingGC objA=new ReferenceCountingGC();

        ReferenceCountingGC objB=new ReferenceCountingGC();

        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;
        //
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
        Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println(str);
    }

}
