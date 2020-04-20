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

package com.github.fenixsoft.bookstore.paymnet.domain;

import com.github.fenixsoft.bookstore.domain.BaseEntity;
import com.github.fenixsoft.bookstore.domain.account.Account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 用户钱包
 *
 * @author icyfenix@gmail.com
 * @date 2020/3/12 16:30
 **/

@Entity
public class Wallet extends BaseEntity {

    public Wallet() {
        // for JPA
    }

    public Wallet(Integer accountId, Double money) {
        setAccountId(accountId);
        setMoney(money);
    }

    // 这里是偷懒，正式项目中请使用BigDecimal来表示金额
    private Double money;

    private Integer accountId;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
