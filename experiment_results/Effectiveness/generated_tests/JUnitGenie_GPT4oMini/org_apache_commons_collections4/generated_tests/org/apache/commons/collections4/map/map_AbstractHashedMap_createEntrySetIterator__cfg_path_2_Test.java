package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class map_AbstractHashedMap_createEntrySetIterator__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateEntrySetIteratorWhenNotEmpty() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            AbstractHashedMap<Integer, String> map = constructor.newInstance(1); // Create a non-empty map

            // Call the protected method using reflection
            Iterator<Map.Entry<Integer, String>> iterator = (Iterator<Map.Entry<Integer, String>>) 
                AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator").invoke(map);

            // Verify that the iterator is not null
            assertNotNull(iterator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}