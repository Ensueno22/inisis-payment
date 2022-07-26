package com.pref.core.code;

import lombok.Getter;

@Getter
public enum ApplCardCode {

    HANA(01, "외환카드"),
    LOTTE(03, "롯데카드"),
    HYUNDAI(04, "현대카드"),
    KB(06, "국민카드"),
    BC(11, "BC카드"),
    SAMSUNG(12, "삼성카드"),
    SHINHAN(14, "신한카드"),
    HANMI(15, "한미카드"),
    NH(16, "NH카드"),
    HANA_SK(17, "하나 SK카드"),
    GLOBAL_VISA(21, "글로벌 VISA"),
    GLOBAL_MASTER(22, "글로벌 MASTER"),
    GLOBAL_JCB(23, "글로벌 JCB"),
    GLOBAL_AMEX(23, "글로벌 AMEX"),
    GLOBAL_DINERS(23, "글로벌 DINERS"),
    NAVER(91, "네이버포인트(포인트 100% 사용)"),
    TOSS(93, "토스머니(포인트 100% 사용)"),
    SSG(94, "SSG머니(포인트 100% 사용)"),
    LPOINT(96, "엘포인트(포인트 100% 사용)"),
    KAKAO(97, "카카오머니"),
    PAYCO(98, "페이코(포인트 100% 사용)")
    ;

    private int code;
    private String company;

    ApplCardCode(int code, String company) {
        this.code = code;
        this.company = company;
    }

}
