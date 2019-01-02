package com.lukehatton.side.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: JumpController
 * Description: 页面跳转controller
 * Author: Zhao Li
 * Date: 2019/1/2 15:16
 * History:
 */
@Controller
@RequestMapping("jump")
public class JumpController {

    @RequestMapping("captureRate")
    public String toCapturePage(){
        return "/html/captureRate.html";
    }
}
