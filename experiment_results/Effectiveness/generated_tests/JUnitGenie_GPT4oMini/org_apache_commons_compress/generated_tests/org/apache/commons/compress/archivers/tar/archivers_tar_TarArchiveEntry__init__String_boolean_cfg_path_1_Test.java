package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarArchiveEntry__init__String_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        String name = "testFile.txt";
        boolean preserveAbsolutePath = false;

        try {
            TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);
            assertNotNull(entry);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithDirectoryName() {
        String name = "testDirectory/";
        boolean preserveAbsolutePath = true;

        try {
            TarArchiveEntry entry = new TarArchiveEntry(name, preserveAbsolutePath);
            assertNotNull(entry);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}