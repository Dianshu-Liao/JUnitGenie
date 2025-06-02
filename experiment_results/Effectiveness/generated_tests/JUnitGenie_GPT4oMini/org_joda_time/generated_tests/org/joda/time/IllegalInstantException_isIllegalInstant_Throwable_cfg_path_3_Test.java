package org.joda.time;
import org.joda.time.IllegalInstantException;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IllegalInstantException_isIllegalInstant_Throwable_cfg_path_3_Test {

    // Assuming isIllegalInstant is a static method in IllegalInstantException class
    public static boolean isIllegalInstant(Throwable ex) {
        if (ex instanceof IllegalInstantException) {
            return true;
        }
        Throwable cause = ex.getCause();
        while (cause != null) {
            if (cause instanceof IllegalInstantException) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithNonIllegalInstantException() {
        Throwable ex = new Throwable("Some other exception");
        try {
            boolean result = isIllegalInstant(ex);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithIllegalInstantException() {
        Throwable ex = new IllegalInstantException("Illegal instant");
        try {
            boolean result = isIllegalInstant(ex);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithCause() {
        Throwable cause = new IllegalInstantException("Illegal instant");
        Throwable ex = new Throwable("Wrapper exception", cause);
        try {
            boolean result = isIllegalInstant(ex);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}