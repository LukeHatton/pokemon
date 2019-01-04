package com.lukehatton.side.pokemon.utils;

import com.lukehatton.side.pokemon.entity.CaptureDTO;

/**
 * ClassName: CalculateUtils
 * Description: 计算辅助工具类
 * Author: Zhao Li
 * Date: 2019/1/2 14:18
 * History:
 */
public class CalculateUtil {

    /**
     * 计算捕获率B值
     *
     * @param dto 封装捕获率计算入参
     * @return value of B
     */
    public static double calculateB(CaptureDTO dto) {
        Double maxHealth = dto.getMaxHealth();
        Double currentHealth = dto.getCurrentHealth();
        Double environment = dto.getEnvironment();
        Double ball = dto.getBall();
        Double captureDegree = dto.getCaptureDegree();
        //B=((3∗最大HP−2∗当前HP)∗状态修正∗捕获修正)/(3∗最大HP)∗种族捕获度
        return (3 * maxHealth - 2 * currentHealth) * environment * ball * captureDegree / (3 * maxHealth);
    }

    /**
     * 计算捕获率G值
     *
     * @param B 捕获率B值
     * @return value of G
     */
    public static double calculateG(double B) {
        //G=65535/(((255/B))^(3/16) )
        return 65535.0 / Math.pow((255 / B), 3.0 / 16);
    }

    /**
     * 计算扔一次球的捕获率
     *
     * @param G 捕获率G值
     * @return capture rate
     */
    public static double calculateCaptureRate(double G) {
        return (Math.pow((G / 65535), 3.0)) * 10;
    }

    public static double calculateCaptureRate(CaptureDTO dto) {
        double B = calculateB(dto);
        double G = calculateG(B);
        return calculateCaptureRate(G);
    }

    /**
     * 计算达到期望捕获概率所需要的掷球次数
     *
     * @param captureRate 捕获率
     * @param probability 期望的捕获概率,即60%概率捕获,70%概率捕获这样
     * @return 达到期望捕获概率所需要的掷球次数
     */
    public static int calculateCaptureExpectation(double captureRate, double probability) {
        int time = 0;
        double unCaptureRate = 1.0 - captureRate;
        double currentRate = unCaptureRate;
        while (currentRate >= 1.0 - probability) {
            time++;
            currentRate = currentRate * (unCaptureRate);
        }
        return time;
    }

    /**
     * 用字符串表示的double的百分率形式
     *
     * @param value     value
     * @param precision 保留到百分数小数后几位
     * @return percent represents for the value
     */
    public static String showInPercent(double value, int precision) {
        return ((Double) (value * 100)).toString().substring(0, 2 + precision)+"%";
    }
}
