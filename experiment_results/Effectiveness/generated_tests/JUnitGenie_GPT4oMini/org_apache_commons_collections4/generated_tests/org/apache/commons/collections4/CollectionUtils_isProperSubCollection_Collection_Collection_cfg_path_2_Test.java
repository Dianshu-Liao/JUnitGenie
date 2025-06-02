package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static org.junit.Assert.assertTrue;

public class CollectionUtils_isProperSubCollection_Collection_Collection_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsProperSubCollection() {
        // Prepare the collections
        Collection<Integer> a = new ArrayList<>();
        Collections.addAll(a, 1, 2); // Proper sub-collection
        Collection<Integer> b = new ArrayList<>();
        Collections.addAll(b, 1, 2, 3); // Larger collection

        // Test case for the proper sub-collection
        boolean result = false;

        try {
            result = CollectionUtils.isProperSubCollection(a, b);
        } catch (Exception e) {
            // Handle potential exceptions
            e.printStackTrace();
        }

        assertTrue(result);
    }

}