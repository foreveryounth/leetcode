package _32_Longest_Valid_Parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] str = s.toCharArray();
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = false;
            }
        }

        int gap = 1, max = 0;
        for (int i = 0; i < len; i++) {
            int j = i + gap;
            if (j > len - 1)
                continue;

            if (str[i] == '(' && str[j] == ')') {
                dp[i][j] = true;
                max = Math.max(max, gap + 1);
            }

        }


        for (gap = 3; gap <= len; gap += 2) {
            for (int i = 0; i < len; i++) {
                int j = i + gap;
                if (j > len - 1) {
                    continue;
                }

                for (int gap2 = 0; gap2 < gap; gap2 += 2) {

                }
                if (str[j] == ')') {
                    if (str[i] == '(' && dp[i + 1][j - 1] || str[j - 1] == '(' && dp[i][j - 2]) {
                        dp[i][j] = true;
                        max = Math.max(max, gap + 1);
                    }
                }
            }
        }
        return max;
    }
}
