package atlonyan.bean;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DoubleDV;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;

public class Cart {
    private Map<Integer,CartItem> map=new HashMap<>();
    private Integer totalCount;
    private Double totalAmount;
    public void addCart(Book book){
        CartItem cartItem = map.get(book.getBookId());
        if(cartItem==null){
            CartItem cartItem1 = new CartItem(book, 1);
            map.put(book.getBookId(), cartItem1);
        }else {
            cartItem.setCount(cartItem.getCount()+1);
        }
        System.out.println(map);
    }
    public Integer getTotalCount(){
        Collection<CartItem> values = map.values();
        Integer count=0;
        for (CartItem value : values) {
            count+=value.getCount();
        }
        this.totalCount=count;
        return totalCount;
    }
    public Double getTotalAmount(){
        Collection<CartItem> values = map.values();
        BigDecimal total = new BigDecimal("0");
        for (CartItem value : values) {
            BigDecimal amount=new BigDecimal(value.getAmount()+"");
            total=amount.add(total);
        }
        this.totalAmount=total.doubleValue();
        return totalAmount;
    }
    public Collection<CartItem> getAllCartItems(){
        Collection<CartItem> values = map.values();
        return values;
    }
    public void deleteCart(Integer id){
        map.remove(id);
    }
    public void addCount(Integer id) {
        CartItem cartItem = map.get(id);
        cartItem.setCount(cartItem.getCount()+1);
    }
    public void subtractCount(Integer id){
        CartItem cartItem = map.get(id);
        if(cartItem.getCount()>=1){
            cartItem.setCount(cartItem.getCount()-1);
        }
    }
    public void changeCount(Integer id,Integer newCount){
        CartItem cartItem = map.get(id);
        cartItem.setCount(newCount);
    }

}
