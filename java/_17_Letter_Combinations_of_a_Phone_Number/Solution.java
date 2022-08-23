package _17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private  List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        char[] charArray = digits.toCharArray();
        for (char ch : charArray) {
            res = letter(ch, res);
        }
        return res;
    }

    private final Map<Character, String> phoneMap = new HashMap<Character, String>(){{
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
        put('0', "");
    }};

    private List<String> letter(Character number, List<String> ls) {
        List<String> res = new ArrayList<String>();
        char[] charArray = phoneMap.get(number).toCharArray();
        if (ls.isEmpty()){
            for (char ch : charArray) {
                res.add("" + ch);
            }
        } else {
            for (String str : ls) {
                for (char ch : charArray) {
                    res.add(str + ch);
                }
            }
        }
        return res;
    }

}
