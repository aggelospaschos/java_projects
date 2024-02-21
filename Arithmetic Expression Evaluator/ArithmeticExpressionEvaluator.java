import java.util.*;

public class ArithmeticExpressionEvaluator {

    public static void main(String[] args) {
    	
        Solution stackTemplate = new Solution();
        String expression1 = "((2 + 3) * 4)"; // Valid expression
        String expression2 = "((2 + 3) * 4";  // Invalid expression

        if (isValidArithmeticExpression(expression1)) {
            int result = evaluateArithmeticExpression(expression1);
            System.out.println("Result of expression1: " + result);
        } else {
            System.out.println("Expression1 is not well-formed.");
        }

        if (isValidArithmeticExpression(expression2)) {
            int result = evaluateArithmeticExpression(expression2);
            System.out.println("Result of expression2: " + result);
        } else {
            System.out.println("Expression2 is not well-formed.");
        }
    }

    // Utilize the isValid method from the provided Solution class
    public static boolean isValidArithmeticExpression(String expression) {
        Solution stackTemplate = new Solution();
        return stackTemplate.isValid(expression);
    }

    // Utilize the evalRPN method from the provided Solution class
    public static int evaluateArithmeticExpression(String expression) {
        Solution stackTemplate = new Solution();
        String[] tokens = expression.split("\\s+");
        return stackTemplate.evalRPN(tokens);
    }
}
