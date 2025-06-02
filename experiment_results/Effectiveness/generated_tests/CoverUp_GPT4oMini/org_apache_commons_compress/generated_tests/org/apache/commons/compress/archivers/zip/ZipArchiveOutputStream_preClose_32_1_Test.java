package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.utils.ByteUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.io.Charsets;

class ZipArchiveOutputStream_preClose_32_1_Test {

    private ZipArchiveOutputStream zipOutputStream;

    @BeforeEach
    void setUp() throws IOException {
        zipOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    void testPreClose_AlreadyFinished() throws Exception {
        Method preCloseMethod = ZipArchiveOutputStream.class.getDeclaredMethod("preClose");
        preCloseMethod.setAccessible(true);
        // Simulate finished state
        setPrivateField(zipOutputStream, "finished", true);
        Exception exception = assertThrows(IOException.class, () -> {
            preCloseMethod.invoke(zipOutputStream);
        });
        assertEquals("Stream has already been finished", exception.getMessage());
    }

    @Test
    void testPreClose_NoCurrentEntry() throws Exception {
        Method preCloseMethod = ZipArchiveOutputStream.class.getDeclaredMethod("preClose");
        preCloseMethod.setAccessible(true);
        // Simulate no current entry
        setPrivateField(zipOutputStream, "entry", null);
        Exception exception = assertThrows(IOException.class, () -> {
            preCloseMethod.invoke(zipOutputStream);
        });
        assertEquals("No current entry to close", exception.getMessage());
    }

    @Test
    void testPreClose_EntryNotWritten() throws Exception {
        Method preCloseMethod = ZipArchiveOutputStream.class.getDeclaredMethod("preClose");
        preCloseMethod.setAccessible(true);
        // Simulate a current entry that has not been written
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        setPrivateField(zipOutputStream, "entry", entry);
        setPrivateField(entry, "hasWritten", false);
        // Mock write method
        zipOutputStream.write(ByteUtils.EMPTY_BYTE_ARRAY, 0, 0);
        // Check that preClose does not throw an exception
        assertDoesNotThrow(() -> {
            preCloseMethod.invoke(zipOutputStream);
        });
    }

    @Test
    void testPreClose_EntryAlreadyWritten() throws Exception {
        Method preCloseMethod = ZipArchiveOutputStream.class.getDeclaredMethod("preClose");
        preCloseMethod.setAccessible(true);
        // Simulate a current entry that has been written
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        setPrivateField(zipOutputStream, "entry", entry);
        setPrivateField(entry, "hasWritten", true);
        // Check that preClose does not throw an exception
        assertDoesNotThrow(() -> {
            preCloseMethod.invoke(zipOutputStream);
        });
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
