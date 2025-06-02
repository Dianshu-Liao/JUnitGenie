package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.jar.JarFile;
import org.apache.commons.compress.java.util.jar.Pack200.Packer;
import org.apache.commons.compress.utils.ParsingUtils;

class Pack200PackerAdapter_pack_2_2_Test {

    private Pack200PackerAdapter packer;

    private JarInputStream jarInputStream;

    private OutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        packer = new Pack200PackerAdapter();
        jarInputStream = new JarInputStream(getClass().getResourceAsStream("/path/to/sample.jar"));
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    void testPack_withValidInput_shouldNotThrowException() throws IOException {
        packer.pack(jarInputStream, outputStream);
        // Further assertions can be added to verify the output stream content
    }

    @Test
    void testPack_withNullJarInputStream_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            packer.pack((JarInputStream) null, outputStream);
        });
    }

    @Test
    void testPack_withNullOutputStream_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            packer.pack(jarInputStream, (OutputStream) null);
        });
    }
}
