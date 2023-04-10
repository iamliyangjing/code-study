package com.example.jvmdemo;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-28 22:48
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("启动类加载器");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}
