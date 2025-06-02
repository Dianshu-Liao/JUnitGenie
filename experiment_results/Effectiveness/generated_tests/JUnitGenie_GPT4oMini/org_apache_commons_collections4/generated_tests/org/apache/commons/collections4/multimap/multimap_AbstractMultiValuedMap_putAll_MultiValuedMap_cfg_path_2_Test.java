package org.apache.commons.collections4.multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.AbstractMultiValuedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class multimap_AbstractMultiValuedMap_putAll_MultiValuedMap_cfg_path_2_Test {

    private class TestMultiValuedMap<K, V> extends AbstractMultiValuedMap<K, V> {
        @Override
        protected java.util.Collection<V> createCollection() {
            return new java.util.ArrayList<>();
        }
    }

    @Test(timeout = 4000)
    public void testPutAllWithEmptyMap() {
        TestMultiValuedMap<String, String> testMap = new TestMultiValuedMap<>();
        MultiValuedMap<String, String> emptyMap = new TestMultiValuedMap<>();

        boolean result = testMap.putAll(emptyMap);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testPutAllWithNullMap() {
        TestMultiValuedMap<String, String> testMap = new TestMultiValuedMap<>();

        try {
            // Explicitly cast null to MultiValuedMap to resolve ambiguity
            testMap.putAll((MultiValuedMap<String, String>) null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("map", e.getMessage());
        }
    }


}