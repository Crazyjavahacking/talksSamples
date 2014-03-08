package org.crazyjavahacking.projectlambda;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public interface DefaultAndStaticInterfaceMethods<E> {
    
    boolean hasNext();
    E next();
    void remove();

    default void skip(int i) {
        // same as:
        // helperSkip(this, i);
        for (; i > 0 && hasNext(); i--) next();
    }
    
    static void helperSkip(DefaultAndStaticInterfaceMethods<?> e, int i) {
        for (; i > 0 && e.hasNext(); i--) e.next();
    }
}
