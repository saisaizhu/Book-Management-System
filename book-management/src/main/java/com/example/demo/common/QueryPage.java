package com.example.demo.common;

import lombok.Data;

import java.util.HashMap;


/**
 * 传送格式
 * "pageSize":
 * "pageNum":
 * "param":{
 *     其他参数
 * }
 */
@Data
public class QueryPage {
    //默认
    private static int PAGE_SIZE=20;
    private static int PAGE_NUM=1;

    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;

    private HashMap param;

}
