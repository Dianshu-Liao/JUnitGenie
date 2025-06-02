package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class compressors_FileNameUtil_getUncompressedFileName_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withCompressedSuffix() {
        // Arrange
        Map<String, String> map = new HashMap<>(); // Create a map for the constructor
        FileNameUtil fileNameUtil = new FileNameUtil(map, ""); // Provide required arguments
        String compressedFileName = "example.zip"; // Example of a compressed file name

        // Act
        String result = fileNameUtil.getUncompressedFileName(compressedFileName);

        // Assert
        assertEquals("example", result); // Expected uncompressed file name
    }

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withoutCompressedSuffix() {
        // Arrange
        Map<String, String> map = new HashMap<>(); // Create a map for the constructor
        FileNameUtil fileNameUtil = new FileNameUtil(map, ""); // Provide required arguments
        String uncompressedFileName = "example.txt"; // Example of a non-compressed file name

        // Act
        String result = fileNameUtil.getUncompressedFileName(uncompressedFileName);

        // Assert
        assertEquals("example.txt", result); // Expected result is the same as input
    }

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withNull() {
        // Arrange
        Map<String, String> map = new HashMap<>(); // Create a map for the constructor
        FileNameUtil fileNameUtil = new FileNameUtil(map, ""); // Provide required arguments
        String nullFileName = null;

        // Act
        String result = null;
        try {
            result = fileNameUtil.getUncompressedFileName(nullFileName);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(null, result); // Expected result is null
    }


}