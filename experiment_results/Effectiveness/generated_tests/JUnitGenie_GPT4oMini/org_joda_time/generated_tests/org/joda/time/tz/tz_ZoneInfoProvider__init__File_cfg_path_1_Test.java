package org.joda.time.tz;
import org.joda.time.tz.ZoneInfoProvider;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.fail;

public class tz_ZoneInfoProvider__init__File_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructor_FileDirectoryDoesNotExist() {
        File nonExistentDir = new File("some/non/existent/directory");
        try {
            ZoneInfoProvider zoneInfoProvider = new ZoneInfoProvider(nonExistentDir);
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            // Expected exception
        } catch (IllegalArgumentException e) {
            fail("Expected IOException but got IllegalArgumentException: " + e.getMessage());
        }
    }

}