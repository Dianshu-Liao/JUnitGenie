package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.io.input.BoundedInputStream;

class TarArchiveInputStream_consumeRemainderOfLastBlock_6_2_Test {

    private TarArchiveInputStream tarInputStream;

    @BeforeEach
    void setUp() {
        // Example input stream with tar data
        byte[] tarData = new byte[512];
        InputStream inputStream = new ByteArrayInputStream(tarData);
        // Example block size
        tarInputStream = new TarArchiveInputStream(inputStream, 512);
    }

    @Test
    void testConsumeRemainderOfLastBlock() throws Exception {
        // Set up the state for the test
        setPrivateField(tarInputStream, "entrySize", 1024L);
        setPrivateField(tarInputStream, "entryOffset", 500L);
        // Invoke the private method using reflection
        Method method = TarArchiveInputStream.class.getDeclaredMethod("consumeRemainderOfLastBlock");
        method.setAccessible(true);
        // Execute the method
        assertDoesNotThrow(() -> method.invoke(tarInputStream));
    }

    private void setPrivateField(TarArchiveInputStream instance, String fieldName, Object value) throws Exception {
        Field field = TarArchiveInputStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }
}
