package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

class Expander_expand_0_3_Test {

    interface ArchiveEntrySupplier<T extends ArchiveEntry> {

        T get() throws IOException;
    }

    interface ArchiveEntryBiConsumer<T extends ArchiveEntry> {

        void accept(T entry, OutputStream output) throws IOException;
    }

    @Test
    void testExpand() throws Exception {
        // Arrange
        Expander expander = new Expander();
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        Path targetDirectory = Files.createTempDirectory("testExpand");
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(entry1.isDirectory()).thenReturn(false);
        when(entry1.resolveIn(any())).thenReturn(targetDirectory.resolve("file.txt"));
        ArchiveEntry entry2 = mock(ArchiveEntry.class);
        when(entry2.isDirectory()).thenReturn(true);
        when(entry2.resolveIn(any())).thenReturn(targetDirectory.resolve("dir"));
        when(supplier.get()).thenReturn(entry1).thenReturn(entry2).thenReturn(null);
        // Act
        Method expandMethod = Expander.class.getDeclaredMethod("expand", ArchiveEntrySupplier.class, ArchiveEntryBiConsumer.class, Path.class);
        expandMethod.setAccessible(true);
        expandMethod.invoke(expander, supplier, writer, targetDirectory);
        // Assert
        verify(writer).accept(entry1, any());
        verify(writer, never()).accept(entry2, any());
        assertTrue(Files.exists(targetDirectory.resolve("file.txt")));
        assertTrue(Files.exists(targetDirectory.resolve("dir")));
        // Clean up
        Files.deleteIfExists(targetDirectory.resolve("file.txt"));
        Files.deleteIfExists(targetDirectory.resolve("dir"));
        Files.delete(targetDirectory);
    }
}
