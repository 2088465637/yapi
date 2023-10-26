package com.yuanchanglin.yapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ycl
 * @since 2018-07-17
 */
@ApiModel("返回状态对象")
public class ResultVo {

    /**
     * 状态列表
     * <p>
     * 状态码
     * 200 执行成功
     * 400 执行失败 知道失败原因
     * 500 执行错误 未知的原因=有异常消息
     * 935 未登录
     */
    /**
     * 响应业务状态码：这里模仿http状态码，200,302,404,500等
     */
    @ApiModelProperty(value="响应业务状态码",name="status",example="200")
    private Integer status;
    /**
     * 响应消息：状态的描述
     */
    @ApiModelProperty(value="响应消息",name="msg",example="OK")
    private String msg;
    /**
     * 响应中的数据
     */
    @ApiModelProperty(value="数据",name="data")
    private Object data;

    public ResultVo() {

    }

    public ResultVo(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo NoApi() {
        return new ResultVo(405,"接口未实现",null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 构建结果
     */
    public static ResultVo buildResult(Integer status, String msg,
                                       Object data) {
        return new ResultVo(status, msg, data);
    }

    /**
     * 成功结果
     */
    public static ResultVo successResult() {
        return new ResultVo(200, "OK", null);
    }
    /**
     * 成功结果
     */
    public static ResultVo successResult(Object data) {
        return new ResultVo(200, "OK", data);
    }
    /**
     * 失败结果
     */
    public static ResultVo failResult(String msg) {
        return new ResultVo(400, msg, null);
    }
    /**
     * 错误结果
     */
    public static ResultVo errorResult(String msg) {
        return new ResultVo(500, msg, null);
    }
    /**
     * 错误结果
     */
    public static ResultVo errorResult() {
        return new ResultVo(500, "该功能有些小小的BUG，后端正在努力修复中", null);
    }

}