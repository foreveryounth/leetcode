package _7_Reverse_Integer;

public class Solution {
    public int reverse(int x) {
        int num = x;
        int res = 0;
        while (num != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = num % 10;
            num /= 10;
            res = res * 10 + digit;
        }

        return res;
    }
}