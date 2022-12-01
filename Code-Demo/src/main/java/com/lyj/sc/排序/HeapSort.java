package com.lyj.sc.排序;

import java.util.Arrays;

/**
 * @Author: liyangjing
 * @Date: 2022/03/21/11:08
 * @Description:
 */
public class HeapSort {

    public static void main(String[] args) {
        //堆排序原理：堆排序是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
        //大顶堆：arr[i]>=arr[i*2+1]&&arr[i]>=arr[i*2+2]
        //小顶堆：arr[i]<=arr[i*2+1]&&arr[i]<=arr[i*2+2]
        int[] arr = {4,21,5,86,74,12,57,42};
        //求出最大的非叶子节点的索引
        int startIndex=(arr.length-1)/2;
        //循环开始调，最大的非叶子节点多大，则循环几次，从最大的非叶子节点开始调
        for (int i = startIndex; i >=0; i--) {
            toMaxheap(arr,arr.length,i);
        }
        //以上的运行结果已经达到大顶堆的效果，此时只需将根节点的元素与最后一个叶子节点的元素互换就行，并递归将剩余元素继续转化成大顶堆
        for (int i = arr.length-1; i > 0; i--) {
            int t=arr[i];
            arr[i]=arr[0];
            arr[0]=t;
            //将剩余元素继续转化为大顶堆结构
            toMaxheap(arr,i,0);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr   //要进行排序的数组
     * @param size  //要排序的范围
     * @param startIndex  //起始的索引位置
     */
    private static void toMaxheap(int[] arr, int size, int startIndex) {
        //求出左右节点的索引
        int leftNodeIndex=startIndex*2+1;
        int rightNodeIndex=startIndex*2+2;
        //假设刚开始最大数的索引就是起始索引
        int maxIndex=startIndex;
        //求出最大节点所对应的索引
        if(leftNodeIndex<size&&arr[leftNodeIndex]>arr[maxIndex]){
            maxIndex=leftNodeIndex;
        }
        if(rightNodeIndex<size&&arr[rightNodeIndex]>arr[maxIndex]){
            maxIndex=rightNodeIndex;
        }
        //调换位置，将最大节点放在大顶堆的根节点处
        if(maxIndex!=startIndex){
            int t=arr[startIndex];
            arr[startIndex]=arr[maxIndex];
            arr[maxIndex]=t;
            //互换完之后可能会影响最大节点以下的大顶堆结构，所以这里需要递归调用方法，保证每个子树都是大顶堆结构
            toMaxheap(arr,size,maxIndex);
        }
    }
}
