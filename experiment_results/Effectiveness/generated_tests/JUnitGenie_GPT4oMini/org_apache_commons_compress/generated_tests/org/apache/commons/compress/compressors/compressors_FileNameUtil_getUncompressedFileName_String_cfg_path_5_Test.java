package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class compressors_FileNameUtil_getUncompressedFileName_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetUncompressedFileName() {
        // Arrange
        Map<String, String> fileTypeMap = new HashMap<>();
        String defaultCompressor = "zip"; // Default compressor type
        FileNameUtil fileNameUtil = new FileNameUtil(fileTypeMap, defaultCompressor);
        String inputFileName = "example.zip"; // Example input
        String expectedOutput = "example"; // Expected output after uncompression

        // Act
        String result = fileNameUtil.getUncompressedFileName(inputFileName);

        // Assert
        assertEquals(expectedOutput, result);
    }


}