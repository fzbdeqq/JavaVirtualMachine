package com.snail.virtual.machine.chapter2;

/**
 * vm args:-Xss128k
 * 虚拟机栈和本地方法测试
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
