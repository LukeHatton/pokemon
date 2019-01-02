package com.lukehatton.side.pokemon.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ReturnValueEnum
 * Description: controller返回值枚举类
 * Author: Zhao Li
 * Date: 2019/1/2 14:13
 * History:
 */
public enum ReturnValueEnum {
    //失败
    FAIL("false"),
    //成功
    SUCCESS("true");

    private String returnValue;

    ReturnValueEnum(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public Map<String, Object> getReturnValueMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", returnValue);
        return map;
    }
}
