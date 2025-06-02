package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Test;
import org.junit.Before;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_SkippingIterator_init__cfg_path_2_Test {
    private SkippingIterator<Object> skippingIterator;
    private Iterator<Object> iterator;

    @Before
    public void setUp() {
        // Create an iterator with at least one element
        iterator = Arrays.asList((Object) "element1", (Object) "element2").iterator(); // Cast to Object
        skippingIterator = new SkippingIterator<>(iterator, 1); // Assuming offset is set to 1
    }

    @Test(timeout = 4000)
    public void testInit() {
        try {
            // Access the private method init() using reflection
            Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
            initMethod.setAccessible(true);
            initMethod.invoke(skippingIterator);
            
            // Verify that the pos variable is updated correctly
            // Since we are skipping 1, pos should be 1 after calling init
            // We need to use reflection to access the private field pos
            java.lang.reflect.Field posField = SkippingIterator.class.getDeclaredField("pos");
            posField.setAccessible(true);
            long posValue = (long) posField.get(skippingIterator);
            assertEquals(1, posValue);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}