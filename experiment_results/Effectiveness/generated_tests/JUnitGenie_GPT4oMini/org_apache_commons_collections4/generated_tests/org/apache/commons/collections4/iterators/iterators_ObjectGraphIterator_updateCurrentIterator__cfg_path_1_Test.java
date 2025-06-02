package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertNotNull;

public class iterators_ObjectGraphIterator_updateCurrentIterator__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUpdateCurrentIteratorWithNonNullCurrentIterator() {
        // Arrange
        Iterator<Integer> mockIterator = Arrays.asList(1, 2, 3).iterator();
        ObjectGraphIterator objectGraphIterator = new ObjectGraphIterator(mockIterator);

        // Accessing the protected method using reflection
        try {
            java.lang.reflect.Method method = ObjectGraphIterator.class.getDeclaredMethod("updateCurrentIterator");
            method.setAccessible(true);

            // Act
            method.invoke(objectGraphIterator);

            // Assert
            // Use reflection to access the private currentIterator field
            java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("currentIterator");
            field.setAccessible(true);
            Iterator<?> currentIterator = (Iterator<?>) field.get(objectGraphIterator);
            assertNotNull("The currentIterator should not be null after updateCurrentIterator is called.", currentIterator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}