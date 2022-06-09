import com.wanyi.Stack;

import java.util.HashMap;
import java.util.Map;

public class Parentheses {
    boolean solution(String[] strings) {
        Stack<String> stack = new NodeStack<>();
        Map<String, String> mapping = new HashMap<>();
        mapping.put("]", "[");
        mapping.put("}", "{");
        mapping.put(")", "(");
        for (String s : strings) {
            if ("[".equals(s) || "{".equals(s) || "(".equals(s)) {
                System.out.format("meet \"%s\", push it.\n", s);
                stack.push(s);
            }
            if (mapping.containsKey(s)) {
                String popElement = stack.pop();
                System.out.format("meet \"%s\", get popElement is \"%s\".\n", s, popElement);
                String needElement = mapping.get(s);
                if (!popElement.equals(needElement)) {
                    System.out.println("unmatched.");
                    return false;
                }
                System.out.println("matched.");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        String[] s1 = {"[", "(", ")", "]", "{", "}", "{", "[", "(", ")", "(", ")", "]", "(", ")", "}"};
        String[] s2 = {"[", "(", "]", ")"};
        boolean res1 = parentheses.solution(s1);
        System.out.println("res1 = " + res1);
        boolean res2 = parentheses.solution(s2);
        System.out.println("res2 = " + res2);
    }
}
