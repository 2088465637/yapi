package com.yuanchanglin.yapi.goods.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("goods_goods")
@ApiModel(value="GoodsPo对象", description="")
public class GoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品照片")
    private String imgUrl;

    @ApiModelProperty(value = "商品销量")
    private Integer saleCount;

    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    @ApiModelProperty(value = "原价")
    private Float price;

    @ApiModelProperty(value = "现价")
    private Float nowPrice;

    @ApiModelProperty(value = "分类id")
    private Integer typeId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Float nowPrice) {
        this.nowPrice = nowPrice;
    }
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "GoodsPo{" +
        "goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", imgUrl=" + imgUrl +
        ", saleCount=" + saleCount +
        ", goodsDesc=" + goodsDesc +
        ", price=" + price +
        ", nowPrice=" + nowPrice +
        ", typeId=" + typeId +
        "}";
    }
}
