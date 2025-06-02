package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

class TarArchiveEntry_isSymbolicLink_64_0_Test {

    @Test
    void testIsSymbolicLink() throws Exception {
        // Create an instance of TarArchiveEntry for a symbolic link
        // Assuming 12 is the link flag for symbolic links
        TarArchiveEntry symlinkEntry = new TarArchiveEntry("symlink", (byte) 12);
        // Use reflection to set the private field linkFlag
        setPrivateField(symlinkEntry, "linkFlag", (byte) 12);
        assertTrue(symlinkEntry.isSymbolicLink());
        // Create an instance of TarArchiveEntry for a regular file
        // Assuming 0 is the link flag for regular files
        TarArchiveEntry regularFileEntry = new TarArchiveEntry("file.txt", (byte) 0);
        // Use reflection to set the private field linkFlag
        setPrivateField(regularFileEntry, "linkFlag", (byte) 0);
        assertFalse(regularFileEntry.isSymbolicLink());
        // Create an instance of TarArchiveEntry for a directory
        // Assuming 5 is the link flag for directories
        TarArchiveEntry directoryEntry = new TarArchiveEntry("directory/", (byte) 5);
        // Use reflection to set the private field linkFlag
        setPrivateField(directoryEntry, "linkFlag", (byte) 5);
        assertFalse(directoryEntry.isSymbolicLink());
    }

    private void setPrivateField(TarArchiveEntry entry, String fieldName, byte value) throws Exception {
        java.lang.reflect.Field field = TarArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(entry, value);
    }
}
