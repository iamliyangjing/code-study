package com.lyj.sc.笔试.航天;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-15 00:21
 **/
public class line {
    public  class Point{
        public int x,y;
    }

    public Point getPoint(){
        return new Point();
    }
}

class T{
    public T(){
        String n = String.valueOf(123);
        int i = Integer.parseInt("21");
        line.Point point = (new line()).getPoint();
    }
}
