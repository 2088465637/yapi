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
@TableName("goods_type")
@ApiModel(value="TypePo对象", description="")
public class TypePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类id")
    private Integer typeId;

    @ApiModelProperty(value = "分类名称")
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypePo{" +
        "typeId=" + typeId +
        ", typeName=" + typeName +
        "}";
    }
}
