package com.atguigu.bean;

/**
 * @Author chenxin
 * @date 2022/3/16
 * @Version 1.0
 * 功能：购物项的类
 */
public class CartItem {
    private Book book;//书的图片、名字、单价book对象内都存在
    private Integer count; //这本书在购物车中的数量
    private Double amount;  //这本书在购物车中的金额(可以通过运算算出来的book.getPrice()*count)

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        //设置图书的时候，计算金额
        this.amount=this.book.getPrice()*this.count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        //设置数量，将amount算出来
        this.amount=book.getPrice()*this.count;
    }

    public Double getAmount() {
        return amount;
    }
    //不需要
    /*public void setAmount(Double amount) {
        this.amount = amount;
    }*/

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
        //有参构造器，计算amount
        this.amount=book.getPrice()*this.count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }
}
