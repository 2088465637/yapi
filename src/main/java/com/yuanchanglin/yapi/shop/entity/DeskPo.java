package com.yuanchanglin.yapi.shop.entity;

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
@TableName("shop_desk")
@ApiModel(value="DeskPo对象", description="")
public class DeskPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桌子id")
    private Integer deskId;

    @ApiModelProperty(value = "桌子名称")
    private String deskName;

    @ApiModelProperty(value = "桌子二维码")
    private String deskImg;

    @ApiModelProperty(value = "桌子使用状态")
    private Integer deskStatus;

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }
    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }
    public String getDeskImg() {
        return deskImg;
    }

    public void setDeskImg(String deskImg) {
        this.deskImg = deskImg;
    }
    public Integer getDeskStatus() {
        return deskStatus;
    }

    public void setDeskStatus(Integer deskStatus) {
        this.deskStatus = deskStatus;
    }

    @Override
    public String toString() {
        return "DeskPo{" +
        "deskId=" + deskId +
        ", deskName=" + deskName +
        ", deskImg=" + deskImg +
        ", deskStatus=" + deskStatus +
        "}";
    }
}
