package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.fail;

public class iterators_SingletonListIterator_next__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextThrowsNoSuchElementException() {
        SingletonListIterator iterator = new SingletonListIterator(new Object());
        
        // Set the beforeFirst variable to false to simulate the condition
        // where next() can be called after the first call.
        // However, we need to simulate the case where it throws the exception.
        try {
            // Directly set the private field beforeFirst to false
            // This is a workaround since we cannot access private fields directly.
            // In a real scenario, you might use reflection or a setter method if available.
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField("beforeFirst");
            field.setAccessible(true);
            field.set(iterator, false); // Simulate that next() has been called before
            
            // Now we call next() which should throw NoSuchElementException
            iterator.next(); // This should throw the exception
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Expected exception
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}