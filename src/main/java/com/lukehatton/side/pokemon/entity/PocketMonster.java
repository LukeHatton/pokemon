package com.lukehatton.side.pokemon.entity;

import java.util.Objects;

/**
 * ClassName: PocketMonster
 * Description: 精灵实体类
 * Author: Zhao Li
 * Date: 2019/1/4 11:32
 * History:
 */
public class PocketMonster {

    //精灵编号
    private String id;

    //精灵名称
    private String name;

    //自身属性
    private String attribute;

    //HP
    private String hp;

    //物攻
    private String attack;

    //物防
    private String defence;

    //特攻
    private String spAttack;

    //特防
    private String spDefense;

    //速度
    private String speed;

    //种族捕获度
    private String captureDegree;

    public PocketMonster() {
    }

    public PocketMonster(String id, String name, String attribute, String hp, String attack, String defence, String spAttack, String spDefense, String speed, String captureDegree) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.captureDegree = captureDegree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefence() {
        return defence;
    }

    public void setDefence(String defence) {
        this.defence = defence;
    }

    public String getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(String spAttack) {
        this.spAttack = spAttack;
    }

    public String getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(String spDefense) {
        this.spDefense = spDefense;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCaptureDegree() {
        return captureDegree;
    }

    public void setCaptureDegree(String captureDegree) {
        this.captureDegree = captureDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PocketMonster that = (PocketMonster) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                attribute.equals(that.attribute) &&
                hp.equals(that.hp) &&
                attack.equals(that.attack) &&
                defence.equals(that.defence) &&
                spAttack.equals(that.spAttack) &&
                spDefense.equals(that.spDefense) &&
                speed.equals(that.speed) &&
                captureDegree.equals(that.captureDegree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attribute, hp, attack, defence, spAttack, spDefense, speed, captureDegree);
    }
}
