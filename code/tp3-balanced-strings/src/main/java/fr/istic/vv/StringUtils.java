package main.java.fr.istic.vv;

import java.util.*;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        if(str.isBlank() || str.isEmpty()) return true;
        Stack<Character> charStack = new Stack<>();
        for (int i=0; i<str.length(); i++){

            if (str.charAt(i) == '{') charStack.push('{');
            else if (str.charAt(i) == '(') charStack.push('(');
            else if (str.charAt(i) == '[') charStack.push('[');

            if (str.charAt(i) == '}') {
                if (charStack.isEmpty()) return false;
                else if (charStack.pop() != '{') return false;
            }
            else if (str.charAt(i) == ')') {
                if (charStack.isEmpty()) return false;
                else if (charStack.pop() != '(') return false;
            }
            else if (str.charAt(i) == ']') {
                if (charStack.isEmpty()) return false;
                else if (charStack.pop() != '[') return false;
            }
        }
        if (!charStack.isEmpty()) return false;
        return true;
    }

}
