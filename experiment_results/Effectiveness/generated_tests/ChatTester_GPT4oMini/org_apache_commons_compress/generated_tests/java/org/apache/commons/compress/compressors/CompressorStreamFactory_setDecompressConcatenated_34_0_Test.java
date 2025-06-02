package org.apache.commons.compress.compressors;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream;
import org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.compress.compressors.xz.XZUtils;
import org.apache.commons.compress.compressors.z.ZCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Sets;

class CompressorStreamFactory_setDecompressConcatenated_34_0_Test {

    private CompressorStreamFactory compressorStreamFactory;

    @BeforeEach
    void setUp() {
        compressorStreamFactory = new CompressorStreamFactory();
    }

    @Test
    void testSetDecompressConcatenated_Success() throws Exception {
        // Arrange
        boolean expectedValue = true;
        // Act
        invokeSetDecompressConcatenated(compressorStreamFactory, expectedValue);
        // Assert
        Field field = CompressorStreamFactory.class.getDeclaredField("decompressConcatenated");
        field.setAccessible(true);
        boolean actualValue = (boolean) field.get(compressorStreamFactory);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testSetDecompressConcatenated_ThrowsIllegalStateException() {
        // Arrange
        // Setting decompressUntilEof
        compressorStreamFactory = new CompressorStreamFactory(true);
        // Act & Assert
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            invokeSetDecompressConcatenated(compressorStreamFactory, true);
        });
        assertEquals("Cannot override the setting defined by the constructor", thrown.getMessage());
    }

    private void invokeSetDecompressConcatenated(CompressorStreamFactory factory, boolean value) throws Exception {
        Method method = CompressorStreamFactory.class.getDeclaredMethod("setDecompressConcatenated", boolean.class);
        method.setAccessible(true);
        method.invoke(factory, value);
    }
}
