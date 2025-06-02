package org.apache.commons.compress.harmony.pack200;

import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
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

public class Pack200PackerAdapter_pack_2_0_Test {

    @Test
    public void testPack_NullInputStream() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        OutputStream mockOutputStream = new ByteArrayOutputStream();
        Executable executable = () -> packer.pack((JarInputStream) null, mockOutputStream);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Must specify both input and output streams", exception.getMessage());
    }

    @Test
    public void testPack_NullOutputStream() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        try (JarInputStream mockInputStream = new JarInputStream(new ByteArrayInputStream(new byte[0]))) {
            Executable executable = () -> packer.pack(mockInputStream, (OutputStream) null);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
            assertEquals("Must specify both input and output streams", exception.getMessage());
        } catch (IOException e) {
            fail("IOException should not occur while creating JarInputStream");
        }
    }
}
