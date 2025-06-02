package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel;
import org.apache.commons.compress.utils.FileNameUtils;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;

public class ZipSplitReadOnlySeekableByteChannel_buildFromLastSplitSegment_1_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    @BeforeEach
    public void setUp() {
        // Setup any necessary state before each test
    }

    @Test
    public void testBuildFromLastSplitSegment_ValidZipFile() throws IOException {
        // Arrange
        Path lastSegmentPath = createTempZipSplitFile("test.zip", "test.z01", "test.z02");
        // Act
        SeekableByteChannel result = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        // Assert
        assertNotNull(result);
        // Additional assertions can be made based on the expected behavior of the SeekableByteChannel
    }

    @Test
    public void testBuildFromLastSplitSegment_InvalidExtension() {
        // Arrange
        Path lastSegmentPath = Paths.get("test.txt");
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        });
        assertEquals("The extension of last ZIP split segment should be .zip", exception.getMessage());
    }

    @Test
    public void testBuildFromLastSplitSegment_NoParentPath() throws IOException {
        // Arrange
        Path lastSegmentPath = createTempZipSplitFile("test.zip", "test.z01");
        // Act
        SeekableByteChannel result = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        // Assert
        assertNotNull(result);
    }

    private Path createTempZipSplitFile(String zipFileName, String... splitFiles) throws IOException {
        Path tempDir = Files.createTempDirectory("zipSplitTest");
        Path zipFile = tempDir.resolve(zipFileName);
        // Create the main zip file
        Files.createFile(zipFile);
        for (String splitFile : splitFiles) {
            // Create split files
            Files.createFile(tempDir.resolve(splitFile));
        }
        return zipFile;
    }
}
