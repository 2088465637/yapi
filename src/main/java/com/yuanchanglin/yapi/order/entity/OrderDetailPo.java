package com.yuanchanglin.yapi.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuanchanglin
 * @since 2023-10-26
 */
@TableName("order_order_detail")
@ApiModel(value="OrderDetailPo对象", description="")
public class OrderDetailPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_detail_id", type = IdType.AUTO)
    private Integer orderDetailId;

    private Integer orderId;

    private Integer goodsId;

    private Float price;

    private Integer count;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderDetailPo{" +
        "orderDetailId=" + orderDetailId +
        ", orderId=" + orderId +
        ", goodsId=" + goodsId +
        ", price=" + price +
        ", count=" + count +
        "}";
    }
}
