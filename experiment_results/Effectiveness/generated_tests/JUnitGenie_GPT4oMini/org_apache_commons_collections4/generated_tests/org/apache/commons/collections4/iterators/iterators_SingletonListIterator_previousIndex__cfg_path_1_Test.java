package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class iterators_SingletonListIterator_previousIndex__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPreviousIndex_WhenBeforeFirstIsTrue() {
        SingletonListIterator iterator = new SingletonListIterator(new Object());
        // Set the private field beforeFirst to true
        try {
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField("beforeFirst");
            field.setAccessible(true);
            field.setBoolean(iterator, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int result = iterator.previousIndex();
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testPreviousIndex_WhenBeforeFirstIsFalse() {
        SingletonListIterator iterator = new SingletonListIterator(new Object());
        // Set the private field beforeFirst to false
        try {
            java.lang.reflect.Field field = SingletonListIterator.class.getDeclaredField("beforeFirst");
            field.setAccessible(true);
            field.setBoolean(iterator, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int result = iterator.previousIndex();
        assertEquals(0, result);
    }

}