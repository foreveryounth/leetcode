package _6_ZigZag_Conversion;

public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        //leetcode上numRows = 1时不允许申请内存
        if (numRows >= len || numRows == 1)
            return s;
        char[] charArray = s.toCharArray();
        StringBuilder sBdr = new StringBuilder();

        //读取第一行
        for (int index = 0; index < len; index += 2 * numRows - 2) {
            sBdr.append(charArray[index]);
        }
        //读取第二行到倒数第二行
        for (int i = 1; i < numRows - 1; i++) {
            int gap1 = 2 * numRows - 2 * i - 2, gap2 = 2 * i;
            int index = i;
            while (index < len) {
                sBdr.append(charArray[index]);
                index += gap1;
                if (index >= len) break;
                sBdr.append(charArray[index]);
                index += gap2;
            }
        }
        //读取最后一行
        for (int index = numRows - 1; index < len; index += 2 * numRows - 2) {
            sBdr.append(charArray[index]);
        }
        return sBdr.toString();
    }
}
