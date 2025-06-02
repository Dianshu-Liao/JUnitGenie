package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Pack200PackerAdapter;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.jar.JarFile;
import static org.junit.Assert.fail;

public class harmony_pack200_Pack200PackerAdapter_pack_JarFile_OutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPack_NullFile_ThrowsIllegalArgumentException() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // Explicitly cast null to JarFile to resolve ambiguity
            packer.pack((JarFile) null, out);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPack_NullOutputStream_ThrowsIllegalArgumentException() {
        Pack200PackerAdapter packer = new Pack200PackerAdapter();
        JarFile file = null;
        try {
            file = new JarFile("test.jar"); // Assuming test.jar exists for this test
            packer.pack(file, null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Handle potential IOException on close
                }
            }
        }
    }

}