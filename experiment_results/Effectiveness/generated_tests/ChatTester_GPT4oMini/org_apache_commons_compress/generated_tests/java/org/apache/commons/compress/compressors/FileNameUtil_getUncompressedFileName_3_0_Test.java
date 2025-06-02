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

public class FileNameUtil_getUncompressedFileName_3_0_Test {

    private FileNameUtil fileNameUtil;

    @BeforeEach
    public void setUp() {
        Map<String, String> uncompressSuffix = new HashMap<>();
        uncompressSuffix.put("zip", ".txt");
        uncompressSuffix.put("tar", ".doc");
        uncompressSuffix.put("gz", ".pdf");
        String defaultExtension = ".bin";
        fileNameUtil = new FileNameUtil(uncompressSuffix, defaultExtension);
    }

    @Test
    public void testGetUncompressedFileName_WithCompressedSuffix() {
        String result = fileNameUtil.getUncompressedFileName("document.zip");
        assertEquals("document.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithAnotherCompressedSuffix() {
        String result = fileNameUtil.getUncompressedFileName("archive.tar");
        assertEquals("archive.doc", result);
    }

    @Test
    public void testGetUncompressedFileName_WithDifferentCompressedSuffix() {
        String result = fileNameUtil.getUncompressedFileName("file.gz");
        assertEquals("file.pdf", result);
    }

    @Test
    public void testGetUncompressedFileName_WithNoCompressedSuffix() {
        String result = fileNameUtil.getUncompressedFileName("image.png");
        assertEquals("image.png", result);
    }

    @Test
    public void testGetUncompressedFileName_WithEmptyFileName() {
        String result = fileNameUtil.getUncompressedFileName("");
        assertEquals("", result);
    }

    @Test
    public void testGetUncompressedFileName_WithNullFileName() {
        String result = fileNameUtil.getUncompressedFileName(null);
        assertNull(result);
    }

    @Test
    public void testGetUncompressedFileName_WithMultipleCompressedSuffixes() {
        String result = fileNameUtil.getUncompressedFileName("archive.tar.gz");
        assertEquals("archive.tar.pdf", result);
    }

    @Test
    public void testGetUncompressedFileName_WithLongFileName() {
        String result = fileNameUtil.getUncompressedFileName("verylongfilename.zip");
        assertEquals("verylongfilename.txt", result);
    }
}
