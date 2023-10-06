package Advanced_Java.ExceptionHandling;

import java.io.NotActiveException;
import java.util.concurrent.ExecutionException;

public class Client {
    // case where client is not throwing NotActiveException but warns that it can throw such an exception - show that too
    public static void main(String[] args) throws ClassNotFoundException, NotActiveException, OddNumberException {
        Doer doer = new Doer();
//        doer.doWork();

//        doer.findStudentByRoll(34);

//        ErrorDoer errorDoer = new ErrorDoer();
//        errorDoer.doBad(1);

        try {
            doer.findStudentByRoll(34);
        }
//        catch (Exception ex){
//            System.out.println("Exception");
//        }
        catch (ClassNotFoundException ex){
            System.out.println("ClassNotFound exception"); // remove this from method as we wont throw this error
        }catch (EvenNumberException ex){
            System.out.println("EvenNumberException exception");
        }catch (OddNumberException ex){
            System.out.println("OddNumberException exception");
        }
        finally {
            System.out.println("finally do this");
        }

        System.out.println("printing after catch");
    }
    // inheritance in exception always go child to parent otherwise child will never be catched and exception there
}
