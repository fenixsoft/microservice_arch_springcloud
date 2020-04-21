package com.github.fenixsoft.bookstore.paymnet;

import com.github.fenixsoft.bookstore.dto.Item;
import com.github.fenixsoft.bookstore.dto.Purchase;
import com.github.fenixsoft.bookstore.dto.Settlement;
import com.github.fenixsoft.bookstore.paymnet.domain.Payment;
import com.github.fenixsoft.bookstore.resource.JAXRSResourceBase;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author icyfenix@gmail.com
 * @date 2020/4/21 17:04
 **/
class PaymentResourceTest extends JAXRSResourceBase {

    private Settlement createSettlement() {
        Settlement settlement = new Settlement();
        Item item = new Item();
        Purchase purchase = new Purchase();
        settlement.setItems(Collections.singletonList(item));
        settlement.setPurchase(purchase);
        item.setAmount(2);
        item.setProductId(1);
        purchase.setLocation("xx rd. zhuhai. guangdong. china");
        purchase.setName("icyfenix");
        purchase.setPay("wechat");
        purchase.setTelephone("18888888888");
        return settlement;
    }

    @Test
    void executeSettlement() {
        final Settlement settlement = createSettlement();
        assertForbidden(post("/settlements", settlement));
        authenticatedScope(() -> {
            Response response = post("/settlements", settlement);
            assertOK(response);
            Payment payment = response.readEntity(Payment.class);
            assertNotNull(payment.getPayId());
        });
    }

    @Test
    void updatePaymentState() {
        final Settlement settlement = createSettlement();
        authenticatedScope(() -> {
            Payment payment = post("/settlements", settlement).readEntity(Payment.class);
            assertOK(patch("/pay/" + payment.getPayId() + "?state=PAYED"));
            assertServerError(patch("/pay/" + payment.getPayId() + "?state=CANCEL"));
            payment = post("/settlements", settlement).readEntity(Payment.class); // another
            assertOK(patch("/pay/" + payment.getPayId() + "?state=CANCEL"));
            assertServerError(patch("/pay/" + payment.getPayId() + "?state=NOT_SUPPORT"));
        });
    }

    @Test
    void updatePaymentStateAlias() {
        Payment payment = authenticatedGetter(() -> post("/settlements", createSettlement()).readEntity(Payment.class));
        assertOK(get(payment.getPaymentLink()));
    }

}
