package org.apache.commons.compress.archivers;

import org.apache.commons.compress.archivers.tar.TarFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipFile;

class Lister_listZipUsingTarFile_8_0_Test {

    private Lister lister;

    private Path tempTarFile;

    @BeforeEach
    void setUp() throws IOException {
        lister = new Lister(false);
        tempTarFile = Files.createTempFile("test", ".tar");
        // Create a sample TAR file for testing
        Files.write(tempTarFile, "Sample entry content".getBytes());
    }

    @Test
    void testListZipUsingTarFile() throws Exception {
        Method method = Lister.class.getDeclaredMethod("listZipUsingTarFile", Path.class);
        method.setAccessible(true);
        // Invoke the method with the temporary TAR file
        assertDoesNotThrow(() -> method.invoke(lister, tempTarFile));
        // Verify the output (this would require capturing System.out output)
        // For now, we just check that no exceptions are thrown and the method completes
    }

    @Test
    void testListZipUsingTarFileWithInvalidPath() throws Exception {
        Method method = Lister.class.getDeclaredMethod("listZipUsingTarFile", Path.class);
        method.setAccessible(true);
        // Invoke the method with an invalid path
        assertThrows(IOException.class, () -> method.invoke(lister, Paths.get("invalid/path/to/file.tar")));
    }

    @Test
    void testListZipUsingTarFileWithEmptyPath() throws Exception {
        Method method = Lister.class.getDeclaredMethod("listZipUsingTarFile", Path.class);
        method.setAccessible(true);
        // Invoke the method with an empty path
        assertThrows(IOException.class, () -> method.invoke(lister, Paths.get("")));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempTarFile);
    }
}
