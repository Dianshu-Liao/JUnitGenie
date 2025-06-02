package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class compressors_FileNameUtil_getUncompressedFileName_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withCompressedSuffix() {
        // Setup
        Map<String, String> uncompressSuffixMap = new HashMap<>();
        uncompressSuffixMap.put("zip", ".zip");
        uncompressSuffixMap.put("tar", ".tar");
        uncompressSuffixMap.put("gz", ".gz");

        FileNameUtil fileNameUtil = new FileNameUtil(uncompressSuffixMap, "default");

        // Test case with a compressed file name
        String fileName = "example.zip";
        String expected = "example";
        String actual = fileNameUtil.getUncompressedFileName(fileName);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withoutCompressedSuffix() {
        // Setup
        Map<String, String> uncompressSuffixMap = new HashMap<>();
        uncompressSuffixMap.put("zip", ".zip");
        uncompressSuffixMap.put("tar", ".tar");
        uncompressSuffixMap.put("gz", ".gz");

        FileNameUtil fileNameUtil = new FileNameUtil(uncompressSuffixMap, "default");

        // Test case without a compressed suffix
        String fileName = "example.txt";
        String expected = "example.txt";
        String actual = fileNameUtil.getUncompressedFileName(fileName);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withMultipleCompressedSuffixes() {
        // Setup
        Map<String, String> uncompressSuffixMap = new HashMap<>();
        uncompressSuffixMap.put("zip", ".zip");
        uncompressSuffixMap.put("tar", ".tar");
        uncompressSuffixMap.put("gz", ".gz");

        FileNameUtil fileNameUtil = new FileNameUtil(uncompressSuffixMap, "default");

        // Test case with multiple compressed suffixes
        String fileName = "archive.tar.gz";
        String expected = "archive.tar";
        String actual = fileNameUtil.getUncompressedFileName(fileName);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testGetUncompressedFileName_withEmptyFileName() {
        // Setup
        Map<String, String> uncompressSuffixMap = new HashMap<>();
        uncompressSuffixMap.put("zip", ".zip");
        uncompressSuffixMap.put("tar", ".tar");
        uncompressSuffixMap.put("gz", ".gz");

        FileNameUtil fileNameUtil = new FileNameUtil(uncompressSuffixMap, "default");

        // Test case with an empty file name
        String fileName = "";
        String expected = "";
        String actual = fileNameUtil.getUncompressedFileName(fileName);
        assertEquals(expected, actual);
    }

}