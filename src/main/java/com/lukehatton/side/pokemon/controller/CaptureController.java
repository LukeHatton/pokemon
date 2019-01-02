package com.lukehatton.side.pokemon.controller;

import com.lukehatton.side.pokemon.config.annotation.MultiRequestBody;
import com.lukehatton.side.pokemon.constant.ReturnValueEnum;
import com.lukehatton.side.pokemon.entity.CaptureDTO;
import com.lukehatton.side.pokemon.utils.CalculateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: CaptureController
 * Description: 捕获率计算controller
 * Author: Zhao Li
 * Date: 2019/1/2 14:11
 * History:
 */
@RestController
@RequestMapping("capture")
public class CaptureController {

    /**
     * 计算捕获率和掷球次数期望
     *
     * @param capture 封装捕获率变量入参
     * @return 封装返回值参数
     */
    @RequestMapping("calculate/capture-rate")
    public Map calculateCaptureRate(@MultiRequestBody CaptureDTO capture) {
        if (capture != null) {
            double captureRate = CalculateUtil.calculateCaptureRate(capture);
            String percent = CalculateUtil.showInPercent(captureRate, 2);
            int expectation = CalculateUtil.calculateCaptureExpectation(captureRate, 0.8);
            Map<String, Object> valueMap = ReturnValueEnum.SUCCESS.getReturnValueMap();
            valueMap.put("capturePercent", percent);
            valueMap.put("expectation", expectation);
            return valueMap;
        } else {
            return ReturnValueEnum.FAIL.getReturnValueMap();
        }
    }
}
