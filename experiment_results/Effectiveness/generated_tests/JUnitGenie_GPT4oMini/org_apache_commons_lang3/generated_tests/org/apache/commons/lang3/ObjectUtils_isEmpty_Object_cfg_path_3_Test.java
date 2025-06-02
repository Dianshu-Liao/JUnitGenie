package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class ObjectUtils_isEmpty_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        // Test case where the input is null
        Object input = null;
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the input is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithCharSequence() {
        // Test case where the input is an empty CharSequence
        CharSequence input = "";
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the CharSequence is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCharSequence() {
        // Test case where the input is a non-empty CharSequence
        CharSequence input = "Hello";
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(!result); // Expecting false since the CharSequence is not empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyArray() {
        // Test case where the input is an empty array
        Object input = new Object[0];
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the array is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyArray() {
        // Test case where the input is a non-empty array
        Object input = new Object[]{1, 2, 3};
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(!result); // Expecting false since the array is not empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyCollection() {
        // Test case where the input is an empty Collection
        Collection<Object> input = new ArrayList<>();
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the collection is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCollection() {
        // Test case where the input is a non-empty Collection
        Collection<Object> input = Arrays.asList(1, 2, 3);
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(!result); // Expecting false since the collection is not empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyMap() {
        // Test case where the input is an empty Map
        Map<Object, Object> input = new HashMap<>();
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the map is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyMap() {
        // Test case where the input is a non-empty Map
        Map<Object, Object> input = new HashMap<>();
        input.put(1, "one");
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(!result); // Expecting false since the map is not empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyOptional() {
        // Test case where the input is an empty Optional
        Optional<Object> input = Optional.empty();
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(result); // Expecting true since the Optional is empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyOptional() {
        // Test case where the input is a non-empty Optional
        Optional<Object> input = Optional.of(new Object());
        try {
            boolean result = ObjectUtils.isEmpty(input);
            assertTrue(!result); // Expecting false since the Optional is not empty
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}