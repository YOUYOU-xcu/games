package cn.uu710.domain;

public class Cart {
    private Integer id;

    private String proimg;

    private String profullname;

    private Double price;

    private Integer num;

    private Integer users;

    private Integer product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProimg() {
        return proimg;
    }

    public void setProimg(String proimg) {
        this.proimg = proimg == null ? null : proimg.trim();
    }

    public String getProfullname() {
        return profullname;
    }

    public void setProfullname(String profullname) {
        this.profullname = profullname == null ? null : profullname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
}