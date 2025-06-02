package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Pack200PackerAdapter;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

public class harmony_pack200_Pack200PackerAdapter_pack_JarFile_OutputStream_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testPackWithNullFile() throws IOException {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        // Explicitly cast to JarFile to resolve ambiguity
        packer.pack((JarFile) null, new ByteArrayOutputStream());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPackWithNullOutputStream() throws IOException {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        // Create a temporary file to avoid FileNotFoundException
        File tempFile = File.createTempFile("dummy", ".jar");
        tempFile.deleteOnExit(); // Ensure the file is deleted after the test
        packer.pack(new JarFile(tempFile), null);
    }


}