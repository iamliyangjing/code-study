package cn.itast.netty.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

import static cn.itast.netty.NIO.ByteBufferUtil.debugAll;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-07 13:31
 **/
@Slf4j
public class ChannelDemo7 {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        AtomicInteger index=new AtomicInteger(0);
        Selector boss = Selector.open();
        SelectionKey bosskey = ssc.register(boss, 0, null);
        bosskey.interestOps(SelectionKey.OP_ACCEPT);
        ssc.bind(new InetSocketAddress(8080));
        Worker[] workers= new Worker[2];
        for (int i = 0; i < workers.length; i++) {
            workers[i]=new Worker("worker-"+i);
        }
        while (true){
            boss.select();
            Iterator<SelectionKey> iter = boss.selectedKeys().iterator();
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                iter.remove();
                if(key.isAcceptable()){
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    log.debug("connected..{}",sc.getRemoteAddress());
                    //2.关联 selector
                    log.debug("before register...{}",sc.getRemoteAddress());
                    workers[index.getAndIncrement()%workers.length].register(sc);
                }
            }
        }

    }

    static class Worker implements Runnable{
        private Thread thread;
        private Selector selector;
        private String name;
        public volatile boolean start=false;

        private ConcurrentLinkedDeque<Runnable> queue = new ConcurrentLinkedDeque<>();
        public Worker(String name){
            this.name=name;
        }

        public void register(SocketChannel sc) throws IOException {
            if(!start) {
                thread = new Thread(this, name);
                thread.start();
                selector = Selector.open();
                start=true;
            }
            //向队列添加任务，并没有执行
            queue.add(()->{
                try {
                    sc.register(selector,SelectionKey.OP_READ,null);
                } catch (ClosedChannelException e) {
                    throw new RuntimeException(e);
                }
            });
            selector.wakeup();//唤醒selector
        }

        @Override
        public void run() {
            while (true){
                try {
                    selector.select();
                    Runnable task = queue.poll();
                    if(task!=null){
                        task.run();
                    }
                    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                    while (iter.hasNext()){
                        SelectionKey key = iter.next();
                        iter.remove();
                        if(key.isReadable()){
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.read(buffer);
                            buffer.flip();
                            debugAll(buffer);
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
