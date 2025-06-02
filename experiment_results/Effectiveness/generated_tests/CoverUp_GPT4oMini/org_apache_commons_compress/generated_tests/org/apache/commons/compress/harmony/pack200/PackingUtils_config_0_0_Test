package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.PackingOptions;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import org.apache.commons.compress.harmony.pack200.Archive.PackingFile;

public class PackingUtils_config_0_0_Test {

    private PackingOptions options;

    private static final String LOG_FILE = "test.log";

    // To trigger IOException
    private static final String INVALID_LOG_FILE = "invalid/test.log";

    @BeforeEach
    public void setUp() {
        options = new PackingOptions();
        options.setLogFile(LOG_FILE);
        options.setVerbose(true);
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Clean up the logger and file handler after each test
        Field fieldHandlerField = PackingUtils.class.getDeclaredField("fileHandler");
        fieldHandlerField.setAccessible(true);
        FileHandler handler = (FileHandler) fieldHandlerField.get(null);
        if (handler != null) {
            handler.close();
        }
    }

    @Test
    public void testConfigWithValidOptions() throws IOException, NoSuchFieldException, IllegalAccessException {
        PackingUtils.config(options);
        // Validate that the file handler is created and logger is configured
        Field fieldHandlerField = PackingUtils.class.getDeclaredField("fileHandler");
        fieldHandlerField.setAccessible(true);
        FileHandler handler = (FileHandler) fieldHandlerField.get(null);
        assertNotNull(handler);
        Field packingLoggerField = PackingUtils.class.getDeclaredField("packingLogger");
        packingLoggerField.setAccessible(true);
        assertNotNull(packingLoggerField.get(null));
    }

    @Test
    public void testConfigWithNullOptions() throws IOException, NoSuchFieldException, IllegalAccessException {
        PackingUtils.config(null);
        // Validate that no exceptions are thrown and logger remains unchanged
        Field fieldHandlerField = PackingUtils.class.getDeclaredField("fileHandler");
        fieldHandlerField.setAccessible(true);
        FileHandler handler = (FileHandler) fieldHandlerField.get(null);
        assertNotNull(handler);
    }

    @Test
    public void testConfigWithInvalidLogFile() {
        options.setLogFile(INVALID_LOG_FILE);
        assertThrows(IOException.class, () -> PackingUtils.config(options));
    }

    @Test
    public void testConfigWithVerboseOption() throws IOException, NoSuchFieldException, IllegalAccessException {
        options.setVerbose(true);
        PackingUtils.config(options);
        // Validate that verbose is set
        Field packingLoggerField = PackingUtils.class.getDeclaredField("packingLogger");
        packingLoggerField.setAccessible(true);
        Logger logger = (Logger) packingLoggerField.get(null);
        assertNotNull(logger);
        assertNotNull(logger.getHandlers());
    }
}
