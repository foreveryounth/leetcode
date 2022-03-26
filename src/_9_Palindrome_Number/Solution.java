package _9_Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        else if (x < 0 || x % 10 == 0)
            return false;

        int num = x, revertedNum = 0;
        int digit = 0;
        while (num != 0) {
            if (num == revertedNum || num / 10 == revertedNum)
                return true;
            digit = num % 10;
            num /= 10;
            revertedNum = revertedNum * 10 + digit;
        }
        return false;
    }

    public boolean isPalindrome2(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
