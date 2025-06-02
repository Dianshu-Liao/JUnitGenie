package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reflect_InheritanceUtils_distance_Class_Class_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testDistanceWithNullChild() {
        try {
            int result = InheritanceUtils.distance(null, Object.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullParent() {
        try {
            int result = InheritanceUtils.distance(String.class, null);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithSameClass() {
        try {
            int result = InheritanceUtils.distance(String.class, String.class);
            assertEquals(0, result);
        } catch (Exception e) {
            // Handle the exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithDirectParent() {
        try {
            int result = InheritanceUtils.distance(String.class, Object.class);
            assertEquals(1, result);
        } catch (Exception e) {
            // Handle the exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNoRelation() {
        try {
            int result = InheritanceUtils.distance(String.class, Comparable.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if any
            e.printStackTrace();
        }
    }

}