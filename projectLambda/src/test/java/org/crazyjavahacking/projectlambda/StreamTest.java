package org.crazyjavahacking.projectlambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.testng.annotations.Test;

/**
 * @author Martin Skurla crazyjavahacking@gmail.com
 */
public class StreamTest {

    @Test
    public void mappingAndFilteringTheStream_ShouldBeLazyOperation() {
        Collection<String> names =
                Arrays.asList("Anabell", "Barbara", "Bob", "Brian", "Martin");
        
        names.stream()
             .filter(name -> name.length() >= 4)
             .map(name -> {
                 throw new IllegalStateException();
             });
    }
    
    @Test(expectedExceptions = IllegalStateException.class)
    public void collecting_ShouldBeEagerOperation() {
        Collection<String> names =
                Arrays.asList("Anabell", "Barbara", "Bob", "Brian", "Martin");
        
        names.stream()
             .filter(name -> name.length() >= 4)
             .map(name -> {
                 throw new IllegalStateException();
             })
             .collect(Collectors.toList());
    }
}
