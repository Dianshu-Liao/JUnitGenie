package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

public class CpioArchiveEntry_CpioArchiveEntry_59_1_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new CpioArchiveEntry("testFile", 1000);
    }

    @Test
    public void testConstructorWithNameAndSize() {
        assertNotNull(entry);
    }

    @Test
    public void testConstructorSetsName() throws Exception {
        Constructor<CpioArchiveEntry> constructor = CpioArchiveEntry.class.getDeclaredConstructor(String.class, long.class);
        constructor.setAccessible(true);
        CpioArchiveEntry entry = constructor.newInstance("testFile", 1000);
        Field nameField = CpioArchiveEntry.class.getDeclaredField("name");
        nameField.setAccessible(true);
        String name = (String) nameField.get(entry);
        assertEquals("testFile", name);
    }

    @Test
    public void testConstructorSetsSize() throws Exception {
        Constructor<CpioArchiveEntry> constructor = CpioArchiveEntry.class.getDeclaredConstructor(String.class, long.class);
        constructor.setAccessible(true);
        CpioArchiveEntry entry = constructor.newInstance("testFile", 1000);
        Field sizeField = CpioArchiveEntry.class.getDeclaredField("fileSize");
        sizeField.setAccessible(true);
        long size = (long) sizeField.get(entry);
        assertEquals(1000, size);
    }

    @Test
    public void testConstructorWithNegativeSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry("testFile", -1);
        });
        String expectedMessage = "Invalid entry size <-1>";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
