package com.lyj.sc.多线程;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/15:15
 * @Description:
 */
public class CompletableFutureMallDemo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("id"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );

    public static List<String> getPrice(List<NetMall> list,String productName){
        // 《mysql》 int taobao  price 19.43
        return list.stream().map(netMall -> String.format(productName+"in %s price is %.2f",
                netMall.getNetMallName(),netMall.calcPrice(productName))).collect(Collectors.toList());
    }

    /**
     * List<NetMall>----->List<CompletableFuture>---->List<String></>
     * @param list
     * @param productName
     * @return
     */
    public static List<String> getPriceCompletableFuture(List<NetMall> list,String productName){
        // 《mysql》 int taobao  price 19.43
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + "in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName)))).collect(Collectors.toList()).stream()
                .map(s -> s.join())
                .collect(Collectors.toList());
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        List<String> k = getPrice(list, "mysql");
        for (String s : k) {
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime"+(endTime-startTime)+"ms");

        long startTime2 = System.currentTimeMillis();
        k = getPriceCompletableFuture(list, "mysql");
        for (String s : k) {
            System.out.println(s);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("----costTime"+(endTime2-startTime2)+"ms");
    }
}



class NetMall{
    @Getter
    private String netMallName;

    public NetMall(String netMallName){
        this.netMallName=netMallName;
    }

    public double calcPrice(String productName){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble()*2+productName.charAt(0);
    }
}


@AllArgsConstructor
@NoArgsConstructor
@Data
// 链式调用
@Accessors(chain = true)
class Student{
    private Integer id;
    private String studentName;
    private String major;
}
