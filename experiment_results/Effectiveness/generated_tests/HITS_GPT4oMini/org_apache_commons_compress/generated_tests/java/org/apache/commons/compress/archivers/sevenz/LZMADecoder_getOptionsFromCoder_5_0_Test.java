package org.apache.commons.compress.archivers.sevenz;

import org.tukaani.xz.LZMA2Options;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

class LZMADecoder_getOptionsFromCoder_5_0_Test {

    private final LZMADecoder lzmaDecoder = new LZMADecoder();

    @Test
    void testGetOptionsFromCoder_ValidProperties() throws IOException {
        // Example properties byte
        byte[] properties = { 0x1F };
        Coder coder = new Coder(new byte[] { 0x00 }, 1, 1, properties);
        LZMA2Options options = (LZMA2Options) lzmaDecoder.getOptionsFromCoder(coder, new ByteArrayInputStream(new byte[0]));
        Assertions.assertNotNull(options);
        Assertions.assertEquals(1, options.getPb());
        Assertions.assertEquals(0, options.getLc());
        Assertions.assertEquals(0, options.getLp());
    }

    @Test
    void testGetOptionsFromCoder_MissingProperties() {
        Coder coder = new Coder(new byte[] { 0x00 }, 1, 1, null);
        Assertions.assertThrows(IOException.class, () -> {
            lzmaDecoder.getOptionsFromCoder(coder, new ByteArrayInputStream(new byte[0]));
        });
    }

    @Test
    void testGetOptionsFromCoder_EmptyProperties() {
        byte[] properties = {};
        Coder coder = new Coder(new byte[] { 0x00 }, 1, 1, properties);
        Assertions.assertThrows(IOException.class, () -> {
            lzmaDecoder.getOptionsFromCoder(coder, new ByteArrayInputStream(new byte[0]));
        });
    }

    @Test
    void testGetOptionsFromCoder_ValidPropertiesWithDifferentValues() throws IOException {
        // Another example properties byte
        byte[] properties = { 0x2F };
        Coder coder = new Coder(new byte[] { 0x00 }, 1, 1, properties);
        LZMA2Options options = (LZMA2Options) lzmaDecoder.getOptionsFromCoder(coder, new ByteArrayInputStream(new byte[0]));
        Assertions.assertNotNull(options);
        Assertions.assertEquals(2, options.getPb());
        Assertions.assertEquals(0, options.getLc());
        Assertions.assertEquals(1, options.getLp());
    }

    @Test
    void testGetOptionsFromCoder_PropertiesWithHighValues() throws IOException {
        // High properties byte
        byte[] properties = { 0x7F };
        Coder coder = new Coder(new byte[] { 0x00 }, 1, 1, properties);
        LZMA2Options options = (LZMA2Options) lzmaDecoder.getOptionsFromCoder(coder, new ByteArrayInputStream(new byte[0]));
        Assertions.assertNotNull(options);
        Assertions.assertEquals(7, options.getPb());
        Assertions.assertEquals(8, options.getLc());
        Assertions.assertEquals(0, options.getLp());
    }
}
