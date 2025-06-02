package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class list_AbstractLinkedListJava21_getNode_int_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetNode_IndexLessThanZero() {
        try {
            // Create an instance of the abstract class using reflection
            Class<?> clazz = AbstractLinkedListJava21.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractLinkedListJava21 list = (AbstractLinkedListJava21) constructor.newInstance();

            // Access the protected method using reflection
            Method method = clazz.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);

            // Call the method with an index less than zero
            method.invoke(list, -1, false);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}