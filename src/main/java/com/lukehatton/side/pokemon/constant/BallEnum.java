package com.lukehatton.side.pokemon.constant;

/**
 * ClassName: BallEnum
 * Description: 精灵球枚举类
 * Author: Zhao Li
 * Date: 2019/1/2 20:02
 * History:
 */
public enum BallEnum {
    POKE_BALL("精灵球", 1),
    GREAT_BALL("超级球", 2),
    ULTRA_BALL("高级球", 3),
    MASTER_BALL("大师球", 4),
    SAFARI_BALL("狩猎球", 5),
    LEVEL_BALL("等级球", 6),
    LURE_BALL("诱饵球", 7),
    MOON_BALL("月亮球", 8),
    FRIEND_BALL("友友球", 9),
    LOVE_BALL("甜蜜球", 10),
    HEAVY_BALL("重量球", 11),
    FAST_BALL("速度球", 12),
    SPORT_BALL("竞赛球", 13),
    NET_BALL("捕网球", 14),
    NEST_BALL("巢穴球", 15),
    REPEAT_BALL("重复球", 16),
    TIMER_BALL("计时球", 17),
    PREMIER_BALL("纪念球", 18),
    LUXURY_BALL("豪华球", 19),
    DIVE_BALL("潜水球", 20),
    DUSK_BALL("黑暗球", 21),
    QUICK_BALL("先级球", 22),
    HEAL_BALL("治疗球", 23),
    CHERISH_BALL("贵重球", 24),
    PARK_BALL("公园球", 25),
    DREAM_BALL("梦境球", 26),
    BEAST_BALL("究极球", 27);

    private String desc;

    private Integer code;

    BallEnum(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public static String getDescByCode(Integer code){
        for (BallEnum value : BallEnum.values()) {
            if (value.code.equals(code)) {
                return value.desc;
            }
        }
        return null;
    }
}
