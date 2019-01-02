package com.lukehatton.side.pokemon.entity;

/**
 * ClassName: CaptureDTO
 * Description: 捕获率controller入参封装DTO
 * Author: Zhao Li
 * Date: 2019/1/2 14:14
 * History:
 */
public class CaptureDTO {

    //最大健康
    private Double maxHealth = 220.0;

    //当前健康
    private Double currentHealth = 220.0;

    //状态和环境修正
    private Double environment = 1.0;

    //球修正
    private Double ball = 1.0;

    //种族捕获度
    private Double captureDegree = 45.0 / 255;

    //捕获率期望值
    private Double expectation = 0.8;

    public CaptureDTO() {
    }

    public CaptureDTO(Double maxHealth, Double currentHealth, Double environment, Double ball, Double captureDegree, Double expectation) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.environment = environment;
        this.ball = ball;
        this.captureDegree = captureDegree;
        this.expectation = expectation;
    }

    public Double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Double getEnvironment() {
        return environment;
    }

    public void setEnvironment(Double environment) {
        this.environment = environment;
    }

    public Double getBall() {
        return ball;
    }

    public void setBall(Double ball) {
        this.ball = ball;
    }

    public Double getCaptureDegree() {
        return captureDegree;
    }

    public void setCaptureDegree(Double captureDegree) {
        this.captureDegree = captureDegree / 255.0;
    }

    public Double getExpectation() {
        return expectation;
    }

    public void setExpectation(Double expectation) {
        this.expectation = expectation;
    }
}
