package org.crazyjavahacking.projectlambda;

import java.util.concurrent.Callable;
import java.util.function.IntBinaryOperator;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class LambdaConversion {
    
    Runnable bulkyAnnonymousInnerClass = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello annonymous inner class :(");
        }
    };
   
    private static void simpleLambdaConversion() {
        Runnable lambda = () -> System.out.println("Hello Lambda :)");
        
        lambda.run();
    }
    
//    private static void illegalLambdaConversion() {
//        Runnable lambda = () -> throw new IllegalStateException();
//        
//        lambda.run();
//    }
    
    private static void blockLambdaConversion() {
        Runnable lambda = () -> {
            throw new IllegalStateException();
        };
        lambda.run();
    }
    
    private static void simpleLambdaConversionWithReturn() throws Exception {
        Callable<?> lambda = () -> 123L;
        
        lambda.call();
    }
    
    private static void blockLambdaConversionWithReturn() throws Exception {
        Callable<?> lambda = () -> {
            return 123L;
        };
        lambda.call();
    }
    
    private static void lambdaWithArguments() {
        IntBinaryOperator plusOperation          = (int i, int j) -> i + j;
        IntBinaryOperator plusOperationShortened = (i, j) -> i + j;
    }
}
