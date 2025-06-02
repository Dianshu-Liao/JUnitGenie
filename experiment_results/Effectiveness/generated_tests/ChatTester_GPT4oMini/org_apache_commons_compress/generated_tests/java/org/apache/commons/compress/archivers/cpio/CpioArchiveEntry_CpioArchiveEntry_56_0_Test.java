package org.apache.commons.compress.archivers.cpio;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class CpioArchiveEntry_CpioArchiveEntry_56_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize the CpioArchiveEntry with a valid format and name
        entry = new CpioArchiveEntry((short) 1, "testEntry");
    }

    @Test
    public void testConstructorWithFormatAndName() {
        // Test if the entry is created with the correct name
        assertEquals("testEntry", entry.getName());
        // Additional assertions can be added here if more getters are available
    }

    @Test
    public void testConstructorWithDifferentFormat() {
        // Create a new entry with a different format
        CpioArchiveEntry entry2 = new CpioArchiveEntry((short) 2, "anotherEntry");
        assertEquals("anotherEntry", entry2.getName());
    }

    @Test
    public void testConstructorWithNullName() {
        // Test with a null name
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry((short) 1, null);
        });
    }

    // Reflection test to access private fields (if needed)
    @Test
    public void testPrivateFields() throws Exception {
        // Access the private field 'name' using reflection
        java.lang.reflect.Field nameField = CpioArchiveEntry.class.getDeclaredField("name");
        nameField.setAccessible(true);
        // Verify the name field value
        assertEquals("testEntry", nameField.get(entry));
    }
}
