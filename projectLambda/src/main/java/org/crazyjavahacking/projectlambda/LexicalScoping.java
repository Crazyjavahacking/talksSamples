package org.crazyjavahacking.projectlambda;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class LexicalScoping {
    
    private Runnable lambda1 = () -> { System.out.printf("lambda1: %s%n", this); };
    private Runnable lambda2 = () -> { System.out.printf("lambda2: %s%n", toString()); };
    
    private Runnable anonymousInnerClass1 = new Runnable() {
        @Override
        public void run() {
            System.out.printf("anonymousInnerClass1: %s%n", this);
        }
    };
    private Runnable anonymousInnerClass2 = new Runnable() {
        @Override
        public void run() {
            System.out.printf("anonymousInnerClass2: %s%n", toString());
        }
    };
   
    public static void main(String... args) {
        new LexicalScoping().lambda1.run();
        new LexicalScoping().lambda2.run();
        
        new LexicalScoping().anonymousInnerClass1.run();
        new LexicalScoping().anonymousInnerClass2.run();
        
        {
//            Object args;
            Object lambda1;
        }
        
        Runnable lambda = () -> {
//            Object args;
            Object lambda1;
        };
    }
    
    @Override
    public String toString() {
        return "Hello world";
    }
}