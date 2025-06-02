package org.apache.commons.lang3;

import org.apache.commons.lang3.RuntimeEnvironment;
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
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class RuntimeEnvironment_inContainer_1_1_Test {

    @Test
    public void testInContainer_EmptyEnv() throws Exception {
        // Prepare the environment
        createMockEnvFile("", "/proc/1/environ");
        // Invoke the focal method
        Boolean result = invokeInContainer();
        // Verify the result
        Assertions.assertFalse(result);
    }

    @Test
    public void testInContainer_NonEmptyEnv() throws Exception {
        // Prepare the environment
        createMockEnvFile("container=value", "/proc/1/environ");
        // Invoke the focal method
        Boolean result = invokeInContainer();
        // Verify the result
        Assertions.assertTrue(result);
    }

    @Test
    public void testInContainer_DockerFileExists() throws Exception {
        // Prepare the environment
        createMockFile("/.dockerenv");
        // Invoke the focal method
        Boolean result = invokeInContainer();
        // Verify the result
        Assertions.assertTrue(result);
    }

    @Test
    public void testInContainer_PodmanFileExists() throws Exception {
        // Prepare the environment
        createMockFile("/run/.containerenv");
        // Invoke the focal method
        Boolean result = invokeInContainer();
        // Verify the result
        Assertions.assertTrue(result);
    }

    private Boolean invokeInContainer() throws Exception {
        Method method = RuntimeEnvironment.class.getDeclaredMethod("inContainer");
        method.setAccessible(true);
        return (Boolean) method.invoke(null);
    }

    private void createMockEnvFile(String content, String path) throws Exception {
        Path mockEnvPath = Paths.get(path);
        Files.createDirectories(mockEnvPath.getParent());
        Files.write(mockEnvPath, content.getBytes());
    }

    private void createMockFile(String path) throws Exception {
        Path mockFilePath = Paths.get(path);
        Files.createDirectories(mockFilePath.getParent());
        Files.createFile(mockFilePath);
    }
}
