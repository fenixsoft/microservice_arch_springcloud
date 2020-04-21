package com.github.fenixsoft.bookstore.resource.mock;

import com.github.fenixsoft.bookstore.domain.account.Account;
import com.github.fenixsoft.bookstore.domain.security.AccountServiceClient;

import javax.inject.Named;

/**
 * @author icyfenix@gmail.com
 * @date 2020/4/21 16:48
 **/
@Named
public class AccountServiceClientMock implements AccountServiceClient {

    @Override
    public Account findByUsername(String username) {
        if (username.equals("icyfenix")) {
            Account icy = new Account();
            icy.setId(1);
            icy.setUsername("icyfenix");
            icy.setPassword("$2a$10$iIim4LtpT2yjxU2YVNDuO.yb1Z2lq86vYBZleAeuIh2aFXjyoMCM.");
            icy.setName("周志明");
            icy.setTelephone("18888888888");
            icy.setEmail("icyfenix@gmail.com");
            icy.setLocation("唐家湾港湾大道科技一路3号远光软件股份有限公司");
            return icy;
        } else {
            return null;
        }
    }
}
