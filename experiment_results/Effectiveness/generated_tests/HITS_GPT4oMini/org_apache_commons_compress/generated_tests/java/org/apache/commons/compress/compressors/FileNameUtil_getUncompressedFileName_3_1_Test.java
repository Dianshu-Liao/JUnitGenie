package org.apache.commons.compress.compressors;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;

public class FileNameUtil_getUncompressedFileName_3_1_Test {

    private FileNameUtil fileNameUtil;

    @BeforeEach
    public void setUp() {
        Map<String, String> uncompressSuffix = new HashMap<>();
        uncompressSuffix.put("zip", ".txt");
        uncompressSuffix.put("gz", ".txt");
        uncompressSuffix.put("bz2", ".txt");
        // Initialize FileNameUtil with the required parameters
        fileNameUtil = new FileNameUtil(uncompressSuffix, "txt");
        // Set the suffix lengths directly in the constructor or modify the class to support this
        // Assuming the constructor correctly sets these values
    }

    @Test
    public void testGetUncompressedFileName_WithZipSuffix() {
        String result = fileNameUtil.getUncompressedFileName("example.zip");
        assertEquals("example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithGzSuffix() {
        String result = fileNameUtil.getUncompressedFileName("example.gz");
        assertEquals("example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithBz2Suffix() {
        String result = fileNameUtil.getUncompressedFileName("example.bz2");
        assertEquals("example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithNoCompressedSuffix() {
        String result = fileNameUtil.getUncompressedFileName("example.txt");
        assertEquals("example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithMixedCaseSuffix() {
        String result = fileNameUtil.getUncompressedFileName("example.ZIP");
        assertEquals("example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithLongerFileName() {
        String result = fileNameUtil.getUncompressedFileName("archive.example.zip");
        assertEquals("archive.example.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithEmptyFileName() {
        String result = fileNameUtil.getUncompressedFileName("");
        assertEquals("", result);
    }

    @Test
    public void testGetUncompressedFileName_WithNullFileName() {
        String result = fileNameUtil.getUncompressedFileName(null);
        assertEquals(null, result);
    }
}
