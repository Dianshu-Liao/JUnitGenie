package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class list_AbstractLinkedListJava21_getNode_int_boolean_cfg_path_8_Test {

    private AbstractLinkedListJava21 createList() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractLinkedListJava21> constructor = AbstractLinkedListJava21.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            fail("Failed to create instance of AbstractLinkedListJava21: " + e.getMessage());
            return null; // This will never be reached due to fail
        }
    }

    @Test(timeout = 4000)
    public void testGetNodeThrowsIndexOutOfBoundsExceptionForNegativeIndex() {
        AbstractLinkedListJava21 list = createList();
        try {
            Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);
            list.getNode(-1, false);
            fail("Expected IndexOutOfBoundsException for negative index");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetNodeThrowsIndexOutOfBoundsExceptionForIndexEqualToSizeWithoutEndMarker() {
        AbstractLinkedListJava21 list = createList();
        try {
            Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);
            // Assuming the size is 0 for this test
            list.getNode(0, false);
            fail("Expected IndexOutOfBoundsException for index equal to size without end marker");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetNodeThrowsIndexOutOfBoundsExceptionForIndexGreaterThanSize() {
        AbstractLinkedListJava21 list = createList();
        try {
            Method method = AbstractLinkedListJava21.class.getDeclaredMethod("getNode", int.class, boolean.class);
            method.setAccessible(true);
            // Assuming the size is 0 for this test
            list.getNode(1, false);
            fail("Expected IndexOutOfBoundsException for index greater than size");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}