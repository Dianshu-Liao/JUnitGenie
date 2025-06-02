package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class iterators_PeekingIterator_fill__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testFillWhenExhaustedIsFalseAndSlotFilledIsFalse() throws Exception {
        // Arrange
        PeekingIterator<Object> iterator = new PeekingIterator<>(java.util.Collections.emptyIterator());
        Method fillMethod = PeekingIterator.class.getDeclaredMethod("fill");
        fillMethod.setAccessible(true);
        
        // Accessing the private field 'exhausted' using reflection
        java.lang.reflect.Field exhaustedField = PeekingIterator.class.getDeclaredField("exhausted");
        exhaustedField.setAccessible(true);
        
        // Set the initial state
        exhaustedField.setBoolean(iterator, false);
        
        // Act
        fillMethod.invoke(iterator);
        
        // Assert
        assertTrue((Boolean) exhaustedField.get(iterator) == false);
    }

}