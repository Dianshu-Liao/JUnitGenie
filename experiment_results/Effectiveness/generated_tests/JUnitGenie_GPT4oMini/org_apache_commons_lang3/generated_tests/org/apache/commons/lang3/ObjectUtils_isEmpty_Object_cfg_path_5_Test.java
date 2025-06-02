package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ObjectUtils_isEmpty_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithCollection() {
        // Given a non-empty collection
        Collection<String> collection = new ArrayList<>();
        collection.add("element");

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(collection);

        // Then it should return false
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyCollection() {
        // Given an empty collection
        Collection<String> collection = new ArrayList<>();

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(collection);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        // Given a null object
        Object object = null;

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(object);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithCharSequence() {
        // Given an empty CharSequence
        CharSequence charSequence = "";

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(charSequence);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCharSequence() {
        // Given a non-empty CharSequence
        CharSequence charSequence = "text";

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(charSequence);

        // Then it should return false
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithArray() {
        // Given an empty array
        Object array = new String[0];

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(array);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyArray() {
        // Given a non-empty array
        Object array = new String[]{"element"};

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(array);

        // Then it should return false
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithMap() {
        // Given an empty map
        Map<String, String> map = new HashMap<>();

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(map);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyMap() {
        // Given a non-empty map
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(map);

        // Then it should return false
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithOptional() {
        // Given an empty Optional
        Optional<String> optional = Optional.empty();

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(optional);

        // Then it should return true
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithPresentOptional() {
        // Given a present Optional
        Optional<String> optional = Optional.of("value");

        // When calling isEmpty
        boolean result = ObjectUtils.isEmpty(optional);

        // Then it should return false
        assertTrue(!result);
    }


}