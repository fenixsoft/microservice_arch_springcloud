package com.github.fenixsoft.bookstore.account;

import com.github.fenixsoft.bookstore.domain.account.Account;
import com.github.fenixsoft.bookstore.resource.JAXRSResourceBase;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author icyfenix@gmail.com
 * @date 2020/4/6 18:52
 **/
class AccountResourceTest extends JAXRSResourceBase {

    @Test
    void getUserWithExistAccount() {
        Response resp = get("/accounts/icyfenix");
        assertForbidden(resp);
        authenticatedScope(() -> {
            Response resp2 = get("/accounts/icyfenix");
            Account icyfenix = resp2.readEntity(Account.class);
            assertEquals("icyfenix", icyfenix.getUsername(), "should return user: icyfenix");
        });
    }

    @Test
    void getUserWithNotExistAccount() {
        authenticatedScope(() -> assertNoContent(get("/accounts/nobody")));

    }

    @Test
    void createUser() {
        authenticatedScope(() -> {
            Account newbee = new Account();
            newbee.setUsername("newbee");
            newbee.setEmail("newbee@github.com");
            assertBadRequest(post("/accounts", newbee));
            newbee.setTelephone("13888888888");
            newbee.setName("somebody");
            assertNoContent(get("/accounts/newbee"));
            assertOK(post("/accounts", newbee));
            assertOK(get("/accounts/newbee"));
        });
    }

    @Test
    void updateUser() {
        authenticatedScope(() -> {
            Response resp = get("/accounts/icyfenix");
            Account icyfenix = resp.readEntity(Account.class);
            icyfenix.setName("zhouzhiming");
            assertOK(put("/accounts", icyfenix));
            assertEquals("zhouzhiming", get("/accounts/icyfenix").readEntity(Account.class).getName(), "should get the new name now");
        });
    }
}
