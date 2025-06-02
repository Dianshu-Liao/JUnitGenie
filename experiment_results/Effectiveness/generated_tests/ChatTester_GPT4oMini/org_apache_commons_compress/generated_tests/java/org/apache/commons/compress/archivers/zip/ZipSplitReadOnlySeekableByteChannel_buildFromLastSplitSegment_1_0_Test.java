package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.utils.FileNameUtils;
import org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel;

class ZipSplitReadOnlySeekableByteChannel_buildFromLastSplitSegment_1_0_Test {

    private ZipSplitReadOnlySeekableByteChannel zipSplitReadOnlySeekableByteChannel;

    @BeforeEach
    void setUp() throws IOException {
        List<SeekableByteChannel> channels = new ArrayList<>();
        zipSplitReadOnlySeekableByteChannel = new ZipSplitReadOnlySeekableByteChannel(channels);
    }

    @Test
    void testBuildFromLastSplitSegment_ValidZipFile() throws IOException {
        Path lastSegmentPath = Paths.get("test.z01");
        Path parentPath = lastSegmentPath.getParent() != null ? lastSegmentPath.getParent() : lastSegmentPath.getFileSystem().getPath(".");
        Files.createDirectories(parentPath);
        Files.createFile(parentPath.resolve("test.z01"));
        Files.createFile(parentPath.resolve("test.z02"));
        SeekableByteChannel channel = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        Assertions.assertNotNull(channel);
        // Additional assertions can be added based on expected behavior of forPaths method
    }

    @Test
    void testBuildFromLastSplitSegment_InvalidExtension() {
        Path lastSegmentPath = Paths.get("test.txt");
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath));
        Assertions.assertEquals("The extension of last ZIP split segment should be .zip", exception.getMessage());
    }

    @Test
    void testBuildFromLastSplitSegment_NoParentPath() throws IOException {
        Path lastSegmentPath = Paths.get("test.z01");
        Path parentPath = lastSegmentPath.getFileSystem().getPath(".");
        Files.createDirectories(parentPath);
        Files.createFile(parentPath.resolve("test.z01"));
        Files.createFile(parentPath.resolve("test.z02"));
        SeekableByteChannel channel = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        Assertions.assertNotNull(channel);
    }

    @Test
    void testBuildFromLastSplitSegment_NoFilesFound() throws IOException {
        Path lastSegmentPath = Paths.get("test.z01");
        Path parentPath = lastSegmentPath.getParent() != null ? lastSegmentPath.getParent() : lastSegmentPath.getFileSystem().getPath(".");
        // Ensure the parent directory exists but contains no files
        Files.createDirectories(parentPath);
        SeekableByteChannel channel = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        Assertions.assertNotNull(channel);
        // Additional assertions can be added based on expected behavior of forPaths method
    }

    @Test
    void testBuildFromLastSplitSegment_MultipleSegments() throws IOException {
        Path lastSegmentPath = Paths.get("test.z01");
        Path parentPath = lastSegmentPath.getParent() != null ? lastSegmentPath.getParent() : lastSegmentPath.getFileSystem().getPath(".");
        Files.createDirectories(parentPath);
        Files.createFile(parentPath.resolve("test.z01"));
        Files.createFile(parentPath.resolve("test.z02"));
        Files.createFile(parentPath.resolve("test.z03"));
        SeekableByteChannel channel = ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(lastSegmentPath);
        Assertions.assertNotNull(channel);
        // Additional assertions can be added based on expected behavior of forPaths method
    }
}
