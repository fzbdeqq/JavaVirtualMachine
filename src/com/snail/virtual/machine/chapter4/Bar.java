package com.snail.virtual.machine.chapter4;

/**
 * @Author: SnailBBB
 * @Description:
 * vmOptions:-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontiline, *Bar.sum -XX:Compile-Command=compileonly,*Bar.sum test.Bar
 * @Date: 2020/8/29 21:17
 */
public class Bar {
    int a=1;
    static int b=2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
