package org.apache.commons.collections4.multimap;
import org.apache.commons.collections4.multimap.AbstractMultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;

public class multimap_AbstractMultiValuedMap_size__cfg_path_1_Test {

    private class TestMultiValuedMap extends AbstractMultiValuedMap<String, String> {
        public TestMultiValuedMap() {
        }

        @Override
        protected Collection<String> createCollection() {
            return new ArrayList<>();
        }
    }

    @Test(timeout = 4000)
    public void testSize() {
        TestMultiValuedMap multiValuedMap = new TestMultiValuedMap();
        multiValuedMap.put("key1", "value1");
        multiValuedMap.put("key1", "value2");
        multiValuedMap.put("key2", "value3");

        // The expected size is 3 since there are three values in total
        int expectedSize = 3;
        int actualSize = multiValuedMap.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyMap() {
        TestMultiValuedMap multiValuedMap = new TestMultiValuedMap();

        // The expected size is 0 since no values are added
        int expectedSize = 0;
        int actualSize = multiValuedMap.size();
        assertEquals(expectedSize, actualSize);
    }


}
