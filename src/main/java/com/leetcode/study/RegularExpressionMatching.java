package com.leetcode.study;

public class RegularExpressionMatching {

    private enum CharactorType {
        SINGLE_CHARCTOR,
        ANY_SINGLE_CHARACTOR,
        IS_SAME_CHARACTORS,
        ALL_CHARACTORS
    }

    private CharactorType getCharactorType(String s) {
        if(s.length() == 1) {
            if(s.indexOf(".") > -1) return CharactorType.ANY_SINGLE_CHARACTOR;
            return CharactorType.SINGLE_CHARCTOR;
        }else {
            if(s.indexOf(".") > -1) return CharactorType.ALL_CHARACTORS;
            return CharactorType.IS_SAME_CHARACTORS;
        }
    }
}
