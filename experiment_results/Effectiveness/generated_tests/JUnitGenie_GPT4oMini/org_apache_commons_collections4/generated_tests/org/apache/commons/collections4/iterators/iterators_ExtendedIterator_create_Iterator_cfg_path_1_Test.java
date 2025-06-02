package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ExtendedIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.Collections;
import static org.junit.Assert.assertNotNull;

public class iterators_ExtendedIterator_create_Iterator_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateWithExtendedIterator() {
        // Create an instance of ExtendedIterator using the static method
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(Collections.emptyIterator());

        // Verify the result is not null
        assertNotNull(extendedIterator);
    }

    @Test(timeout = 4000)
    public void testCreateWithRegularIterator() {
        // Create a regular Iterator
        Iterator<String> regularIterator = Collections.emptyIterator();
        
        // Call the focal method
        ExtendedIterator<String> result = ExtendedIterator.create(regularIterator);
        
        // Verify the result is not null
        assertNotNull(result);
    }


}