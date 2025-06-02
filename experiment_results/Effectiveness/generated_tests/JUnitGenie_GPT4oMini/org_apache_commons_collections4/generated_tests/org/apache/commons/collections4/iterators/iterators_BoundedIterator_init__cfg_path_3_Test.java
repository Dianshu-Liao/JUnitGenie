package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.BoundedIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class iterators_BoundedIterator_init__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInit() {
        // Prepare the iterator and the BoundedIterator instance
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        long offset = 3; // Set offset to a value greater than the number of elements
        BoundedIterator boundedIterator = new BoundedIterator(iterator, 0, offset);

        // Access the private method using reflection
        try {
            Method initMethod = BoundedIterator.class.getDeclaredMethod("init");
            initMethod.setAccessible(true); // Make the private method accessible

            // Invoke the init method
            initMethod.invoke(boundedIterator);

            // Verify the state after invoking init
            // Since pos is private, we need to access it through a method or reflection
            Method getPosMethod = BoundedIterator.class.getDeclaredMethod("getPos");
            getPosMethod.setAccessible(true); // Make the private method accessible

            // Invoke the getPos method to retrieve the position
            int pos = (int) getPosMethod.invoke(boundedIterator);
            assertEquals(0, pos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}