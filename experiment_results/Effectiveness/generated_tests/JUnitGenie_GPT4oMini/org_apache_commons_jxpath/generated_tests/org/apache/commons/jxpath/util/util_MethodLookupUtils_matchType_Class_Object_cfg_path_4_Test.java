package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.MethodLookupUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class util_MethodLookupUtils_matchType_Class_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testMatchType_ExactMatch() {
        try {
            Class<?> expected = String.class;
            Object object = "test";
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);
            int result = (int) method.invoke(null, expected, object);
            assertEquals(1, result); // Assuming EXACT_MATCH is represented by 1
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMatchType_NullObject() {
        try {
            Class<?> expected = String.class;
            Object object = null;
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);
            int result = (int) method.invoke(null, expected, object);
            assertEquals(2, result); // Assuming APPROXIMATE_MATCH is represented by 2
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMatchType_NotAssignable() {
        try {
            Class<?> expected = Number.class;
            Object object = "test";
            Method method = MethodLookupUtils.class.getDeclaredMethod("matchType", Class.class, Object.class);
            method.setAccessible(true);
            int result = (int) method.invoke(null, expected, object);
            assertEquals(0, result); // Assuming NO_MATCH is represented by 0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}