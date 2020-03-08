package com.vulcan.POJO;

import lombok.Data;

import java.util.Map;

@Data
public class ResultObject {
    private Map<String,String>  stringStringMap;
    private int statusCode;
}
