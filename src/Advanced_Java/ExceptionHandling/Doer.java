package Advanced_Java.ExceptionHandling;

import java.io.NotActiveException;

public class Doer {

    public int doWork() {
        return 1 / 0;
    }

    public Object findStudentByRoll(int roll) throws ClassNotFoundException, NotActiveException, OddNumberException {

        if(roll < 30){
            return new Object();
        }

        if(roll % 2 == 0){
//            throw new NullPointerException();
//            throw new NotActiveException();
            throw new EvenNumberException();
        }

//        throw new ClassNotFoundException(); //red line CTE - checked exception
//        throw new NullPointerException(); // no issue - unchecked exception
//        throw new IndexOutOfBoundsException();
        throw new OddNumberException();
    }
}
