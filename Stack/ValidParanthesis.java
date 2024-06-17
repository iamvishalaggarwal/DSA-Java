package Stack;

import java.util.Stack;

public class ValidParanthesis {
    /*
     * opening bracket - push
     * closing bracket - pop
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char removeCh = stack.pop();
                if ((ch == ')' && removeCh == '(') ||
                        (ch == ']' && removeCh == '[') ||
                        (ch == '}' && removeCh == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println("Valid string = " + isValid(str));
    }
}
