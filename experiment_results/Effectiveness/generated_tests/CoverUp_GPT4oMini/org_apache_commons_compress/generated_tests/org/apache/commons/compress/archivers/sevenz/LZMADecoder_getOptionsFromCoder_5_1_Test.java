package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.commons.compress.archivers.sevenz.Coder;
import org.tukaani.xz.LZMA2Options;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.LZMAOutputStream;

class LZMADecoder_getOptionsFromCoder_5_1_Test {

    private LZMADecoder lzmaDecoder;

    @BeforeEach
    void setUp() {
        lzmaDecoder = new LZMADecoder();
    }

    @Test
    void testGetOptionsFromCoder_ValidProperties() throws IOException {
        // Arrange
        byte[] properties = new byte[] { 0x1A, 0x00, 0x00, 0x00 };
        Coder coder = new Coder(new byte[0], 1, 1, properties);
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
        // Act
        Object options = lzmaDecoder.getOptionsFromCoder(coder, in);
        // Assert
        assertNotNull(options);
        assertTrue(options instanceof LZMA2Options);
        LZMA2Options lzmaOptions = (LZMA2Options) options;
        assertEquals(1, lzmaOptions.getPb());
        assertEquals(0, lzmaOptions.getLc());
        assertEquals(0, lzmaOptions.getLp());
    }

    @Test
    void testGetOptionsFromCoder_MissingProperties() {
        // Arrange
        Coder coder = new Coder(new byte[0], 1, 1, null);
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            lzmaDecoder.getOptionsFromCoder(coder, in);
        });
        assertEquals("Missing LZMA properties", exception.getMessage());
    }

    @Test
    void testGetOptionsFromCoder_PropertiesTooShort() {
        // Arrange
        byte[] properties = new byte[] {};
        Coder coder = new Coder(new byte[0], 1, 1, properties);
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            lzmaDecoder.getOptionsFromCoder(coder, in);
        });
        assertEquals("LZMA properties too short", exception.getMessage());
    }

    @Test
    void testGetOptionsFromCoder_ValidPropertiesWithDifferentValues() throws IOException {
        // Arrange
        byte[] properties = new byte[] { 0x2A, 0x00, 0x00, 0x00 };
        Coder coder = new Coder(new byte[0], 1, 1, properties);
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[0]);
        // Act
        Object options = lzmaDecoder.getOptionsFromCoder(coder, in);
        // Assert
        assertNotNull(options);
        assertTrue(options instanceof LZMA2Options);
        LZMA2Options lzmaOptions = (LZMA2Options) options;
        assertEquals(2, lzmaOptions.getPb());
        assertEquals(0, lzmaOptions.getLc());
        assertEquals(0, lzmaOptions.getLp());
    }
}
