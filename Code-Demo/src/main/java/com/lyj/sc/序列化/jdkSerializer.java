package com.lyj.sc.序列化;

import java.io.*;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-16 09:25
 **/
public class jdkSerializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setId("123");
        student.setName("lyj");
        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("./test.txt"));
        oss.writeObject(student);
        oss.close();

        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("./test.txt"));
        Student s = (Student)stream.readObject();
        System.out.println(s);
    }
}
