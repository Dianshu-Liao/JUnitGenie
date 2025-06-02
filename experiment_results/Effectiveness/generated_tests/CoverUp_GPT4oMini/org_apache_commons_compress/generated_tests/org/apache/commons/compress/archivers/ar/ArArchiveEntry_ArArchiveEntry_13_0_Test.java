package org.apache.commons.compress.archivers.ar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ArArchiveEntry_ArArchiveEntry_13_0_Test {

    @Test
    public void testArArchiveEntryConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        String name = "testEntry";
        long length = 1024L;
        // When
        Constructor<ArArchiveEntry> constructor = ArArchiveEntry.class.getDeclaredConstructor(String.class, long.class);
        constructor.setAccessible(true);
        ArArchiveEntry entry = constructor.newInstance(name, length);
        // Then
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        assertEquals(33188, entry.getMode());
        assertNotNull(entry.getLastModifiedDate());
    }

    @Test
    public void testArArchiveEntryConstructorWithNegativeLength() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        String name = "testEntry";
        long length = -1L;
        // When
        Constructor<ArArchiveEntry> constructor = ArArchiveEntry.class.getDeclaredConstructor(String.class, long.class);
        constructor.setAccessible(true);
        ArArchiveEntry entry = constructor.newInstance(name, length);
        // Then
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(length, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        assertEquals(33188, entry.getMode());
        assertNotNull(entry.getLastModifiedDate());
    }
}
