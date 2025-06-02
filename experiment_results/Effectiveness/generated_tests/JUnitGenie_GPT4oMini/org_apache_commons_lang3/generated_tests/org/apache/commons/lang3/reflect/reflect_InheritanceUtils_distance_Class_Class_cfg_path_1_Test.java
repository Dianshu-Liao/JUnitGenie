package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reflect_InheritanceUtils_distance_Class_Class_cfg_path_1_Test {

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

    // Example classes for testing
    public static class ParentClass {}
    public static class ChildClass extends ParentClass {}

}