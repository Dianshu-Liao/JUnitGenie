package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Instant;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_tar_TarArchiveEntry_parseInstantFromDecimalSeconds_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testParseInstantFromDecimalSeconds_ValidInput() {
        String value = "1609459200.000000000";  // Example for Jan 1, 2021 00:00:00 GMT
        try {
            Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
            method.setAccessible(true);
            Instant result = (Instant) method.invoke(null, value);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Expected valid Instant, but an exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseInstantFromDecimalSeconds_InvalidPattern() {
        String value = "invalid_value";
        try {
            Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
            method.setAccessible(true);
            method.invoke(null, value);
            fail("Expected IllegalArgumentException due to invalid pattern, but none was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Corrupted PAX header. Time field value is invalid 'invalid_value'", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but an unexpected exception type was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseInstantFromDecimalSeconds_Overflow() {
        String value = "9999999999.999999999"; // A value that is too large, causing overflow
        try {
            Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
            method.setAccessible(true);
            method.invoke(null, value);
            fail("Expected IllegalArgumentException due to overflow, but none was thrown.");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getCause() instanceof ArithmeticException);
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but an unexpected exception type was thrown: " + e.getMessage());
        }
    }


}