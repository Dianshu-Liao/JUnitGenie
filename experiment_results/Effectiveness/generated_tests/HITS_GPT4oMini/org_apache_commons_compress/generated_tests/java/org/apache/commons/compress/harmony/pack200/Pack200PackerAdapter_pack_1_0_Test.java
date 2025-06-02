package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.jar.JarInputStream;
import org.apache.commons.compress.java.util.jar.Pack200.Packer;
import org.apache.commons.compress.utils.ParsingUtils;

public class Pack200PackerAdapter_pack_1_0_Test {

    @Test
    public void testPack_NullJarFile_ThrowsIllegalArgumentException() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        assertThrows(IllegalArgumentException.class, () -> {
            packer.pack((JarFile) null, new ByteArrayOutputStream());
        }, "Must specify both input and output streams");
    }

    @Test
    public void testPack_NullOutputStream_ThrowsIllegalArgumentException() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        assertThrows(IllegalArgumentException.class, () -> {
            packer.pack(new JarFile("dummy.jar"), (OutputStream) null);
        }, "Must specify both input and output streams");
    }

    @Test
    public void testPack_NullJarFileAndOutputStream_ThrowsIllegalArgumentException() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        assertThrows(IllegalArgumentException.class, () -> {
            packer.pack((JarFile) null, (OutputStream) null);
        }, "Must specify both input and output streams");
    }
}
