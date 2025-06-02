package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.JodaTimePermission;
import org.junit.Test;
import java.lang.reflect.Method;

public class DateTimeUtils_checkPermission__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckPermission() {
        try {
            // Access the private static method using reflection
            Method method = DateTimeUtils.class.getDeclaredMethod("checkPermission");
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(null);
        } catch (SecurityException e) {
            // Handle the expected SecurityException
            // This is expected if the security manager denies the permission
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            e.printStackTrace();
        }
    }

}