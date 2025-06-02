package org.apache.commons.compress.compressors;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Locale;

public class FileNameUtil_getUncompressedFileName_3_1_Test {

    private FileNameUtil fileNameUtil;

    @BeforeEach
    public void setUp() {
        Map<String, String> uncompressSuffix = new HashMap<>();
        uncompressSuffix.put(".zip", ".txt");
        uncompressSuffix.put(".tar", ".txt");
        uncompressSuffix.put(".gz", ".txt");
        String defaultExtension = ".txt";
        fileNameUtil = new FileNameUtil(uncompressSuffix, defaultExtension);
        // Using reflection to set private fields for testing
        try {
            java.lang.reflect.Field compressSuffixField = FileNameUtil.class.getDeclaredField("compressSuffix");
            compressSuffixField.setAccessible(true);
            compressSuffixField.set(fileNameUtil, new HashMap<String, String>() {

                {
                    put(".zip", ".txt");
                    put(".tar", ".txt");
                    put(".gz", ".txt");
                }
            });
            java.lang.reflect.Field longestCompressedSuffixField = FileNameUtil.class.getDeclaredField("longestCompressedSuffix");
            longestCompressedSuffixField.setAccessible(true);
            // Length of ".gz"
            longestCompressedSuffixField.setInt(fileNameUtil, 4);
            java.lang.reflect.Field shortestCompressedSuffixField = FileNameUtil.class.getDeclaredField("shortestCompressedSuffix");
            shortestCompressedSuffixField.setAccessible(true);
            // Length of ".zip"
            shortestCompressedSuffixField.setInt(fileNameUtil, 3);
            java.lang.reflect.Field longestUncompressedSuffixField = FileNameUtil.class.getDeclaredField("longestUncompressedSuffix");
            longestUncompressedSuffixField.setAccessible(true);
            // Length of ".txt"
            longestUncompressedSuffixField.setInt(fileNameUtil, 4);
            java.lang.reflect.Field shortestUncompressedSuffixField = FileNameUtil.class.getDeclaredField("shortestUncompressedSuffix");
            shortestUncompressedSuffixField.setAccessible(true);
            // Length of ".txt"
            shortestUncompressedSuffixField.setInt(fileNameUtil, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUncompressedFileName_WithZipSuffix() {
        String result = fileNameUtil.getUncompressedFileName("file.zip");
        assertEquals("file.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithTarSuffix() {
        String result = fileNameUtil.getUncompressedFileName("archive.tar");
        assertEquals("archive.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_WithGzSuffix() {
        String result = fileNameUtil.getUncompressedFileName("data.gz");
        assertEquals("data.txt", result);
    }

    @Test
    public void testGetUncompressedFileName_NoSuffix() {
        String result = fileNameUtil.getUncompressedFileName("document");
        assertEquals("document", result);
    }

    @Test
    public void testGetUncompressedFileName_EmptyString() {
        String result = fileNameUtil.getUncompressedFileName("");
        assertEquals("", result);
    }

    @Test
    public void testGetUncompressedFileName_NullInput() {
        String result = fileNameUtil.getUncompressedFileName(null);
        assertEquals(null, result);
    }
}
