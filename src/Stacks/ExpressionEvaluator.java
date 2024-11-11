package Stacks;

import java.util.StringTokenizer;

public class ExpressionEvaluator {
    private MyStack<Character> bracketStack;
    private MyStack<Character> operatorStack;
    private MyStack<Double> numberStack;

    public ExpressionEvaluator(int maxSize) {
        bracketStack = new MyStack<>(maxSize);
        operatorStack = new MyStack<>(maxSize);
        numberStack = new MyStack<>(maxSize);
    }

    public double evaluate(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.equals("(")) {
                bracketStack.push('(');
            } else if (token.equals(")")) {
                if (bracketStack.isEmpty()) {
                    throw new IllegalArgumentException("Unwohlgeformter Ausdruck");
                }
                bracketStack.pop();
                calculateResult();
            } else if (isOperator(token)) {
                operatorStack.push(token.charAt(0));
            } else {
                numberStack.push(Double.parseDouble(token));
            }
        }

        if (!bracketStack.isEmpty()) {
            throw new IllegalArgumentException("Unwohlgeformter Ausdruck");
        }

        return numberStack.pop();
    }

    private void calculateResult() {
        if (operatorStack.isEmpty() || numberStack.isEmpty()) {
            throw new IllegalArgumentException("Unvollständiger Ausdruck");
        }

        char operator = operatorStack.pop();
        double rightOperand = numberStack.pop();
        double leftOperand = numberStack.pop();

        double result;
        switch (operator) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
            default:
                throw new IllegalArgumentException("Ungültiger Operator");
        }

        numberStack.push(result);
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        ExpressionEvaluator evaluator = new ExpressionEvaluator(100);
        String expression = "( ( 50 * 4 ) - ( 2 * ( 32 / 4 ) ) )";
        try {
            double result = evaluator.evaluate(expression);
            System.out.println("Ergebnis: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehlermeldung: " + e.getMessage());
        }
    }
}