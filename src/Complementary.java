import com.wanyi.Stack;


public class Complementary {
    public String solution(String[] statements) {
        // stack1 for operators
        Stack<String> s1 = new NodeStack<>();
        // stack2 for operands
        Stack<String> s2 = new NodeStack<>();

        // for each loop statements
        for (String statement : statements) {
            if (statement.matches("\\d")) {
                s2.push(statement);
            } else if (statement.matches("[\\+\\-\\*\\/]")) {
                s1.push(statement);
            } else if (statement.equals(")")) {
                String right = s2.pop();
                String operator = s1.pop();
                String left = s2.pop();
                s2.push(String.format("(%s %s %s)", left, operator, right));
            }
        }
            // if is number, push to stack2
            // else if is operator, push to stack1
            // else if is right parentheses ")",
            // operands pop as right operand, operators pop as operator, operands pop as left operand
            // push "{left operand} {operator} {right operand}" to stack2

        // return operands as array
        return s2.pop();
    }

    public static void main(String[] args) {
        String[] s = {"1", "+", "2", ")", "*", "3", "-", "4", ")", "*", "5", "-", "6", ")", ")", ")"};
        Complementary complementary = new Complementary();
        String res = complementary.solution(s);
        System.out.println("res = " + res);
    }
}
