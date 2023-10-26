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
@TableName("order_order")
@ApiModel(value="OrderPo对象", description="")
public class OrderPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "结束时间")
    private Long endTime;

    @ApiModelProperty(value = "桌子id")
    private Integer deskId;

    @ApiModelProperty(value = "订单状态(1进行中,2结束)")
    private Integer orderStatus;

    @ApiModelProperty(value = "支付状态(0未支付,1已支付)")
    private Integer payStatus;

    @ApiModelProperty(value = "支付方式(1现金,2微信支付,3支付宝)")
    private Integer payMethod;

    @ApiModelProperty(value = "订单金额")
    private Float price;

    @ApiModelProperty(value = "评分")
    private Integer score;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "OrderPo{" +
        "orderId=" + orderId +
        ", createTime=" + createTime +
        ", endTime=" + endTime +
        ", deskId=" + deskId +
        ", orderStatus=" + orderStatus +
        ", payStatus=" + payStatus +
        ", payMethod=" + payMethod +
        ", price=" + price +
        ", score=" + score +
        "}";
    }
}
