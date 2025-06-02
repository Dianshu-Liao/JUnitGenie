package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class iterators_SingletonListIterator_hasNext__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasNext() {
        // Create an instance of SingletonListIterator with beforeFirst = true and removed = false
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        
        // Use reflection to set the private fields beforeFirst and removed
        try {
            java.lang.reflect.Field beforeFirstField = SingletonListIterator.class.getDeclaredField("beforeFirst");
            beforeFirstField.setAccessible(true);
            beforeFirstField.set(iterator, true); // Set beforeFirst to true
            
            java.lang.reflect.Field removedField = SingletonListIterator.class.getDeclaredField("removed");
            removedField.setAccessible(true);
            removedField.set(iterator, false); // Set removed to false
            
            // Now we can test the hasNext method
            assertTrue(iterator.hasNext()); // Expecting true since beforeFirst is true and removed is false
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may occur
        }
    }

}