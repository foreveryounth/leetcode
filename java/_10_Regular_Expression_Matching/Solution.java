package _10_Regular_Expression_Matching;

public class Solution {
    public boolean isMatch2(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        return isMatchRecursion(sArray, pArray, 0, 0);
    }

    private boolean isMatchRecursion(char[] s, char[] p, int i, int j) {
        return true;
    }

    private boolean isMatchWithIndex(char[] s, char[] p, int i, int j) {
        if (p[j] != '*' && p[j] != '.') {
            return s[i] == p[j];
        } else {
            if (p[j] == '.')
                return true;
            else {
                //'*'
                return s[i] == p[j - 1] || isMatchWithIndex(s, p, i, j + 1);
            }
        }
    }

    public boolean isMatch3(String s, String p) {
        s = ' ' + s;
        p = ' ' + p;
        char[] sAy = (' ' + s).toCharArray();
        char[] pAy = (' ' + p).toCharArray();
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS][lenP];
        dp[0][0] = true;

        for (int i = 0; i < lenS; i++) {
            for (int j = 1; j < lenP; j++) {
                if (pAy[j] != '*' && pAy[j] != '.') {
                    dp[i][j] = sAy[i] == pAy[j] && dp[i - 1][j - 1];
                } else if (pAy[j] == '.') {
                    dp[i][j] = i - 1 >= 0 && dp[i - 1][j - 1];
                } else {
                    //匹配0个前面的字符
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) ||
                            //匹配1个前面的字符、匹配多个前面的字符
                            (i - 1 >= 0 && (sAy[i] == pAy[j - 1] || pAy[j - 1] == '.') && (dp[i - 1][j - 1] || dp[i - 1][j]));
                }
            }
        }
        return dp[lenS - 1][lenP - 1];
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] sAy = s.toCharArray();
        char[] pAy = s.toCharArray();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (pAy[j - 1] == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(sAy, pAy, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(sAy, pAy, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(char[] s, char[] p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p[j - 1] == '.') {
            return true;
        }
        return s[i - 1] == p[j - 1];
    }

    //beats接近100%
    public boolean isMatch4(String s, String p) {
        return recur(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
    }

    public boolean recur(char[] ss, char[] pp, int sidx, int pidx) {
        //结束条件确实恶心,各种idxOutBound
        if (pidx < 0) {
            return sidx == pidx;
        }
        if (sidx < 0) {
            while (pidx >= 0 && pp[pidx] == '*') {//bug_注意:pidx>=0
                pidx -= 2;
            }
            return pidx == sidx;
        }

        //下面逻辑代码不需要考虑idx为负数,就算idx负数,那也是下一个recur去判断.
        if (pp[pidx] != '*') {//不是*好说,要么点,要么字母
            if (pp[pidx] == '.') {//是点,点可以匹配任意,所以直接recur
                return recur(ss, pp, sidx - 1, pidx - 1);
            } else {
                if (pp[pidx] == ss[sidx]) {//s和p的末尾字母,若相同,也是直接recur
                    return recur(ss, pp, sidx - 1, pidx - 1);
                } else {
                    return false;//s和p的末尾字母,不相同直接gg,返false
                }
            }
        } else {
            //根据题意:*匹配0个or多个

            //这是:*匹配0个
            if (recur(ss, pp, sidx, pidx - 2))
                return true;
            //下面是*匹配多个
            char ctemp = pp[pidx - 1];
            int sidxmove = sidx;
            //用p的末尾去匹配s的末尾的1个,2个,3个,4个...不可能匹配掉无限个吧!!用*把ss[0]都匹配掉了应该是极限了
            while (sidxmove >= 0 && (ctemp == '.' || ctemp == ss[sidxmove])) {//用*匹配掉1个,2个,3个,4个...
                if (recur(ss, pp, sidxmove - 1, pidx - 2)) {
                    return true;//加速加速
                }
                sidxmove--;
            }
            return false;//上面加速都不成功,说明没救了
        }
    }
}

