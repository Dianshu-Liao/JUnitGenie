package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class compressors_FileNameUtil_getUncompressedFileName_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetUncompressedFileName() {
        // Setup the necessary state for the test
        Map<String, String> uncompressSuffix = new HashMap<>();
        uncompressSuffix.put("zip", ".txt");
        uncompressSuffix.put("gz", ".txt");
        // Set the values for shortest and longest compressed suffixes
        FileNameUtil fileNameUtil = new FileNameUtil(uncompressSuffix, "zip");
        
        // Test case where file name is compressed
        String compressedFileName = "example.zip";
        String expected = "example.txt";
        String actual = fileNameUtil.getUncompressedFileName(compressedFileName);
        assertEquals(expected, actual);
        
        // Test case where file name is not compressed
        compressedFileName = "example.txt";
        expected = "example.txt"; // Should return the same name
        actual = fileNameUtil.getUncompressedFileName(compressedFileName);
        assertEquals(expected, actual);
        
        // Test case where the suffix is unknown
        compressedFileName = "example.unknown";
        expected = "example.unknown"; // Should return the same name
        actual = fileNameUtil.getUncompressedFileName(compressedFileName);
        assertEquals(expected, actual);
    }

}