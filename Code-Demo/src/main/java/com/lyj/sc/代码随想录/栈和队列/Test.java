package com.lyj.sc.代码随想录.栈和队列;

import java.util.*;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-03 16:34
 **/
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c :chars){
            if (c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                Character t = stack.pop();
                if(t!='('){
                    return false;
                }
            }
            if (c==']'){
                if(stack.isEmpty()){
                    return false;
                }
                Character t = stack.pop();
                if(t!='['){
                    return false;
                }
            }
            if (c=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                Character t = stack.pop();
                if(t!='{'){
                    return false;
                }
            }
            stack.push(c);
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(stack.peek()==c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb =  new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if(token.equals("+")){
                int temp = Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                stack.push(String.valueOf(temp));
            } else if(token.equals("-")){
                int temp = -Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                stack.push(String.valueOf(temp));
            } else if(token.equals("*")){
                int temp = Integer.parseInt(stack.pop())*Integer.parseInt(stack.pop());
                stack.push(String.valueOf(temp));
            } else if(token.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int temp =b/a;
                stack.push(String.valueOf(temp));
            }else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1){
            return nums;
        }
        int len = nums.length;
        int [] res = new int[len-k+1];
        Myqueue myqueue = new Myqueue();
        for (int i = 0; i < k; i++) {
            myqueue.add(nums[i]);
        }
        int i=0;
        res[i++]=myqueue.peek();
        for (int j = k; j < len; j++) {
            myqueue.poll(nums[j-k]);
            myqueue.add(nums[j]);
            res[i++]=myqueue.peek();
        }
        return res;
    }

    /**
     * 前k个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return b[1]-a[1];});
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
class Myqueue{
    Deque<Integer> queue;
    public Myqueue(){
        queue = new LinkedList<>();
    }
    public void poll(int val){
        if(!queue.isEmpty()&&queue.peek()==val){
            queue.poll();
        }
    }
    public void add(int val){
        if(!queue.isEmpty() && queue.peekLast()<val){
            queue.removeLast();
        }
        queue.offer(val);
    }

    public int peek(){
        return queue.peek();
    }
}