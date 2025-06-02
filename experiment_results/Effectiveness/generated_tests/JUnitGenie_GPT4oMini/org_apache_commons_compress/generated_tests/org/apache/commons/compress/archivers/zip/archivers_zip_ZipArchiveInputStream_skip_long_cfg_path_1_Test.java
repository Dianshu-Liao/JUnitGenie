package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_skip_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSkipNegativeValue() {
        try {
            ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(new ByteArrayInputStream(new byte[]{}));
            zipInputStream.skip(-1);
            fail("Expected IllegalArgumentException for negative skip value");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Did not expect IOException for negative skip value");
        }
    }

}