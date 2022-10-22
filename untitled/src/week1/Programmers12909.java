package week1;

import java.util.Stack;

public class Programmers12909 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') stack.pop();
            else stack.push(c);
        }

        return stack.size() == 0 ? true : false;
    }
}
