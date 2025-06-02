package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
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
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.file.attribute.FileTimes;

class ZipArchiveEntry_setSize_82_0_Test {

    @Test
    void testSetSize_ValidSize() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    void testSetSize_ZeroSize() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        entry.setSize(0);
        assertEquals(0, entry.getSize());
    }

    @Test
    void testSetSize_NegativeSize() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size", thrown.getMessage());
    }

    @Test
    void testSetSize_LargeSize() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testEntry");
        entry.setSize(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, entry.getSize());
    }
}
