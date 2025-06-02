package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.lang.reflect.Method;

public class DateTimeUtils_checkPermission__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckPermission_NoSecurityManager() {
        try {
            // Use reflection to access the private static method
            Method method = DateTimeUtils.class.getDeclaredMethod("checkPermission");
            method.setAccessible(true);
            method.invoke(null); // Since the method is static, we pass null for the instance

        } catch (SecurityException e) {
            // Handle expected exception here if it occurs
        } catch (Exception e) {
            // If any other unexpected exception occurs, fail the test
            e.printStackTrace();
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }


}