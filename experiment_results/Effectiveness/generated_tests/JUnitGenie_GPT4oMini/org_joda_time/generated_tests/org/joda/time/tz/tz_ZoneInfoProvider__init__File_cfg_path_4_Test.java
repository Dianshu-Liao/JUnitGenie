package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoProvider;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.fail;

public class tz_ZoneInfoProvider__init__File_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConstructorThrowsIllegalArgumentExceptionWhenFileDirIsNull() {
        try {
            new ZoneInfoProvider((File) null); // Explicitly casting to File to resolve ambiguity
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Expected IllegalArgumentException but got IOException: " + e.getMessage());
        }
    }

    // Additional tests for other exceptions can be defined here.


}