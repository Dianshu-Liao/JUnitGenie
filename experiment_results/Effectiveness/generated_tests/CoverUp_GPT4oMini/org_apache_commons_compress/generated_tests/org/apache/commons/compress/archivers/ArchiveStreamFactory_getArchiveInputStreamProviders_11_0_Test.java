package org.apache.commons.compress.archivers;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ArchiveStreamProvider;
import java.util.SortedMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.compress.archivers.ar.ArArchiveInputStream;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.arj.ArjArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveOutputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.Sets;

public class ArchiveStreamFactory_getArchiveInputStreamProviders_11_0_Test {

    private ArchiveStreamFactory archiveStreamFactory;

    @BeforeEach
    public void setUp() {
        archiveStreamFactory = new ArchiveStreamFactory();
    }

    @Test
    public void testGetArchiveInputStreamProviders() {
        // Invoke the focal method
        SortedMap<String, ArchiveStreamProvider> providers = archiveStreamFactory.getArchiveInputStreamProviders();
        // Assertions to ensure the method's functionality
        assertNotNull(providers, "The providers map should not be null.");
        assertFalse(providers.isEmpty(), "The providers map should not be empty.");
    }

    @Test
    public void testGetArchiveInputStreamProviders_Caching() {
        // First call to populate the providers
        SortedMap<String, ArchiveStreamProvider> firstCall = archiveStreamFactory.getArchiveInputStreamProviders();
        // Second call should return the cached value
        SortedMap<String, ArchiveStreamProvider> secondCall = archiveStreamFactory.getArchiveInputStreamProviders();
        // Assertions to ensure caching works
        assertNotNull(secondCall, "The cached providers map should not be null.");
        assertFalse(secondCall.isEmpty(), "The cached providers map should not be empty.");
        assertSame(firstCall, secondCall, "Subsequent calls should return the same instance.");
    }
}
