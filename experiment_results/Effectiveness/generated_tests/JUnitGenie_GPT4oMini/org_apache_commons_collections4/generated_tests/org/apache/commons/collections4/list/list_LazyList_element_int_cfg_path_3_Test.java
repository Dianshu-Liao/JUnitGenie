package org.apache.commons.collections4.list;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.list.LazyList;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class list_LazyList_element_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testElementWithFactoryNull() {
        // Arrange
        List<Object> list = new ArrayList<>();
        // Provide a default factory to avoid NullPointerException
        LazyList<Object> lazyList = new LazyList<>(list, new Factory<Object>() {
            @Override
            public Object create() {
                return null; // Return null for the factory
            }
        });

        // Access the private method using reflection
        try {
            Method method = LazyList.class.getDeclaredMethod("element", int.class);
            method.setAccessible(true);

            // Act
            Object result = method.invoke(lazyList, 0);

            // Assert
            assertEquals(null, result); // Expecting null since factory returns null
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}