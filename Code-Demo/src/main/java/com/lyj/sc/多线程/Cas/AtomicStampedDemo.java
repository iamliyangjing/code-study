package com.lyj.sc.多线程.Cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-19 22:13
 **/
@Getter
@Setter
@AllArgsConstructor
class Book{
    private int id;
    private String bookName;
}

/**
 * @author 86183
 */
public class AtomicStampedDemo {

    public static void main(String[] args) {
        Book javabook = new Book(1, "javabook");
        AtomicStampedReference<Book> stampedReference = new AtomicStampedReference<>(javabook,1);
        System.out.println(stampedReference.getReference().getBookName()+"\t"+stampedReference.getStamp());

        Book mysqlBook = new Book(2, "mysqlBook");
        boolean b = stampedReference.compareAndSet(javabook, mysqlBook, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        System.out.println(b+"\t"+stampedReference.getReference().getBookName()+"\t"+stampedReference.getStamp());

        boolean b1 = stampedReference.compareAndSet(mysqlBook, javabook, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        System.out.println(b1+"\t"+stampedReference.getReference().getBookName()+"\t"+stampedReference.getStamp());
    }

}
