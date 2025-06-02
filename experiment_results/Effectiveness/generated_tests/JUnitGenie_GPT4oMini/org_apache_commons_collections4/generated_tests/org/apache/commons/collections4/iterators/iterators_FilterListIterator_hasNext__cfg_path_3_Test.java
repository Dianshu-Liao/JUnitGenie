package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.FilterListIterator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class iterators_FilterListIterator_hasNext__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenNextObjectSetIsTrue() {
        // Create an instance of FilterListIterator
        FilterListIterator iterator = new FilterListIterator();

        // Set the private field nextObjectSet to true using reflection
        try {
            java.lang.reflect.Field field = FilterListIterator.class.getDeclaredField("nextObjectSet");
            field.setAccessible(true);
            field.setBoolean(iterator, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Call the hasNext method and assert the expected outcome
        boolean result = iterator.hasNext();
        assertTrue(result);
    }

}