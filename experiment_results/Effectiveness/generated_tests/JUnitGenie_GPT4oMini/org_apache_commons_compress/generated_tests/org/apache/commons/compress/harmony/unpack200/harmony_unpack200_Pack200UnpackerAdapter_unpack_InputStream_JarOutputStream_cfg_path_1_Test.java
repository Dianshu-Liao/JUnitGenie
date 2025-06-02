package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarOutputStream;
import static org.junit.Assert.fail;

public class harmony_unpack200_Pack200UnpackerAdapter_unpack_InputStream_JarOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnpack_NullInputStream_ThrowsIllegalArgumentException() {
        JarOutputStream out = null; // Simulating a null output stream
        Pack200UnpackerAdapter adapter = new Pack200UnpackerAdapter();

        try {
            adapter.unpack((InputStream) null, out); // Cast null to InputStream to resolve ambiguity
            fail("Expected IllegalArgumentException for null input stream");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Expected IllegalArgumentException, but got IOException: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testUnpack_NullOutputStream_ThrowsIllegalArgumentException() {
        InputStream in = new ByteArrayInputStream(new byte[0]); // Simulating a valid input stream
        Pack200UnpackerAdapter adapter = new Pack200UnpackerAdapter();

        try {
            adapter.unpack(in, null);
            fail("Expected IllegalArgumentException for null output stream");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Expected IllegalArgumentException, but got IOException: " + e.getMessage());
        }
    }


}