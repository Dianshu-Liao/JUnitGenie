package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils_size_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSizeWithCollection() {
        Collection<Object> collection = new ArrayList<>();
        collection.add(new Object());
        collection.add(new Object());
        
        int result = CollectionUtils.size(collection);
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        int result = CollectionUtils.size(null);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyCollection() {
        Collection<Object> collection = new ArrayList<>();
        
        int result = CollectionUtils.size(collection);
        assertEquals(0, result);
    }

}