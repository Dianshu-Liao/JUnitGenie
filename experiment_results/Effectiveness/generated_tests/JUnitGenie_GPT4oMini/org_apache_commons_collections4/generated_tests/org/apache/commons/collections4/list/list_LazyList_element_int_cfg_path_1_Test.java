package org.apache.commons.collections4.list;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.list.LazyList;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import static org.junit.Assert.fail;

public class list_LazyList_element_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testElementThrowsIllegalStateExceptionWhenBothFactoryAndTransformerAreNull() {
        // Create an empty list to pass as the collection parameter
        LazyList<Integer> lazyList = new LazyList<>(new ArrayList<Integer>(), (Factory<? extends Integer>) null); // factory is null, but collection is not
        
        try {
            // Use reflection to access the private method
            Method method = LazyList.class.getDeclaredMethod("element", int.class);
            method.setAccessible(true);
            method.invoke(lazyList, 0); // attempt to call the private method
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }


}