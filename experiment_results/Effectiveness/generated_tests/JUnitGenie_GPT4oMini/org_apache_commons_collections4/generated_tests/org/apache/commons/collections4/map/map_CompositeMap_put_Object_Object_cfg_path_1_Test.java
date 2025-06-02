package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class map_CompositeMap_put_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutWithMutator() {
        // Arrange
        CompositeMap<Object, Object> compositeMap = new CompositeMap<>(new Map[]{}); // Initialize with an empty array
        compositeMap.setMutator(new CompositeMap.MapMutator<Object, Object>() { // Specify type parameters for MapMutator
            @Override
            public Object put(CompositeMap<Object, Object> compositeMap, Map<Object, Object>[] composite, Object key, Object value) {
                // Mock implementation of put
                return value; // Just return the value for testing
            }

            @Override
            public void resolveCollision(CompositeMap<Object, Object> compositeMap, Map<Object, Object> map1, Map<Object, Object> map2, Collection<Object> collection) {
                // Mock implementation of resolveCollision
            }

            @Override
            public void putAll(CompositeMap<Object, Object> compositeMap, Map<Object, Object>[] composite, Map<? extends Object, ? extends Object> map) {
                // Mock implementation of putAll
            }
        });
        Object key = new Object();
        Object value = new Object();

        // Act
        Object result = compositeMap.put(key, value);

        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testPutWithoutMutator() {
        // Arrange
        CompositeMap<Object, Object> compositeMap = new CompositeMap<>(new Map[]{}); // Initialize with an empty array
        Object key = new Object();
        Object value = new Object();

        // Act & Assert
        try {
            compositeMap.put(key, value);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("No mutator specified", e.getMessage());
        }
    }


}