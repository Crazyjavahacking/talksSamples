package org.crazyjavahacking.projectlambda;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class LambdaExpressionsAndClosures {
    private static String val = "1";
    
    private static Runnable lambda = () -> System.out.println("current value of val: " + val);
    
    
    public static void main(String[] args) {
        lambda.run(); // prints 1
        
        val = "2";
        lambda.run(); // prints 2
        
        String val = "3";
        lambda.run(); // still prints 2
    }
}
