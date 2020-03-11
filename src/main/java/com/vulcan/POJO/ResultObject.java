package com.vulcan.POJO;

import lombok.Data;

import java.util.Map;

/**
 * <p>
 *     接口返回的对象
 * </p>
 * @author allwayz
 * @since 2020-03-09
 */
@Data
public class ResultObject {

    private Map<String,String>  stringStringMap;

    private int statusCode;

    private String message;
}
