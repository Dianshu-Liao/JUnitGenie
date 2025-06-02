package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class compressors_FileNameUtil_getUncompressedFileName_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetUncompressedFileName() {
        // Arrange
        Map<String, String> mimeTypes = new HashMap<>();
        String defaultExt = ""; // Provide a default extension if necessary
        FileNameUtil fileNameUtil = new FileNameUtil(mimeTypes, defaultExt);
        String fileName = "example.zip"; // Example input that should trigger the return of the uncompressed name

        // Act
        String result = fileNameUtil.getUncompressedFileName(fileName);

        // Assert
        assertEquals("example", result); // Expected output based on the input
    }


}