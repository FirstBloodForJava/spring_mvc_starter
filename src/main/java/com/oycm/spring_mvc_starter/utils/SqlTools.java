package com.oycm.spring_mvc_starter.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/1/30 16:45
 */
public class SqlTools {

    public final static String ORACLE_GET_TABLE_INFO = "SELECT OWNER, TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_LENGTH, NULLABLE,CHAR_LENGTH FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = '${TABLE_NAME}' ORDER BY COLUMN_ID";

    public final static String ORACLE_DATE = "DATE";
    public final static String ORACLE_CLOB = "CLOB";
    public final static String ORACLE_CHAR = "CHAR";
    public final static String ORACLE_TIMESTAMP = "TIMESTAMP(6)";
    public final static String ORACLE_NUMBER = "NUMBER";
    public final static String ORACLE_FLOAT = "FLOAT";
    public final static String ORACLE_VARCHAR2 = "VARCHAR2";
    public final static String ORACLE_LONG = "LONG";
    public final static String ORACLE_NVARCHAR2 = "NVARCHAR2";

    public static final Map<String,Class> dataType = new HashMap<>();

    static {
        dataType.put(ORACLE_DATE, Date.class);
        dataType.put(ORACLE_CLOB,String.class);
        dataType.put(ORACLE_CHAR,String.class);
        dataType.put(ORACLE_TIMESTAMP,Date.class);
        dataType.put(ORACLE_NUMBER,Integer.class);
        dataType.put(ORACLE_FLOAT, BigDecimal.class);
        dataType.put(ORACLE_VARCHAR2,String.class);
        dataType.put(ORACLE_LONG,Integer.class);
        dataType.put(ORACLE_NVARCHAR2,String.class);
    }

}
