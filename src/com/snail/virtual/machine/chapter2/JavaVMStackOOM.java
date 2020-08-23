package com.snail.virtual.machine.chapter2;

/**
 * @Author: SnailBBB
 * @Description: 创建线程导致内存溢出异常 VM Args/options:-Xss2M
 * @Date: 2020/8/23 10:15
 * 谨慎执行，系统假死
 *
 *
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){}
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(new Runnable(){
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
