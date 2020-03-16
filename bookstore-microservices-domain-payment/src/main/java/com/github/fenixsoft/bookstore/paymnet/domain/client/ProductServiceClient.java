package com.github.fenixsoft.bookstore.paymnet.domain.client;

import com.github.fenixsoft.bookstore.domain.warehouse.DeliveredStatus;
import com.github.fenixsoft.bookstore.domain.warehouse.Product;
import com.github.fenixsoft.bookstore.domain.warehouse.Stockpile;
import com.github.fenixsoft.bookstore.dto.Settlement;
import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 仓库商品和库存相关远程服务
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/19 22:22
 **/
@FeignClient(name = "warehouse")
public interface ProductServiceClient {

    default void replenishProductInformation(Settlement bill) {
        bill.productMap = Stream.of(getProducts()).collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    @GET
    @Path("/restful/products/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Product getProduct(@PathParam("id") Integer id);

    @GET
    @Path("/restful/products")
    @Consumes(MediaType.APPLICATION_JSON)
    Product[] getProducts();

    default void decrease(Integer productId, Integer amount) {
        setDeliveredStatus(productId, DeliveredStatus.DECREASE, amount);
    }

    default void increase(Integer productId, Integer amount) {
        setDeliveredStatus(productId, DeliveredStatus.INCREASE, amount);
    }

    default void frozen(Integer productId, Integer amount) {
        setDeliveredStatus(productId, DeliveredStatus.FROZEN, amount);
    }

    default void thawed(Integer productId, Integer amount) {
        setDeliveredStatus(productId, DeliveredStatus.THAWED, amount);
    }

    @PATCH
    @Path("/restful/products/stockpile/delivered/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    void setDeliveredStatus(@PathParam("productId") Integer productId, @QueryParam("status") DeliveredStatus status, @QueryParam("amount") Integer amount);

    @GET
    @Path("/restful/products/stockpile/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    Stockpile queryStockpile(@PathParam("productId") Integer productId);

}
