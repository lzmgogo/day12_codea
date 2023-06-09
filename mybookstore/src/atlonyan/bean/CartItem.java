package atlonyan.bean;

import java.math.BigDecimal;

public class CartItem {
    private Book book;
    private Integer count;
    private Double amount;

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
        BigDecimal price=new BigDecimal(this.book.getPrice()+"");
        BigDecimal count1=new BigDecimal(this.count+"");
        this.amount=price.multiply(count1).doubleValue();
    }

    /**
     * 获取
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * 设置
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
        BigDecimal price=new BigDecimal(this.book.getPrice()+"");
        BigDecimal count1=new BigDecimal(this.count+"");
        this.amount=price.multiply(count1).doubleValue();
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
        BigDecimal price=new BigDecimal(this.book.getPrice()+"");
        BigDecimal count1=new BigDecimal(this.count+"");
        this.amount=price.multiply(count1).doubleValue();

    }

    /**
     * 获取
     * @return amount
     */
    public Double getAmount() {
        return amount;
    }

    public String toString() {
        return "CartItem{book = " + book + ", count = " + count + ", amount = " + amount + "}";
    }
}
