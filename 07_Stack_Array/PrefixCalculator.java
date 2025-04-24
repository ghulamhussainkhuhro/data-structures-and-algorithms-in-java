package Array_Stack;

public class PrefixCalculator {

    public PrefixCalculator(String[] expression) {
        StackObj prefixStack = new ArrayStackObj(expression.length);

        for (int i = expression.length - 1; i >= 0; i--) {
            String token = expression[i];

            if (isOperator(token)) {
                double x = Double.parseDouble(prefixStack.pop().toString());
                double y = Double.parseDouble(prefixStack.pop().toString());
                double result = evaluate(x, y, token);
                prefixStack.push(result);
            } else {
                prefixStack.push(Double.parseDouble(token));
            }
        }

        System.out.println("Result: " + prefixStack.pop());
    }

    private boolean isOperator(String token) {
        return "DMAS".contains(token);
    }

    private double evaluate(double x, double y, String operator) {
        switch (operator) {
            case "A":
                return x + y;
            case "S":
                return x - y;
            case "M":
                return x * y;
            case "D":
                return x / y;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String[] expression = {"A", "3", "M", "2", "5"};
        new PrefixCalculator(expression);
    }
}

