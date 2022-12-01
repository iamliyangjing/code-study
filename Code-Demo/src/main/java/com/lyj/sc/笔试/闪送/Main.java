package com.lyj.sc.笔试.闪送;

import java.util.*;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-25 16:27
 **/
public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        s = s.substring(1, s.length() - 1);
////        System.out.println(s);
//        String[] nums = s.split(",");
//        if(nums.length==0){
//            System.out.println("{}");
//        }
//        int right = nums.length-1;
//        int left = 0;
//        while (left<right){
//            String temp = nums[right];
//            nums[right]=nums[left];
//            nums[left]=temp;
//            left++;
//            right--;
//        }
//        System.out.print("{");
//        int end = nums.length-1;
//        for (int i = 0; i <= end; i++) {
//            System.out.print(nums[i]);
//            if(i!=end){
//                System.out.print(",");
//            }
//        }
//        System.out.print("}");
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
        if(split[1].equals("[]")){
            System.out.println(split[0]);
            return;
        }
        if(split[0].equals("[]")){
            System.out.println(split[1]);
            return;
        }
        String num1 = split[0].substring(1,split[0].length()-1);
        String num2 = split[1].substring(1,split[1].length()-1);
        String[] array1 = num1.split(",");
        String[] array2 = num2.split(",");
        Set<Integer> set = new HashSet<>();
        for (String s1 : array1) {
            set.add(Integer.valueOf(s1));
        }
        for (String s1 : array2) {
            Integer t = Integer.valueOf(s1);
            if(set.contains(t)){
                set.remove(t);
            }else {
                set.add(t);
            }
        }
        int [] result = new int[set.size()];
        int index=0;
        for (Integer integer : set) {
            result[index++]=integer;
        }
        Arrays.sort(result);
        System.out.print("[");
        int end = result.length-1;
        for (int i = 0; i <= end; i++) {
            System.out.print(result[i]);
            if(i!=end){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
