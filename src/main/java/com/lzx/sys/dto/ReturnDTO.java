package com.lzx.sys.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by lizhongxiang on
 *
 * @author : lzx
 * 时间 : 2018/5/9.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnDTO<T> {
    /**
     * 状态码
     */
    private Integer returnCode;
    /*********************** 状态码定义 **************************************/
    //成功
    public static final Integer SUCCESS = 200;
    //失败
    public static final Integer FAIL = 500;
    /*********************** 状态码定义 **************************************/

    /**
     * 执行消息
     */
    private String msg;

    /**
     * 数据对象
     */
    private T singleData;

    /**
     * 数据列表
     */
    private List<T> listData;

    public ReturnDTO() {
    }

    public ReturnDTO(Integer returnCode, String msg, T singleData, List<T> listData) {
        this.returnCode = returnCode;
        this.msg = msg;
        this.singleData = singleData;
        this.listData = listData;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getSingleData() {
        return singleData;
    }

    public void setSingleData(T singleData) {
        this.singleData = singleData;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
