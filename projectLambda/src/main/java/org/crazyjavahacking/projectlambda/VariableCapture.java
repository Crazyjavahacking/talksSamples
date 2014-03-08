package org.crazyjavahacking.projectlambda;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class VariableCapture {
    
    private static Runnable capturingEffectivelyFinalLocalVariables_isSupported() {
        String s = "";
        return () -> System.out.println(s);
    }
    
    private static Runnable capturingNotEffectivelyFinalLocalVariable_isNotSupported() {
        String s = "a";
//        s = "b";
        return () -> System.out.println(s);
    }
}
