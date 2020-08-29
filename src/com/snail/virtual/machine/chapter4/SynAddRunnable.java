package com.snail.virtual.machine.chapter4;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/8/29 16:50
 */
public class SynAddRunnable implements Runnable {
    int a,b;
    public SynAddRunnable(int a, int b) {
        this.a=a;
        this.b=b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a+b);
            }
        }
    }

    public static void main(String[] args) {
        //200个线程去分别计算1+2以及2+1的值
        for (int i=0;i<100;i++){
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }
}
