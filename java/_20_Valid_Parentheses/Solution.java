package _20_Valid_Parentheses;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (len % 2 == 1)
            return false;

        Map<Character, Character> pair = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (Character ch : charArray) {
            if (pair.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || pair.get(stack.pop()) != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "}}()";
        System.out.println(new Solution().isValid(s));
    }
}
