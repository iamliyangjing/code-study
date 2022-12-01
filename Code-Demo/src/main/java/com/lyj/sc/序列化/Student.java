package com.lyj.sc.序列化;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-16 09:26
 **/
@Data
public class Student implements Serializable {
    private String id;
    private String name;
}
