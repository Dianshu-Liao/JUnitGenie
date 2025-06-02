package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class ObjectUtils_isEmpty_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithCharSequence() {
        // Test with an empty CharSequence
        CharSequence emptyString = "";
        assertTrue(ObjectUtils.isEmpty(emptyString));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCharSequence() {
        // Test with a non-empty CharSequence
        CharSequence nonEmptyString = "Hello";
        assertFalse(ObjectUtils.isEmpty(nonEmptyString));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithArray() {
        // Test with an empty array
        Object emptyArray = new Object[0];
        assertTrue(ObjectUtils.isEmpty(emptyArray));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyArray() {
        // Test with a non-empty array
        Object nonEmptyArray = new Object[1];
        assertFalse(ObjectUtils.isEmpty(nonEmptyArray));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithCollection() {
        // Test with an empty collection
        Collection<Object> emptyCollection = new ArrayList<>();
        assertTrue(ObjectUtils.isEmpty(emptyCollection));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCollection() {
        // Test with a non-empty collection
        Collection<Object> nonEmptyCollection = new ArrayList<>();
        nonEmptyCollection.add(new Object());
        assertFalse(ObjectUtils.isEmpty(nonEmptyCollection));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithMap() {
        // Test with an empty map
        Map<Object, Object> emptyMap = new HashMap<>();
        assertTrue(ObjectUtils.isEmpty(emptyMap));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyMap() {
        // Test with a non-empty map
        Map<Object, Object> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put(new Object(), new Object());
        assertFalse(ObjectUtils.isEmpty(nonEmptyMap));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithOptionalEmpty() {
        // Test with an empty Optional
        Optional<Object> emptyOptional = Optional.empty();
        assertTrue(ObjectUtils.isEmpty(emptyOptional));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithOptionalPresent() {
        // Test with a present Optional
        Optional<Object> presentOptional = Optional.of(new Object());
        assertFalse(ObjectUtils.isEmpty(presentOptional));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        // Test with null
        Object nullObject = null;
        assertTrue(ObjectUtils.isEmpty(nullObject));
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyObject() {
        // Test with a non-empty object (not a collection, map, array, or optional)
        Object nonEmptyObject = new Object();
        assertFalse(ObjectUtils.isEmpty(nonEmptyObject));
    }


}