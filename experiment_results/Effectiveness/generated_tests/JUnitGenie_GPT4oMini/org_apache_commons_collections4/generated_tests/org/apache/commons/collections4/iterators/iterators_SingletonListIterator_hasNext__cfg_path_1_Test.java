package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class iterators_SingletonListIterator_hasNext__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasNext_whenBeforeFirstIsTrueAndRemovedIsFalse() {
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        
        // Accessing private fields using reflection to set the values
        try {
            java.lang.reflect.Field beforeFirstField = SingletonListIterator.class.getDeclaredField("beforeFirst");
            beforeFirstField.setAccessible(true);
            beforeFirstField.set(iterator, true);
            
            java.lang.reflect.Field removedField = SingletonListIterator.class.getDeclaredField("removed");
            removedField.setAccessible(true);
            removedField.set(iterator, false);
            
            // Test the hasNext method
            boolean result = iterator.hasNext();
            assertFalse(result); // Expecting false since removed is false and beforeFirst is true
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHasNext_whenBeforeFirstIsFalseAndRemovedIsTrue() {
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        
        // Accessing private fields using reflection to set the values
        try {
            java.lang.reflect.Field beforeFirstField = SingletonListIterator.class.getDeclaredField("beforeFirst");
            beforeFirstField.setAccessible(true);
            beforeFirstField.set(iterator, false);
            
            java.lang.reflect.Field removedField = SingletonListIterator.class.getDeclaredField("removed");
            removedField.setAccessible(true);
            removedField.set(iterator, true);
            
            // Test the hasNext method
            boolean result = iterator.hasNext();
            assertFalse(result); // Expecting false since removed is true
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}