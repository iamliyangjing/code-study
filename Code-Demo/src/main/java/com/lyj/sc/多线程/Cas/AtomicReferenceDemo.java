package com.lyj.sc.多线程.Cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: code-random
 * @description: 原子引用类
 * @author: lyj
 * @create: 2022-08-19 19:43
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class User
{
    String userName;
    int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User z3 = new User("zs",22);
        User li4 = new User("li4", 28);
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().userName);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().userName);
    }
}
