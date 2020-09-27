package cn.uu710.domain;

import java.util.Date;

public class Product {
    private Integer id;

    private String proname;

    private String prosn;

    private Double proprice;

    private Integer pronum;

    private String proimg;

    private String profullname;

    private String unit;

    private Date createdate;

    private Integer status;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getProsn() {
        return prosn;
    }

    public void setProsn(String prosn) {
        this.prosn = prosn == null ? null : prosn.trim();
    }

    public Double getProprice() {
        return proprice;
    }

    public void setProprice(Double proprice) {
        this.proprice = proprice;
    }

    public Integer getPronum() {
        return pronum;
    }

    public void setPronum(Integer pronum) {
        this.pronum = pronum;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}