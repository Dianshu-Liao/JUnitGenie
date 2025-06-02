package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reflect_InheritanceUtils_distance_Class_Class_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDistanceWithChildAndParent() {
        try {
            // Test case where child is a subclass of parent
            int result = InheritanceUtils.distance(SubClass.class, ParentClass.class);
            assertEquals(1, result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithSameClass() {
        try {
            // Test case where child and parent are the same class
            int result = InheritanceUtils.distance(ParentClass.class, ParentClass.class);
            assertEquals(0, result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullChild() {
        try {
            // Test case where child is null
            int result = InheritanceUtils.distance(null, ParentClass.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullParent() {
        try {
            // Test case where parent is null
            int result = InheritanceUtils.distance(SubClass.class, null);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNoRelation() {
        try {
            // Test case where child and parent have no relation
            int result = InheritanceUtils.distance(UnrelatedClass.class, ParentClass.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    // Sample classes for testing
    public static class ParentClass {}
    public static class SubClass extends ParentClass {}
    public static class UnrelatedClass {}

}