package com.leetcode.study;

public class PalindromeNumber {
    public String longestPalindrome(String s) {
        int endPos;
        String result = "";
        for(int startPos = 0;startPos < s.length(); startPos++){
            endPos = s.length();
            if(result.length() >= endPos-startPos) break;
            while(startPos < endPos && !judgeIsPalindrome(s.substring(startPos,endPos))) {
                if(result.length() >= endPos-startPos) break;
                endPos--;
            }
            if(endPos - startPos > result.length())
                result = s.substring(startPos,endPos);
        }
        return result;
    }

    public static boolean judgeIsPalindrome(String s) {
        int startPos = 0,endPos = s.length() - 1;
        while(startPos < endPos) {
            if(s.charAt(startPos) != s.charAt(endPos))
                break;
            startPos++;
            endPos--;
        }
        if(startPos >= endPos) return true;
        return false;
    }
}
