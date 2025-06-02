package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.WhileClosure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Closure;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class functors_WhileClosure_execute_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testExecuteWithLoop() {
        // Arrange
        Predicate<Object> predicate = mock(Predicate.class);
        Closure<Object> closure = mock(Closure.class);
        WhileClosure<Object> whileClosure = new WhileClosure<>(predicate, closure, true);
        
        Object input = new Object(); // Input that satisfies the predicate

        // Ensure the predicate returns true for the input
        when(predicate.test(input)).thenReturn(true);

        // Act
        whileClosure.execute(input);

        // Assert
        verify(closure, atLeastOnce()).execute(input); // Verify that closure was executed
        verify(predicate, atLeastOnce()).test(input); // Verify that predicate was tested
    }

    @Test(timeout = 4000)
    public void testExecuteWithoutLoop() {
        // Arrange
        Predicate<Object> predicate = mock(Predicate.class);
        Closure<Object> closure = mock(Closure.class);
        WhileClosure<Object> whileClosure = new WhileClosure<>(predicate, closure, true);
        
        Object input = new Object(); // Input that does not satisfy the predicate

        // Ensure the predicate returns false for the input
        when(predicate.test(input)).thenReturn(false);

        // Act
        whileClosure.execute(input);

        // Assert
        verify(closure, never()).execute(input); // Verify that closure was not executed
        verify(predicate, times(1)).test(input); // Verify that predicate was tested once
    }


}