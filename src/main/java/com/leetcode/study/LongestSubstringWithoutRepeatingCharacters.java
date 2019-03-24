package com.leetcode.study;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        return getLongestSubstring(s).length();
    }

    private static String getLongestSubstring(String s) {
        int startPos = 0, endPos = 1;
        String result = s.substring(startPos,endPos);
        String tempStr = result;
        char c;
        while(endPos < s.length()) {
            c = s.charAt(endPos);
            if(tempStr.indexOf(c) > -1) {
                if(endPos - startPos > result.length()) {
                    result = s.substring(startPos, endPos);
                }
                startPos += tempStr.indexOf(c) + 1;
            }
            tempStr = s.substring(startPos,++endPos);
        }
        return (result.length() - tempStr.length() >= 0) ? result : tempStr;
    }
}
