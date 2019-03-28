package com.leetcode.study;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String matchStr = "aa", pattern = "a";
        System.out.println(isMatch(matchStr, pattern));
    }

    public static boolean isMatch(String matchStr, String pattern) {
        int pStartPos = 0, mStartPos = 0;
        String subStr = "";
        while (pStartPos < pattern.length() && mStartPos >= 0 && mStartPos < matchStr.length()) {
            if (++pStartPos <= pattern.length() && pattern.charAt(pStartPos) == '*') {
                subStr = pattern.substring(pStartPos - 1, pStartPos + 1);
                ++pStartPos;
            } else {
                subStr = pattern.substring(pStartPos - 1, pStartPos);
            }
            switch (getCharactorType(subStr)) {
                case SINGLE_CHARCTOR:
                    mStartPos = dealSingleCharctor(matchStr, mStartPos, subStr);
                    break;
                case ANY_SINGLE_CHARACTOR:
                    mStartPos++;
                    break;
                case IS_SAME_CHARACTORS:
                    mStartPos = dealIsSameCharactors(matchStr, mStartPos, subStr);
                    break;
                case ALL_CHARACTORS:
                    return true;
                default:
                    break;
            }
        }
        if (mStartPos == matchStr.length() && pStartPos == pattern.length()) return true;
        return false;
    }

    private static int dealSingleCharctor(String str, int startPos, String pattern) {
        if (str.substring(startPos, startPos + 1).equals(pattern)) return startPos + 1;
        return -1;
    }

    private static int dealIsSameCharactors(String str, int startPos, String pattern) {
        for (; startPos < str.length(); startPos++) {
            if (str.charAt(startPos) != pattern.charAt(0)) break;
        }
        return startPos;
    }

    private enum CharactorType {
        SINGLE_CHARCTOR,
        ANY_SINGLE_CHARACTOR,
        IS_SAME_CHARACTORS,
        ALL_CHARACTORS
    }

    private static CharactorType getCharactorType(String s) {
        if (s.length() == 1) {
            if (s.indexOf(".") > -1) return CharactorType.ANY_SINGLE_CHARACTOR;
            return CharactorType.SINGLE_CHARCTOR;
        } else {
            if (s.indexOf(".") > -1) return CharactorType.ALL_CHARACTORS;
            return CharactorType.IS_SAME_CHARACTORS;
        }
    }
}
