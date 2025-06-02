package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ExtendedIterator;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.Collections;

public class iterators_ExtendedIterator_create_Iterator_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateWithNonExtendedIterator() {
        // Create a non-ExtendedIterator instance
        Iterator<String> nonExtendedIterator = Collections.singletonList("test").iterator();
        
        // Call the focal method
        ExtendedIterator<String> result = null;
        try {
            result = ExtendedIterator.create(nonExtendedIterator);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Validate the result
        assertNotNull(result);
        assertTrue(result instanceof ExtendedIterator);
    }

}