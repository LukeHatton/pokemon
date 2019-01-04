package com.lukehatton.side.pokemon;

import com.lukehatton.side.pokemon.entity.CaptureDTO;
import com.lukehatton.side.pokemon.utils.CalculateUtil;
import com.lukehatton.side.pokemon.utils.HtmlGetterUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * ClassName: SimpleTest
 * Description: 简单测试类
 * Author: Zhao Li
 * Date: 2019/1/2 14:24
 * History:
 */
public class SimpleTest {

    @Test
    public void test01() {
        double b = 45.0 / 255;
        System.out.println(b);
    }

    @Test
    public void test02() {
        CaptureDTO dto = new CaptureDTO();
        dto.setMaxHealth(250.0);
        dto.setCurrentHealth(250.0);
        dto.setEnvironment(2.5);
        dto.setBall(2.0);
        dto.setCaptureDegree(3.0 / 255);
        double B = CalculateUtil.calculateB(dto);
        System.out.println("value of B : " + B);
        double G = CalculateUtil.calculateG(B);
        System.out.println("value of G : " + G);
        double captureRate = CalculateUtil.calculateCaptureRate(G);
        System.out.println("capture rate : " + captureRate);
        String percent = CalculateUtil.showInPercent(captureRate, 2);
        System.out.println("百分数表示 : " + percent);
        int time = CalculateUtil.calculateCaptureExpectation(captureRate, 0.8);
        System.out.println("80%期望捕捉率需要的掷球次数 : " + time);

        /* --------------------------------- */
        dto.setEnvironment(5.0);
        double rate = CalculateUtil.calculateCaptureRate(dto);
        String inPercent = CalculateUtil.showInPercent(rate, 2);
        System.out.println("状态变量为5,捕获率 : " + inPercent);
        int expectation = CalculateUtil.calculateCaptureExpectation(rate, 0.8);
        System.out.println("80%期望捕捉率需要的掷球次数 : " + expectation);
    }

    @Test
    public void test03() throws IOException {
        String utl = "https://wiki.52poke.com/wiki/%E7%A7%8D%E6%97%8F%E5%80%BC%E5%88%97%E8%A1%A8%EF%BC%88%E7%AC%AC%E4%B8%83%E4%B8%96%E4%BB%A3%EF%BC%89";
        HtmlGetterUtil.getArticleListFromUrl();
    }

    @Test
    public void test04() throws IOException {
        HtmlGetterUtil.cleanJsonFile("D:\\image\\raceList.json");
    }

}
