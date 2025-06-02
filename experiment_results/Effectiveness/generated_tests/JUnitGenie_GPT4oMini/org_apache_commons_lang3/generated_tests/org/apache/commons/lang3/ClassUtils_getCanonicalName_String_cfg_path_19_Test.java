package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class ClassUtils_getCanonicalName_String_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalNameWithNullInput() {
        try {
            // Accessing the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true);
            
            // Invoke the method with null to cover the specified CFGPath
            String result = (String) method.invoke(null, (String) null);
            
            // Assert that the result is null
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}