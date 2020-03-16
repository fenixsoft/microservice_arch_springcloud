package com.github.fenixsoft.bookstore.domain.warehouse;

/**
 * 待交付商品的状态
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/20 9:52
 **/
public enum DeliveredStatus {

    /**
     * 出库调减库存
     */
    DECREASE,

    /**
     * 入库调增库存
     */
    INCREASE,

    /**
     * 待出库冻结库存
     */
    FROZEN,

    /**
     * 取消出库解冻库存
     */
    THAWED;

}
