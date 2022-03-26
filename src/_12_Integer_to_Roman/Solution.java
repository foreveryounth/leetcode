package _12_Integer_to_Roman;

public class Solution {
    public String intToRoman(int num) {
        if (num == 0) {
            return "0";
        }
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sbdr = new StringBuilder();
        for (int i = 0; i < symbol.length; i++) {
            //注意这里是大于等于等于
            while (num >= val[i]) {
                num -= val[i];
                sbdr.append(symbol[i]);
            }
        }
        return sbdr.toString();
    }
}
