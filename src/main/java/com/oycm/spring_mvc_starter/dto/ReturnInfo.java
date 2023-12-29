package com.oycm.spring_mvc_starter.dto;

import java.util.Map;

/**
 * @author ouyangcm
 * create 2023/12/29 17:01
 */
public class ReturnInfo {

    private int status;
    private String note;
    public Map<String,Object> map;

    public ReturnInfo(){}

    public ReturnInfo(String note){
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static ReturnInfo buildErrorInfo(String errorInfo){
        return new ReturnInfo(errorInfo);
    }
}
