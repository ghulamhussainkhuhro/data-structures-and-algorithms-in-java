package Array_Stack;


public class RPNPostfix {

    public RPNPostfix(String[] expression) {
        StackObj rpnStack = new ArrayStackObj(expression.length);

        for (String token : expression) {
            if (isOperator(token)) {
                double y = Double.parseDouble(rpnStack.pop().toString());
                double x = Double.parseDouble(rpnStack.pop().toString());
                double result = evaluate(x, y, token);
                rpnStack.push(result);
            } else {
                rpnStack.push(Double.parseDouble(token));
            }
        }

        System.out.println("Result: " + rpnStack.pop());
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
        String[] expression = {"3", "4", "A", "5", "3", "S", "D", "3", "A"};
        new RPNPostfix(expression);
    }
}

