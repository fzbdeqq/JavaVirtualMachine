package com.snail.virtual.machine.chapter2;

/**
 * vm args/options:-Xss128k
 * 虚拟机栈和本地方法测试
 * 线程请求的栈深度大于JVM所允许的最大深度
 */
public class JavaVMStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF oom=new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+oom.stackLength);
            e.printStackTrace();
            throw e;
        }

    }
}
