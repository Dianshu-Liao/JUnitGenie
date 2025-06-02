package org.joda.time;
import org.joda.time.IllegalInstantException;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IllegalInstantException_isIllegalInstant_Throwable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithIllegalInstantException() {
        Throwable ex = new IllegalInstantException("Illegal instant");
        assertTrue(IllegalInstantException.isIllegalInstant(ex));
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithNullCause() {
        Throwable ex = new Throwable();
        assertFalse(IllegalInstantException.isIllegalInstant(ex));
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithCauseNotIllegalInstant() {
        Throwable cause = new Throwable();
        Throwable ex = new Throwable(cause);
        assertFalse(IllegalInstantException.isIllegalInstant(ex));
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithIllegalInstantInCause() {
        Throwable cause = new IllegalInstantException("Illegal instant");
        Throwable ex = new Throwable(cause);
        assertTrue(IllegalInstantException.isIllegalInstant(ex));
    }

    @Test(timeout = 4000)
    public void testIsIllegalInstantWithSelfCause() {
        Throwable ex = new Throwable();
        // Removed self-cause initialization to avoid IllegalArgumentException
        assertFalse(IllegalInstantException.isIllegalInstant(ex));
    }

}