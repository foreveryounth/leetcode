package _5_longest_palindromic_substring;

public class Solution {
    //暴力枚举所有子串，判断是否是回文串
    //时间复杂度O(n^2)
    public String longestPalindrome(String s) {
        String ans = "";
        int maxlen = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            //考虑到字符串可能只有一个字符
            for (int j = i; j <= len; j++) {
                String str = s.substring(i, j);
                if (maxlen < str.length() && isPalindrome(str)) {
                    maxlen = str.length();
                    ans = str;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //动态规划 dp[i][j] == true 有以下几种情况
    // 1.j - i == 0
    // 2.j - i == 1 && s[i] == s[j]
    // dp[i+1][j-1] && s[i] == s[j]
    public String longestPalindrome2(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        String res = null;
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int l = 1; l <= len; l++) {
            for (int start = 0; start < len; start++) {
                //end - start = l - 1;
                int end = l - 1 + start;
                if (end >= len) {
                    break;
                }

                if (l == 1) {
                    dp[start][end] = true;
                } else if (l == 2) {
                    dp[start][end] = (charArray[start] == charArray[end]);
                } else {
                    dp[start][end] = (charArray[start] == charArray[end] && dp[start + 1][end - 1]);
                }

                if (l > maxLen && dp[start][end]) {
                    res = s.substring(start, end + 1);
                    maxLen = l;
                }
            }
        }
        return res;
    }

    //马拉车算法 Manacher Algorithm
    public String longestPalindrome3(String s) {
        StringBuilder t = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        char[] charArray = t.toString().toCharArray();
        int len = s.length() * 2 + 1;

        //maxRight记录了遍历过的位置的臂长可到达的最右位置，center记录了这个臂长的中心点
        int center = 0, maxRight = 0;
        int[] dp = new int[len];
        //保存结果使用
        int resStart = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            int mirror = Math.max(2 * center - i, 0);
            if (i < maxRight) {
                dp[i] = Math.min(dp[mirror], maxRight - i);
            }
            //从i的左边一个和右边一个开始比较
            int left = i - dp[i] - 1, right = i + dp[i] + 1;
            while (left >= 0 && right < len && charArray[left] == charArray[right]) {
                left--;
                right++;
                dp[i]++;
            }
            //更新maxRight和center
            if (maxRight < dp[i] + i) {
                maxRight = dp[i] + i;
                center = i;
            }
            //更新结果
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                resStart = (i - maxLen) / 2;
            }
        }
        return s.substring(resStart, resStart + maxLen);
    }
}

