package com.github.fenixsoft.bookstore.dto;

import javax.validation.constraints.NotEmpty;

/**
 * 结算单中的配送信息
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/19 22:15
 **/
public class Purchase {

    private Boolean delivery = true;

    @NotEmpty(message = "配送信息中缺少支付方式")
    private String pay;

    @NotEmpty(message = "配送信息中缺少收件人姓名")
    private String name;

    @NotEmpty(message = "配送信息中缺少收件人电话")
    private String telephone;

    @NotEmpty(message = "配送信息中缺少收件地址")
    private String location;

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
