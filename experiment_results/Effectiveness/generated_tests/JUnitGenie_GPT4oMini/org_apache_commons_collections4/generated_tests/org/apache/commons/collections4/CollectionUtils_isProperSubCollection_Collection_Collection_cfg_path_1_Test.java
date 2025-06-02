package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionUtils_isProperSubCollection_Collection_Collection_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsProperSubCollection() {
        Collection<Integer> a = new ArrayList<>();
        Collection<Integer> b = new ArrayList<>();
        
        // Test case where 'a' is a proper subcollection of 'b'
        a.add(1);
        a.add(2);
        b.add(1);
        b.add(2);
        b.add(3);
        assertTrue(CollectionUtils.isProperSubCollection(a, b));

        // Test case where 'a' is not a proper subcollection (same size)
        Collection<Integer> c = new ArrayList<>(a);
        assertFalse(CollectionUtils.isProperSubCollection(c, b));

        // Test case where 'a' is not a proper subcollection (larger size)
        Collection<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(2);
        d.add(3);
        assertFalse(CollectionUtils.isProperSubCollection(d, b));

        // Test case where 'a' is empty (proper subcollection of non-empty 'b')
        a.clear();
        assertTrue(CollectionUtils.isProperSubCollection(a, b));

        // Test case where both collections are empty (not a proper subcollection)
        assertFalse(CollectionUtils.isProperSubCollection(a, a));
    }

    @Test(timeout = 4000)
    public void testIsProperSubCollectionNullCheck() {
        try {
            CollectionUtils.isProperSubCollection(null, new ArrayList<>());
        } catch (NullPointerException e) {
            assertTrue(e.getMessage().contains("a"));
        }
        
        try {
            CollectionUtils.isProperSubCollection(new ArrayList<>(), null);
        } catch (NullPointerException e) {
            assertTrue(e.getMessage().contains("b"));
        }
    }

}