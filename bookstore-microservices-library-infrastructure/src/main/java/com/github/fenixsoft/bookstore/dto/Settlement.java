/*
 * Copyright 2012-2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. More information from:
 *
 *        https://github.com/fenixsoft
 */

package com.github.fenixsoft.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.fenixsoft.bookstore.domain.warehouse.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Map;

/**
 * 支付结算单模型
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/12 11:35
 **/
public class Settlement {

    @Size(min = 1, message = "结算单中缺少商品清单")
    private Collection<Item> items;

    @NotNull(message = "结算单中缺少配送信息")
    private Purchase purchase;

    /**
     * 购物清单中的商品信息
     * 基于安全原因（避免篡改价格），改信息不会取客户端的，需在服务端根据商品ID再查询出来
     */
    public transient Map<Integer, Product> productMap;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }




}
