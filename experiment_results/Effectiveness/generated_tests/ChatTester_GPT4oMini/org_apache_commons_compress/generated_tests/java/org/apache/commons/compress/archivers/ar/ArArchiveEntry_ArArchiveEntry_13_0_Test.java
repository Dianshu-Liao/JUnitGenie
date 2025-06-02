// Test method
package org.apache.commons.compress.archivers.ar;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArArchiveEntry_ArArchiveEntry_13_0_Test {

    private ArArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new ArArchiveEntry("testEntry", 1024);
    }

    @Test
    public void testArArchiveEntryConstructor() {
        // Use reflection to access private fields
        assertEquals("testEntry", getPrivateField(entry, "name"));
        assertEquals(0, getPrivateField(entry, "userId"));
        assertEquals(0, getPrivateField(entry, "groupId"));
        assertEquals(33188, getPrivateField(entry, "mode"));
        assertTrue((long) getPrivateField(entry, "lastModified") > 0);
        assertEquals(1024, getPrivateField(entry, "length"));
    }

    private Object getPrivateField(ArArchiveEntry entry, String fieldName) {
        try {
            java.lang.reflect.Field field = ArArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(entry);
        } catch (Exception e) {
            fail("Failed to access private field: " + fieldName);
            // This line will never be reached due to fail()
            return null;
        }
    }
}
