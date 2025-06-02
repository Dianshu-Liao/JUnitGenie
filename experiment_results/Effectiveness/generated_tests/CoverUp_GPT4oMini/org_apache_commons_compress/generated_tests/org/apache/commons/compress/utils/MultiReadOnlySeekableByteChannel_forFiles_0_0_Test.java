package org.apache.commons.compress.utils;

import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

class MultiReadOnlySeekableByteChannel_forFiles_0_0_Test {

    private File tempFile1;

    private File tempFile2;

    @BeforeEach
    void setUp() throws IOException {
        // Create temporary files for testing
        tempFile1 = Files.createTempFile("testFile1", ".txt").toFile();
        tempFile2 = Files.createTempFile("testFile2", ".txt").toFile();
    }

    @Test
    void testForFiles_withMultipleFiles() throws IOException {
        // Given
        File[] files = { tempFile1, tempFile2 };
        // When
        SeekableByteChannel channel = MultiReadOnlySeekableByteChannel.forFiles(files);
        // Then
        assertNotNull(channel);
        assertTrue(channel instanceof MultiReadOnlySeekableByteChannel);
    }

    @Test
    void testForFiles_withSingleFile() throws IOException {
        // Given
        File[] files = { tempFile1 };
        // When
        SeekableByteChannel channel = MultiReadOnlySeekableByteChannel.forFiles(files);
        // Then
        assertNotNull(channel);
        assertFalse(channel instanceof MultiReadOnlySeekableByteChannel);
    }

    @Test
    void testForFiles_withNullFiles() {
        // Given
        File[] files = null;
        // When & Then
        Exception exception = assertThrows(NullPointerException.class, () -> {
            MultiReadOnlySeekableByteChannel.forFiles(files);
        });
        assertEquals("files", exception.getMessage());
    }

    @Test
    void testForFiles_withEmptyArray() throws IOException {
        // Given
        File[] files = {};
        // When
        SeekableByteChannel channel = MultiReadOnlySeekableByteChannel.forFiles(files);
        // Then
        assertNotNull(channel);
        assertTrue(channel instanceof MultiReadOnlySeekableByteChannel);
    }

    @Test
    void testForFiles_withNonExistentFile() {
        // Given
        File[] files = { new File("nonExistentFile.txt") };
        // When & Then
        Exception exception = assertThrows(IOException.class, () -> {
            MultiReadOnlySeekableByteChannel.forFiles(files);
        });
        assertNotNull(exception);
    }

    @Test
    void testForFiles_withFilesHavingNoReadPermission() throws IOException {
        // Given
        File noReadPermissionFile = Files.createTempFile("noReadPermissionFile", ".txt").toFile();
        noReadPermissionFile.setReadable(false);
        File[] files = { noReadPermissionFile };
        // When & Then
        Exception exception = assertThrows(IOException.class, () -> {
            MultiReadOnlySeekableByteChannel.forFiles(files);
        });
        assertNotNull(exception);
    }

    // Clean up temporary files after tests
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        if (tempFile1 != null) {
            tempFile1.delete();
        }
        if (tempFile2 != null) {
            tempFile2.delete();
        }
    }
}
