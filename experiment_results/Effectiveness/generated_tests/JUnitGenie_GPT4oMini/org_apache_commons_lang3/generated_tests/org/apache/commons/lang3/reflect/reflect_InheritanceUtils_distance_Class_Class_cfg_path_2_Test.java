package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reflect_InheritanceUtils_distance_Class_Class_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDistanceWithValidClasses() {
        try {
            // Test with a child class and its direct parent
            int result = InheritanceUtils.distance(ChildClass.class, ParentClass.class);
            assertEquals(1, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithSameClass() {
        try {
            // Test with the same class
            int result = InheritanceUtils.distance(ParentClass.class, ParentClass.class);
            assertEquals(0, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullChild() {
        try {
            // Test with null child
            int result = InheritanceUtils.distance(null, ParentClass.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullParent() {
        try {
            // Test with null parent
            int result = InheritanceUtils.distance(ChildClass.class, null);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNonRelatedClasses() {
        try {
            // Test with classes that are not related
            int result = InheritanceUtils.distance(ChildClass.class, UnrelatedClass.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    // Sample classes for testing
    public static class ParentClass {}
    public static class ChildClass extends ParentClass {}
    public static class UnrelatedClass {}

}