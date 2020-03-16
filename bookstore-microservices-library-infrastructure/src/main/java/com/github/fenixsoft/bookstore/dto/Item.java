package com.github.fenixsoft.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 结算单中要购买的商品
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/19 22:16
 **/
public class Item {

    @NotNull(message = "结算单中必须有明确的商品数量")
    @Min(value = 1, message = "结算单中商品数量至少为一件")
    private Integer amount;

    @JsonProperty("id")
    @NotNull(message = "结算单中必须有明确的商品信息")
    private Integer productId;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
