package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class iterators_SingletonListIterator_previousIndex__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousIndex_WhenBeforeFirstIsTrue() {
        SingletonListIterator iterator = new SingletonListIterator(new Object());
        // Set the beforeFirst field to true (default value)
        // We expect previousIndex to return -1
        assertEquals(-1, iterator.previousIndex());
    }

    @Test(timeout = 4000)
    public void testPreviousIndex_WhenBeforeFirstIsFalse() {
        SingletonListIterator iterator = new SingletonListIterator(new Object());
        // Use reflection to set the private field beforeFirst to false
        try {
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField("beforeFirst");
            field.setAccessible(true);
            field.setBoolean(iterator, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // We expect previousIndex to return 0
        assertEquals(0, iterator.previousIndex());
    }

}