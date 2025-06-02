package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class util_ValueUtils_isCollection_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsCollection_WithContainerInstance() {
        Container container = new Container() {
            @Override
            public void setValue(Object value) {
                // Implementation for setValue method
            }

            @Override
            public Object getValue() {
                return null; // Implementation for getValue method
            }
        };
        
        // Using a try-catch block to handle potential exceptions on method invocation
        try {
            boolean result = ValueUtils.isCollection(container);
            assertTrue("Expected result to be true for Container instance", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsCollection_WithNull() {
        // Using a try-catch block to handle potential exceptions on method invocation
        try {
            boolean result = ValueUtils.isCollection(null);
            assertTrue("Expected result to be false for null input", !result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsCollection_WithArray() {
        // Using a try-catch block to handle potential exceptions on method invocation
        try {
            Object array = new String[] { "test" };
            boolean result = ValueUtils.isCollection(array);
            assertTrue("Expected result to be true for array input", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsCollection_WithOtherType() {
        // Using a try-catch block to handle potential exceptions on method invocation
        try {
            Object notACollection = new Object();
            boolean result = ValueUtils.isCollection(notACollection);
            assertTrue("Expected result to be false for non-collection object", !result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}