package cn.uu710.domain;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 11:55
 */

public class OrderItem {
    private Integer id;
    private Integer orders;
    private Integer product;
    private Integer num;
    private Double  price;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer orders, Integer product, Integer num, Double price) {
        this.id = id;
        this.orders = orders;
        this.product = product;
        this.num = num;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
