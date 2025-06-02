package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class iterators_BoundedIterator_init__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInit() {
        // Create a sample iterator
        Iterator<Integer> sampleIterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        long offset = 3; // Set offset
        long initialPos = 0; // Set initial position

        // Instantiate the BoundedIterator
        BoundedIterator<Integer> boundedIterator = new BoundedIterator<>(sampleIterator, initialPos, offset);

        // Access the private method init() using reflection
        try {
            Method initMethod = BoundedIterator.class.getDeclaredMethod("init");
            initMethod.setAccessible(true); // Make the private method accessible

            // Call the init method
            initMethod.invoke(boundedIterator);

            // Verify the position after calling init
            long expectedPos = Math.min(initialPos + 3, offset); // Should increment pos by 3 or reach offset
            long actualPos = (long) BoundedIterator.class.getDeclaredField("pos").get(boundedIterator);
            assertEquals(expectedPos, actualPos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}