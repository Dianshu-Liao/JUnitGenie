package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.Assert.assertNotNull;

public class iterators_UnmodifiableIterator_unmodifiableIterator_Iterator_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableIterator_WithValidIterator() {
        Iterator<String> validIterator = Arrays.asList("one", "two", "three").iterator();

        try {
            Iterator<String> result = UnmodifiableIterator.unmodifiableIterator(validIterator);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testUnmodifiableIterator_WithNullIterator() {
        try {
            UnmodifiableIterator.unmodifiableIterator(null);
        } catch (NullPointerException e) {
            // Expected exception was thrown
            // Handle exception
            e.printStackTrace();
        }
    }

}