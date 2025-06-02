package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveEntry__init__short_Path_String_LinkOption_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConstructorThrowsIllegalArgumentException() {
        short format = 1;
        Path inputPath = Paths.get("nonexistentfile.txt"); // A path that does not exist
        String entryName = "testEntry";
        LinkOption[] options = new LinkOption[]{};

        try {
            new CpioArchiveEntry(format, inputPath, entryName, options);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Expected IllegalArgumentException but got IOException: " + e.getMessage());
        }
    }

}