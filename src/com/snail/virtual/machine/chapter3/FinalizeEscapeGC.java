package com.snail.virtual.machine.chapter3;

/**
 * @Author: SnailBBB
 * @Description:
 * @Date: 2020/8/23 16:12
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("yes,I am still alive ");
    }
    //只会被系统执行一次，如果对象面临下一次回收，它的finalize()方法不会被再次执行
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        //对象逃脱死亡的最后一次机会
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK=null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,I am dead ");
        }
        System.out.println("---------------------");
        //相同，自救失败
        SAVE_HOOK=null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,I am dead ");
        }
    }
}
