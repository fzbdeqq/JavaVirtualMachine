package com.snail.virtual.machine.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/8/29 16:40
 */
public class JStatTest {

    public static void createBusyThread(){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                //RUNNABLE状态：消耗大量的处理资源
                while (true){
                    ;
                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        //WAITING
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj=new Object();
        createLockThread(obj);
    }
}
