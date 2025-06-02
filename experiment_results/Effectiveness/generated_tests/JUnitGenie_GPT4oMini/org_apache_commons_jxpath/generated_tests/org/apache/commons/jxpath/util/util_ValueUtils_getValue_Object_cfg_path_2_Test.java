package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_ValueUtils_getValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetValueWithNonContainerObject() {
        Object input = "NonContainerObject"; // A non-container object
        Object expected = "NonContainerObject"; // Expected output should be the same as input
        Object result = ValueUtils.getValue(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetValueWithContainerObject() {
        Container container = new Container() {
            @Override
            public Object getValue() {
                return "ContainerValue"; // Return a value from the container
            }

            @Override
            public void setValue(Object value) {
                // Implement setValue method as required by the Container interface
            }
        };
        Object result = ValueUtils.getValue(container);
        assertEquals("ContainerValue", result); // Expected output should be the value from the container
    }

    @Test(timeout = 4000)
    public void testGetValueWithNestedContainer() {
        Container nestedContainer = new Container() {
            @Override
            public Object getValue() {
                return new Container() {
                    @Override
                    public Object getValue() {
                        return "NestedContainerValue"; // Return a value from the nested container
                    }

                    @Override
                    public void setValue(Object value) {
                        // Implement setValue method as required by the Container interface
                    }
                };
            }

            @Override
            public void setValue(Object value) {
                // Implement setValue method as required by the Container interface
            }
        };
        Object result = ValueUtils.getValue(nestedContainer);
        assertEquals("NestedContainerValue", result); // Expected output should be the value from the nested container
    }


}