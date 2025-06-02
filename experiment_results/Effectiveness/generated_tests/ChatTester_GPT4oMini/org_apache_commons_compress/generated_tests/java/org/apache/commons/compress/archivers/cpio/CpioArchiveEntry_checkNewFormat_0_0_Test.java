package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_checkNewFormat_0_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize with a valid file format for testing
        // Assuming FORMAT_NEW_MASK is 1 for this example
        entry = new CpioArchiveEntry((short) 1);
    }

    @Test
    public void testCheckNewFormat_ValidFormat() throws Exception {
        // Set fileFormat to a value that satisfies the condition
        // Assuming FORMAT_NEW_MASK is 1
        setPrivateField(entry, "fileFormat", (short) 1);
        // Invoke the private method
        invokePrivateMethod(entry, "checkNewFormat");
        // If no exception is thrown, the test passes
    }

    @Test
    public void testCheckNewFormat_InvalidFormat() {
        // Set fileFormat to a value that does not satisfy the condition
        // Assuming FORMAT_NEW_MASK is 1
        setPrivateField(entry, "fileFormat", (short) 0);
        // Expect an exception to be thrown
        assertThrows(UnsupportedOperationException.class, () -> {
            invokePrivateMethod(entry, "checkNewFormat");
        });
    }

    private void setPrivateField(Object instance, String fieldName, Object value) {
        try {
            // Fixed the buggy line by using Field instead of var
            java.lang.reflect.Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }

    private void invokePrivateMethod(Object instance, String methodName) {
        try {
            Method method = instance.getClass().getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(instance);
        } catch (Exception e) {
            fail("Failed to invoke private method: " + e.getMessage());
        }
    }
}
