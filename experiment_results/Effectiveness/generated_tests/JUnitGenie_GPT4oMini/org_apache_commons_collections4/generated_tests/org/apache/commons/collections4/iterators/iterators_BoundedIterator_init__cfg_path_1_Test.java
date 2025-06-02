package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;

public class iterators_BoundedIterator_init__cfg_path_1_Test {

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

            // Verify the state after calling init
            // Since we are not directly able to access private fields, we can use reflection to check the pos value
            java.lang.reflect.Field posField = BoundedIterator.class.getDeclaredField("pos");
            posField.setAccessible(true);
            long posValue = (long) posField.get(boundedIterator);

            // Assert that pos is updated correctly
            assertEquals(3, posValue); // pos should be equal to offset

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}