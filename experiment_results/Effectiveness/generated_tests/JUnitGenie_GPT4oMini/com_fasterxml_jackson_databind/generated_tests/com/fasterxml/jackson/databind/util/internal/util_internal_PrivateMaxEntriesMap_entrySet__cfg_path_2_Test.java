package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class util_internal_PrivateMaxEntriesMap_entrySet__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEntrySetWhenEntrySetIsNull() {
        // Arrange
        PrivateMaxEntriesMap map = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());

        // Act
        Set<Entry<Object, Object>> result = map.entrySet(); // Use Object for K and V

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testEntrySetWhenEntrySetIsNotNull() {
        // Arrange
        PrivateMaxEntriesMap map = new PrivateMaxEntriesMap(new PrivateMaxEntriesMap.Builder());
        map.entrySet = new HashSet<>(); // Simulate entrySet being already initialized

        // Act
        Set<Entry<Object, Object>> result = map.entrySet(); // Use Object for K and V

        // Assert
        assertNotNull(result);
    }


}