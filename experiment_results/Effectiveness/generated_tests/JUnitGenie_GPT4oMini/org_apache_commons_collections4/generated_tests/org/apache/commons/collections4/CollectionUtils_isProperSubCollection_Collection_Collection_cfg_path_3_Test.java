package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static org.junit.Assert.assertFalse;

public class CollectionUtils_isProperSubCollection_Collection_Collection_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsProperSubCollection() {
        // Prepare test collections
        Collection<Integer> a = new ArrayList<>(Collections.singletonList(1));
        Collection<Integer> b = new ArrayList<>(Collections.singletonList(1));
        
        // Test case where a is not a proper sub-collection of b
        try {
            boolean result = CollectionUtils.isProperSubCollection(a, b);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}