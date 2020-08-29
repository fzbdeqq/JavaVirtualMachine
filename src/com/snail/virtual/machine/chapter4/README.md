##chapter 4 虚拟机性能监视、故障处理工具
JPS [OPTIONS] [hostid]

options:

-q:只输出LVMID，省略主类的名称

-m：输出虚拟机进程启动时传递给main()函数的参数

-l：输出主类的全名，如果进程执行的是JAR包，则输出JAR路径

-v：输出虚拟机进程启动时的JVM参数


列出种族运行的虚拟机进程并显示虚拟机执行主类名称及这些进程的本地虚拟机唯一ID

jstat：虚拟机统计信息监视工具(JVM Statistics Monitoring Tool)
用于监视（本地或远程）虚拟机各种运行状态信息的命令行工具。

jstat [option vmid [interval [s|ms] [count]]]

jstat -gc 2764 250 20

options:

-class:监视类加载、卸载数量、总空间以及类装在所耗费的时间

-gc:监视java堆状况，包括Eden区、2个Survivor区、老年代、永久代的容量，已用空间，垃圾收集时间合计等信息

-gccapacity:输出主要关注java堆各个区域使用到的最大、最小空间

-gcutil:关注已使用空间占总空间的百分比

-gccause:额外输出导致上一次垃圾收集产生的原因

-gcnew:监视新生代垃圾收集状况

-gcnewcapacity:主要关注新生代使用到的最大、最小空间

-gcold:监视老年代垃圾收集状况

-gcoldcapacity:输出老年代使用到的最大、最小空间

-gcpermcapacity:输出永久代使用到的最大、最小空间

-compiler:输出编译器编译过的方法、耗时等信息

-printcompilation:输出已经被即时编译的方法

E：新生代Eden

S0、S1:Survivor0、Survivor1

O:Old

P:permanent

YGC:Young GC

YGCT:Young GC time

FGC:Full GC

FGCT:Full GC Time

GCT: GC Time

jinfo:Java配置信息工具（Configuration Info for Java）

jinfo [option] pid

jinfo -flag 

jmap:java内存映像工具（Memory Map for Java）

jinfo [option] vmid

jmap -dump:format=b,file=exlipse.bin 3500


option:

-dump

-finalizerinfo

-heap

-histo

-permaster

-F

jhat:虚拟机堆转储快照分析工具

jhat eclipse.bin

jstack:java堆栈跟踪工具（Stack Trace for java）

jstack [option] vmid

jstack -l 3500

-F:强制输出线程堆栈

-l：除堆栈外，显示关于锁的附加信息

-m：如果调用到本地方法的话，可以显示C/C++的堆栈

基础工具

jar:
java:
javac:
javadoc:
javah:
javap:
jlink:
jdb:
jdeps:
jdeprscan:

安全：用于程序签名、设置安全测试等

keytool

jarsigner：

policytool:

国际化：用于创建本地语言文件

native2ascii

性能监控和故障处理工具

jps

jstat

jstatd

jinfo

jmap

jhat

jstack

jhsdb

jsadebugd

jcmd

jconsole

jmc

jvisualvm

可视化工具
JCMD、JHSDB

JConsole：java监视与管理控制台

VisualVM:多合-故障处理工具（All-in-One Java Troubleshooting Tool）

JMC:Java Mission Control:可持续在线的监控工具