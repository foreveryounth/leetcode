package _13_Roman_to_Integer;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (len == 1) {
            return map.get(charArray[0]);
        }

        int res = 0, curVal = 0, nextVal = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            curVal = map.get(charArray[i]);
            nextVal = map.get(charArray[i + 1]);
            //注意符号的判断是大于等于
            boolean sign = curVal >= nextVal;
            if (sign) {
                res += curVal;
            } else {
                res -= curVal;
            }
        }
        res += nextVal;
        return res;
    }
}
