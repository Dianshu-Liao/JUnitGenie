package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

public class CpioArchiveEntry_CpioArchiveEntry_57_0_Test {

    @Test
    public void testConstructorValidParameters() throws Exception {
        // Example format
        short format = 1;
        String name = "test.txt";
        long size = 1024;
        CpioArchiveEntry entry = createCpioArchiveEntry(format, name, size);
        assertNotNull(entry);
        assertEquals(format, entry.getFormat());
        assertEquals(name, entry.getName());
        assertEquals(size, entry.getSize());
    }

    @Test
    public void testConstructorNegativeSize() {
        // Example format
        short format = 1;
        String name = "test.txt";
        long size = -1;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            createCpioArchiveEntry(format, name, size);
        });
        assertEquals("Invalid entry size <-1>", thrown.getMessage());
    }

    @Test
    public void testConstructorTooLargeSize() {
        // Example format
        short format = 1;
        String name = "test.txt";
        long size = 0xFFFFFFFFL + 1;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            createCpioArchiveEntry(format, name, size);
        });
        assertEquals("Invalid entry size <4294967296>", thrown.getMessage());
    }

    private CpioArchiveEntry createCpioArchiveEntry(short format, String name, long size) throws Exception {
        Constructor<CpioArchiveEntry> constructor = CpioArchiveEntry.class.getDeclaredConstructor(short.class, String.class, long.class);
        constructor.setAccessible(true);
        return constructor.newInstance(format, name, size);
    }
}
