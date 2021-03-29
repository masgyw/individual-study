# 并发编程

## 线程有哪些基本状态
线程在生命周期中并不是固定处于某一个状态而是随着代码的执行在不同状态之间切换
|状态名称|说明|
|---|---|
|NEW|新建，没有调用start()方法|
|RUNNABLE|运行状态，RUNNING/READY切换|
|BLOCKED|
|WAITING|
|TIME_WAITING|
|TERMINATED|
## 创建线程有几种方式
4种
##

## 1 请说说线程池工作机制  
1）若线程池未到coreSize ，任务直接分配新的线程执行  
2）线程池达到coreSize，任务进入任务等待队列  
3）任务等待队列满，线程数小于maxSize，线程池新增线程执行任务  
4）大于coreSize 的线程数，会在指定时长后停止，回收，最终保持线程池大小为coreSize

## ConcurrentHashMap如何扩容？
