# 并发编程

## 线程有哪些基本状态
线程在生命周期中并不是固定处于某一个状态而是随着代码的执行在不同状态之间切换
|状态名称|说明|
|---|---|
|NEW|新建，没有调用start()方法|
|RUNNABLE|运行状态，RUNNING/READY切换|
|BLOCKED|阻塞|
|WAITING|等待|
|TIME_WAITING|时间等待|
|TERMINATED|结束|
## 创建线程有几种方式
1. Thread 继承
2. 实现Runnable接口
3. 实现Callable接口，通过FutureTask 实现线程
4. 线程池 ExecutorService 管理上面三种方式
## FutureTask 的工作原理
Future接口提供了中断任务，查询任务状态和获取执行结果的能力
- FutureTask 实现RunnableFuture接口，实现了Future接口获取任务结果；实现Runnable接口，可以提交给Executor执行
- FutureTask 内部有int 型state，共有8种状态，NEW/COMPLETING/NORMAL/EXCEPTIONAL/CANCELLED/INTERRUPTING/INTERRUPTED；变量运行线程 runner
- 通过 ExecutorService.submit 方法提交
- 执行流程：
    1. 判断线程是不是没有执行，并且将线程赋值给runner,
    2. 如果Callble对象不为空，且线程没有执行过，那么调用call()方法获取同步获取执行结果
    如果出现异常，调用setException 如果成功调用set将结果插入。唤起等待的线程
    3. 如果是中断的，那么将FutureTask中其他的等待线程状态改为中断

## Synchronized 和 ReentrantLock 区别与联系
相同点：
- 同步锁，保证同时只有一个线程访问
不同点：
- 实现方式：Synchronized 是语言级别的，需要JVM实现；ReentrantLock 是代码级别的
- 用法：Synchronized 可以修饰类/方法/代码块，ReentrantLock 只能修饰代码块，标准形式是try {} finally {}
- 释放锁：Sync 自动释放锁，代码执行结束或异常；ReLock 可以中断；
- 高级功能：ReLock 可以实现非公平锁、条件锁

## 请说说线程池工作机制  
1）若线程池未到coreSize ，任务直接分配新的线程执行  
2）线程池达到coreSize，任务进入任务等待队列  
3）任务等待队列满，线程数小于maxSize，线程池新增线程执行任务  
4）大于coreSize 的线程数，会在指定时长后停止，回收，最终保持线程池大小为coreSize

## ConcurrentHashMap如何扩容？
