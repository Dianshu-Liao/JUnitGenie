package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.lang.reflect.Method;
import java.time.Instant;
import static org.junit.Assert.fail;

public class archivers_tar_TarArchiveEntry_parseInstantFromDecimalSeconds_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testParseInstantFromDecimalSecondsInvalidPattern() {
        String invalidValue = "invalid value";

        try {
            // Accessing the private static method using reflection
            Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
            method.setAccessible(true);
            method.invoke(null, invalidValue); // Invoke the static method

            // If no exception is thrown, the test should fail
            fail("Expected an exception was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception caught - test passes
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }


}