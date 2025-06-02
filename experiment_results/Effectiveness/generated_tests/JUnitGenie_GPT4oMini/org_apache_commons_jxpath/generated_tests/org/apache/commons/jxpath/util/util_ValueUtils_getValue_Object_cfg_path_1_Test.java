package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_ValueUtils_getValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValueWithContainer() {
        try {
            // Create a mock Container that returns another Container
            Container container = new Container() {
                @Override
                public Object getValue() {
                    return new Container() {
                        @Override
                        public Object getValue() {
                            return "Final Value"; // This will break the loop
                        }

                        @Override
                        public void setValue(Object value) {
                            // Mock implementation, can be left empty
                        }
                    };
                }

                @Override
                public void setValue(Object value) {
                    // Mock implementation, can be left empty
                }
            };

            Object result = ValueUtils.getValue(container);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetValueWithNonContainer() {
        try {
            Object result = ValueUtils.getValue("Not a Container");
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}