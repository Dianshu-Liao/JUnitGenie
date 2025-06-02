package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel;
import java.io.File;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;

class ZipSplitReadOnlySeekableByteChannel_buildFromLastSplitSegment_0_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    @BeforeEach
    void setUp() throws IOException {
        // Setup a mock or a real instance if needed
        zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(Collections.emptyList());
    }

    @Test
    void testBuildFromLastSplitSegment_validZipFile() throws IOException {
        // Create a temporary ZIP file for testing
        Path tempZipFile = Files.createTempFile("testZipFile", ".zip");
        Files.write(tempZipFile, "dummy zip content".getBytes());
        // Create a valid last segment file
        Path lastSegmentFile = Files.createTempFile("testZipFile.z01", "");
        // Invoke the focal method
        SeekableByteChannel channel = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentFile.toFile());
        assertNotNull(channel);
        assertTrue(channel.isOpen());
        // Clean up
        channel.close();
        Files.deleteIfExists(lastSegmentFile);
        Files.deleteIfExists(tempZipFile);
    }

    @Test
    void testBuildFromLastSplitSegment_invalidExtension() {
        // Create a temporary file with an invalid extension
        File invalidFile = new File("invalidFile.txt");
        // Expect an IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(invalidFile);
        });
        assertEquals("The extension of last ZIP split segment should be .zip", exception.getMessage());
    }

    @Test
    void testBuildFromLastSplitSegment_noFilesFound() throws IOException {
        // Create a temporary ZIP file for testing
        Path tempZipFile = Files.createTempFile("testZipFile", ".zip");
        Path lastSegmentFile = Files.createTempFile("testZipFile.z01", "");
        // Clean up the directory to simulate no files found
        Files.delete(lastSegmentFile);
        // Expect an IOException when no files are found
        Exception exception = assertThrows(IOException.class, () -> {
            ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentFile.toFile());
        });
        assertTrue(exception.getMessage().contains("No files found"));
        // Clean up
        Files.deleteIfExists(tempZipFile);
    }
}
