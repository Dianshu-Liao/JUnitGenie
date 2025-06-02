package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_6_Test {

    private final NullComparator<Object> comparator = new NullComparator<>();

    @Test(timeout = 4000)
    public void testCompare_SameObjects() {
        Object obj = new Object();
        try {
            assertEquals(0, comparator.compare(obj, obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testCompare_NullFirst() {
        try {
            assertEquals(1, comparator.compare(null, new Object()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testCompare_NullSecond() {
        try {
            assertEquals(-1, comparator.compare(new Object(), null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}