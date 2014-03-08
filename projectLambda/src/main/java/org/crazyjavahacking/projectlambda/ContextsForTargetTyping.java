package org.crazyjavahacking.projectlambda;

import java.util.concurrent.Callable;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class ContextsForTargetTyping {
    // 1.) variable declaration
    private Callable<String> variable = () -> "field";
    
    {
        // 2.) assignment
        variable = () -> "initializer";
    }
    
    // 3.) return statements
    private Callable<Long> method() {
        return () -> 156L;
    }
    
    // 4.) Array initializers
    private Callable[] array = {
        () -> 156L, () -> "", () -> 'C'
    };
    
    private ContextsForTargetTyping(Callable<?> c) {}
    
    private static void staticVoidMethod(Callable<?> c) {}
    

    public static void main(String[] args) {
        // 5.) Method or constructor arguments
        new ContextsForTargetTyping(() -> "");
        staticVoidMethod(() -> (byte) 127);
        
        // 6.) Lambda expression bodies
        staticVoidMethod(() -> {
            Callable<String> c = () -> "coolStuff";
            return c.call();
        });
        
        // 7.) Conditional expressions
        Callable<? extends Number> c = true ? () -> 123
                                            : () -> 123L;
        
        // 8.) Cast expressions
        Object o = (Callable<Long>) () -> 123L;
    }
}
