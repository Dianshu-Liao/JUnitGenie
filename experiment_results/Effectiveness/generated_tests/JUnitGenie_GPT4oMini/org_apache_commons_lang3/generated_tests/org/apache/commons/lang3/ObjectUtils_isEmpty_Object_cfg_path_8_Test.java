package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ObjectUtils_isEmpty_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithCharSequence() {
        // Test with an empty CharSequence
        CharSequence emptyString = "";
        boolean result = ObjectUtils.isEmpty(emptyString);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCharSequence() {
        // Test with a non-empty CharSequence
        CharSequence nonEmptyString = "Hello";
        boolean result = ObjectUtils.isEmpty(nonEmptyString);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithArray() {
        // Test with an empty array
        Object emptyArray = new String[0];
        boolean result = ObjectUtils.isEmpty(emptyArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyArray() {
        // Test with a non-empty array
        Object nonEmptyArray = new String[]{"Hello"};
        boolean result = ObjectUtils.isEmpty(nonEmptyArray);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithCollection() {
        // Test with an empty Collection
        Collection<Object> emptyCollection = new ArrayList<>();
        boolean result = ObjectUtils.isEmpty(emptyCollection);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCollection() {
        // Test with a non-empty Collection
        Collection<Object> nonEmptyCollection = new ArrayList<>();
        nonEmptyCollection.add("Hello");
        boolean result = ObjectUtils.isEmpty(nonEmptyCollection);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithMap() {
        // Test with an empty Map
        Map<Object, Object> emptyMap = new HashMap<>();
        boolean result = ObjectUtils.isEmpty(emptyMap);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyMap() {
        // Test with a non-empty Map
        Map<Object, Object> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put("key", "value");
        boolean result = ObjectUtils.isEmpty(nonEmptyMap);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithOptional() {
        // Test with an empty Optional
        Optional<Object> emptyOptional = Optional.empty();
        boolean result = ObjectUtils.isEmpty(emptyOptional);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyOptional() {
        // Test with a non-empty Optional
        Optional<Object> nonEmptyOptional = Optional.of("Hello");
        boolean result = ObjectUtils.isEmpty(nonEmptyOptional);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        // Test with null
        Object nullObject = null;
        boolean result = ObjectUtils.isEmpty(nullObject);
        assertTrue(result);
    }


}