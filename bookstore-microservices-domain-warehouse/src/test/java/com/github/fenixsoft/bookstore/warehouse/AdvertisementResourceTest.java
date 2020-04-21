package com.github.fenixsoft.bookstore.warehouse;

import com.github.fenixsoft.bookstore.resource.JAXRSResourceBase;
import org.junit.jupiter.api.Test;

/**
 * @author icyfenix@gmail.com
 * @date 2020/4/6 23:12
 **/
class AdvertisementResourceTest extends JAXRSResourceBase {

    @Test
    void getAllAdvertisements() {
        assertOK(get("/advertisements"));
    }
}
