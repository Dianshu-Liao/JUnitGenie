package org.apache.commons.lang3;

import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;

public class RuntimeEnvironment_inContainer_2_0_Test {

    @TempDir
    Path tempDir;

    @Test
    public void testInContainer_EmptyContainerVariable() throws IOException {
        // Setup: Create a mock /proc/1/environ file with an empty container variable
        Path environFile = tempDir.resolve("proc/1/environ");
        Files.createDirectories(environFile.getParent());
        Files.write(environFile, "container=\0".getBytes());
        // Execute
        boolean result = RuntimeEnvironment.inContainer(tempDir.toString());
        // Verify
        assertFalse(result);
    }

    @Test
    public void testInContainer_NonEmptyContainerVariable() throws IOException {
        // Setup: Create a mock /proc/1/environ file with a non-empty container variable
        Path environFile = tempDir.resolve("proc/1/environ");
        Files.createDirectories(environFile.getParent());
        Files.write(environFile, "container=value\0".getBytes());
        // Execute
        boolean result = RuntimeEnvironment.inContainer(tempDir.toString());
        // Verify
        assertTrue(result);
    }

    @Test
    public void testInContainer_DockerFileExists() throws IOException {
        // Setup: Create a mock .dockerenv file
        Path dockerEnvFile = tempDir.resolve(".dockerenv");
        Files.createFile(dockerEnvFile);
        // Execute
        boolean result = RuntimeEnvironment.inContainer(tempDir.toString());
        // Verify
        assertTrue(result);
    }

    @Test
    public void testInContainer_PodmanFileExists() throws IOException {
        // Setup: Create a mock /run/.containerenv file
        Path containerEnvFile = tempDir.resolve("run/.containerenv");
        Files.createDirectories(containerEnvFile.getParent());
        Files.createFile(containerEnvFile);
        // Execute
        boolean result = RuntimeEnvironment.inContainer(tempDir.toString());
        // Verify
        assertTrue(result);
    }

    @Test
    public void testInContainer_NoContainerFilesOrVariables() {
        // Execute
        boolean result = RuntimeEnvironment.inContainer(tempDir.toString());
        // Verify
        assertFalse(result);
    }
}
