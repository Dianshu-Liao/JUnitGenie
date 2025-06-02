package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarOutputStream;
import java.io.ByteArrayOutputStream;

public class harmony_unpack200_Pack200UnpackerAdapter_unpack_InputStream_JarOutputStream_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testUnpack_NullInputStream() throws IOException {
        Pack200UnpackerAdapter unpacker = new Pack200UnpackerAdapter();
        // Specify the method explicitly to avoid ambiguity
        unpacker.unpack((InputStream) null, new JarOutputStream(new ByteArrayOutputStream()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnpack_NullOutputStream() throws IOException {
        Pack200UnpackerAdapter unpacker = new Pack200UnpackerAdapter();
        unpacker.unpack(new ByteArrayInputStream(new byte[0]), null);
    }


}