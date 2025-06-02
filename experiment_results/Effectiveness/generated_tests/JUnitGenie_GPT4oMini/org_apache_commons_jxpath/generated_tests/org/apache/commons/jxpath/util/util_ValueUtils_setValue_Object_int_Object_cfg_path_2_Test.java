package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class util_ValueUtils_setValue_Object_int_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetValueWithList() {
        // Setup
        List<Object> list = new ArrayList<>();
        list.add("original");
        Object collection = new Container() {
            @Override
            public Object getValue() {
                return list;
            }

            @Override
            public void setValue(Object value) {
                // Implement setValue to allow modification
                if (value instanceof List) {
                    list.clear();
                    list.addAll((List<Object>) value);
                }
            }
        };

        int index = 0;
        Object value = "updated";

        // Execute
        try {
            ValueUtils.setValue(collection, index, value);
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }

        // Verify
        assertEquals("updated", list.get(index));
    }

    @Test(timeout = 4000)
    public void testSetValueWithArray() {
        // Setup
        Object[] array = new Object[]{"original"};
        Object collection = new Container() {
            @Override
            public Object getValue() {
                return array;
            }

            @Override
            public void setValue(Object value) {
                // Implement setValue to allow modification
                if (value instanceof Object[]) {
                    System.arraycopy(value, 0, array, 0, ((Object[]) value).length);
                }
            }
        };
        
        int index = 0;
        Object value = "updated";

        // Execute
        try {
            ValueUtils.setValue(collection, index, value);
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }

        // Verify
        assertEquals("updated", array[index]);
    }

    @Test(timeout = 4000)
    public void testSetValueWithUnsupportedCollection() {
        // Setup
        List<String> collection = new ArrayList<>();
        collection.add("item1");
        collection.add("item2");
        int index = 0;
        Object value = "newValue";

        // Execute & Verify
        try {
            ValueUtils.setValue(collection, index, value);
            fail("Should have thrown an UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Should not have thrown any other exception");
        }
    }


}