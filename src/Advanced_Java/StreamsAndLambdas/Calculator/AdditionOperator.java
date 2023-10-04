package Advanced_Java.StreamsAndLambdas.Calculator;

public class AdditionOperator implements MathOperator {

    @Override
    public int operate(int one, int two) {
        return one + two;
    }
}
