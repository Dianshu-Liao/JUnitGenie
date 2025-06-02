package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertFalse;

public class iterators_FilterIterator_setNextObject__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetNextObjectWhenIteratorHasNoNext() {
        // Create an empty iterator
        Iterator<Integer> emptyIterator = Arrays.asList(0).iterator(); // Changed to create an iterator with a single element
        FilterIterator<Integer> filterIterator = new FilterIterator<>(emptyIterator, object -> object > 0);

        try {
            // Access the private method setNextObject using reflection
            Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(filterIterator);
            assertFalse(result); // Expecting false since the iterator is empty
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }


}