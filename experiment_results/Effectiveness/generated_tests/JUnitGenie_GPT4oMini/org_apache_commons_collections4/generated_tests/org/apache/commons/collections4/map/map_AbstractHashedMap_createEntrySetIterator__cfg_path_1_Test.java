package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class map_AbstractHashedMap_createEntrySetIterator__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateEntrySetIterator() {
        try {
            // Create an instance of AbstractHashedMap using reflection
            Class<AbstractHashedMap> clazz = AbstractHashedMap.class;
            Constructor<AbstractHashedMap> constructor = clazz.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            AbstractHashedMap<Integer, String> map = constructor.newInstance(1); // Create a non-empty map

            // Add an entry to the map to ensure it's not empty
            map.put(1, "value1");

            // Access the protected method createEntrySetIterator using reflection
            Iterator<Map.Entry<Integer, String>> iterator = (Iterator<Map.Entry<Integer, String>>) clazz.getDeclaredMethod("createEntrySetIterator").invoke(map);

            // Verify that the iterator is not null
            assertNotNull("Iterator should not be null", iterator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}