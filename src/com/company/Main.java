package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isExpressive(S, word))
                count++;
        }
        return count;
    }

    private boolean isExpressive(String S, String T) {
        if (S.length() < T.length())
            return false;

        int sHead = 0, tHead = 0, sLen = S.length(), tLen = T.length();
        while (sHead < sLen && tHead < tLen) {
            char sChar = S.charAt(sHead), tChar = T.charAt(tHead);
            int sTail = sHead, tTail = tHead;
            while (sTail < sLen && S.charAt(sTail) == sChar)
                sTail++;

            while (tTail < tLen && T.charAt(tTail) == tChar)
                tTail++;

            if (!isExtension(S.substring(sHead, sTail), T.substring(tHead, tTail)))
                return false;

            sHead = sTail;
            tHead = tTail;
        }
        return sHead >= S.length() && tHead >= T.length();

    }

    private boolean isExtension(String extended, String original) {
        if (extended.length() < 3) {
            return extended.equals(original);
        }

        return true;
    }
}