package Advanced_Java.StreamsAndLambdas.Calculator;

public class Client {
    public static void main(String[] args) {
//        MathOperator addition = new AdditionOperator();

//        MathOperator addition = (one, two) -> {
//            return one + two;
//        };

        MathOperator addition = (one, two) -> one + two;
        MathOperator subtraction = (one, two) -> one - two;
        MathOperator multiply = (one, two) -> one * two;
        MathOperator division = (one, two) -> one / two;

        System.out.println(addition.operate(2, 3));
    }
}
