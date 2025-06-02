package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reflect_InheritanceUtils_distance_Class_Class_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testDistanceWithNullChild() {
        try {
            int result = InheritanceUtils.distance(null, Object.class);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testDistanceWithNullParent() {
        try {
            int result = InheritanceUtils.distance(String.class, null);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}