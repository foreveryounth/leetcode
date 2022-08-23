package _14_Longest_Common_Prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";
        else if (strs.length == 1)
            return strs[0];

        String res = LCP(strs[0], strs[1]);
        for (int i = 1; i < strs.length; i++) {
            res = LCP(res, strs[i]);
        }
        return res;
    }

    private String LCP(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        StringBuilder sbdr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                break;
            sbdr.append(str1.charAt(i));
        }
        return sbdr.toString();
    }
}
