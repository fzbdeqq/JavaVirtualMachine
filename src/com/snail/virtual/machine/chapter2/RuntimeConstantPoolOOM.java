package com.snail.virtual.machine.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: SnailBBB
 * @Description:VM Args:-XX:PermSize=6M -XX:MaxPermSize=6M
 * 限制永久代的大小，
 * ignoring option PermSize=6M; support was removed in 8.0
 * ignoring option MaxPermSize=6M; support was removed in 8.0
 * JDK8以后，永久代便完全退出了历史舞台，元空间作为替代者登场。
 * -XX:MaxMetaspaceSize=1m 如果MaxMetaspaceSize设置太小，可能会导致频繁FGC，甚至OOM
 * -XX:MinMetaspaceSize=1m
 * -XX:MetaspaceSize=1m  扩容时触发FullGC的初始化阈值，也是最小的阈值。
 * Meta区容量范围为[20.8m, MaxMetaspaceSize)；
 * -XX:MinMetaspaceFreeRatio=
 * @Date: 2020/8/23 11:08
 */
public class RuntimeConstantPoolOOM {
    //todo ?
    public static void main(String[] args) {
        //首次出现时返回引用
        String str1=new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        //不符合首次遇到原则
        String str2=new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
        Set<String> set=new HashSet<>();
        short i=0;
        while (true){
            //如果字符串常量池中已经包含一个等于此String对象的字符串，返回代表池中这个字符串的String对象的引用
            //否则将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。
            set.add(String.valueOf(i++).intern());
        }
    }
}
