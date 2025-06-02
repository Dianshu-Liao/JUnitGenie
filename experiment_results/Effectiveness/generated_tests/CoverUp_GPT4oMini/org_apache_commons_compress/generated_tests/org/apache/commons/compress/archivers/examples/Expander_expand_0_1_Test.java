package org.apache.commons.compress.archivers.examples;

import org.apache.commons.compress.archivers.ArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import org.apache.commons.io.output.NullOutputStream;
import java.lang.reflect.Method;
import java.nio.file.StandardOpenOption;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
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

@ExtendWith(MockitoExtension.class)
class Expander_expand_0_1_Test {

    interface ArchiveEntrySupplier<T> {

        T get();
    }

    interface ArchiveEntryBiConsumer<T> {

        void accept(T entry, OutputStream outputStream) throws IOException;
    }

    @Test
    void testExpandWithNullTargetDirectory() throws Exception {
        Expander expander = new Expander();
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(supplier.get()).thenReturn(entry1, null);
        when(entry1.isDirectory()).thenReturn(false);
        Method method = Expander.class.getDeclaredMethod("expand", ArchiveEntrySupplier.class, ArchiveEntryBiConsumer.class, Path.class);
        method.setAccessible(true);
        method.invoke(expander, supplier, writer, null);
        verify(writer).accept(entry1, NullOutputStream.INSTANCE);
    }

    @Test
    void testExpandWithValidDirectory() throws Exception {
        Expander expander = new Expander();
        Path targetDirectory = Files.createTempDirectory("testExpand");
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(supplier.get()).thenReturn(entry1, null);
        when(entry1.isDirectory()).thenReturn(false);
        when(entry1.resolveIn(targetDirectory)).thenReturn(targetDirectory.resolve("file.txt"));
        Method method = Expander.class.getDeclaredMethod("expand", ArchiveEntrySupplier.class, ArchiveEntryBiConsumer.class, Path.class);
        method.setAccessible(true);
        method.invoke(expander, supplier, writer, targetDirectory);
        verify(writer).accept(entry1, Files.newOutputStream(targetDirectory.resolve("file.txt")));
    }

    @Test
    void testExpandCreatesDirectories() throws Exception {
        Expander expander = new Expander();
        Path targetDirectory = Files.createTempDirectory("testExpand");
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(supplier.get()).thenReturn(entry1, null);
        when(entry1.isDirectory()).thenReturn(true);
        when(entry1.resolveIn(targetDirectory)).thenReturn(targetDirectory.resolve("dir"));
        Method method = Expander.class.getDeclaredMethod("expand", ArchiveEntrySupplier.class, ArchiveEntryBiConsumer.class, Path.class);
        method.setAccessible(true);
        method.invoke(expander, supplier, writer, targetDirectory);
        assertTrue(Files.exists(targetDirectory.resolve("dir")));
    }

    @Test
    void testExpandThrowsIOExceptionOnDirectoryCreationFailure() throws Exception {
        Expander expander = new Expander();
        Path targetDirectory = Paths.get("invalid/directory/path");
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(supplier.get()).thenReturn(entry1, null);
        when(entry1.isDirectory()).thenReturn(true);
        when(entry1.resolveIn(targetDirectory)).thenReturn(targetDirectory.resolve("dir"));
        Method method = Expander.class.getDeclaredMethod("expand", ArchiveEntrySupplier.class, ArchiveEntryBiConsumer.class, Path.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(expander, supplier, writer, targetDirectory);
        });
    }

    @Test
    void testExpandHandlesOutputStreamException() throws Exception {
        Expander expander = new Expander();
        Path targetDirectory = Files.createTempDirectory("testExpand");
        ArchiveEntrySupplier<ArchiveEntry> supplier = mock(ArchiveEntrySupplier.class);
        ArchiveEntryBiConsumer<ArchiveEntry> writer = mock(ArchiveEntryBiConsumer.class);
        ArchiveEntry entry1 = mock(ArchiveEntry.class);
        when(supplier.get()).thenReturn(entry1, null);
        when(entry1.isDirectory()).thenReturn(false);
    }
}
