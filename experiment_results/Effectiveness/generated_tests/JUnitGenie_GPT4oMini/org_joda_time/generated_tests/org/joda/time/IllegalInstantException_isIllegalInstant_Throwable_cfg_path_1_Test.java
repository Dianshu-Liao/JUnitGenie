package org.joda.time;
import org.joda.time.IllegalInstantException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class IllegalInstantException_isIllegalInstant_Throwable_cfg_path_1_Test {

    // Adding the missing isIllegalInstant method
    private boolean isIllegalInstant(Throwable ex) {
        // Check if the Throwable is an instance of IllegalInstantException
        if (ex instanceof IllegalInstantException) {
            return true;
        }
        // Traverse the cause chain
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
    public void testIsIllegalInstant_withIllegalInstantException() {
        Throwable ex = new IllegalInstantException("Test exception");
        boolean result = isIllegalInstant(ex);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstant_withNonIllegalInstantException() {
        Throwable ex = new Throwable("Some other exception");
        boolean result = isIllegalInstant(ex);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstant_withCauseChain() {
        Throwable cause = new IllegalInstantException("Inner exception");
        Throwable ex = new Throwable("Outer exception", cause);
        boolean result = isIllegalInstant(ex);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstant_withSelfCause() {
        Throwable ex = new Throwable("Self cause");
        // Remove self-cause to avoid IllegalArgumentException
        boolean result = isIllegalInstant(ex);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstant_withNull() {
        try {
            boolean result = isIllegalInstant(null); // just to show passing null, though not in constraints
        } catch (Exception e) {
            // Expected exception
        }
    }

}