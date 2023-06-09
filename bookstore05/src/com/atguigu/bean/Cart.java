package com.atguigu.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenxin
 * @date 2022/3/16
 * @Version 1.0
 */
public class Cart {
    //n个购物项(Map集合或者List集合)
    private Map<Integer,CartItem> map=new HashMap<>();//将书的id作为map的key值
    private Integer totalCount;//购物车的总数量(可以通过map集合运算得到)
    private Double totalAmount;//购物车的总金额(可以通过map集合运算得到)


}
