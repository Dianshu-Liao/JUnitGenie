package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.*;
import org.junit.Test;

public class harmony_unpack200_Pack200UnpackerAdapter_unwrap_InputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnwrapWithFilterInputStream() {
        // Setup
        byte[] data = "test data".getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(data);
        FilterInputStream filterInputStream = new FilterInputStream(inputStream) {};

        // Execute
        InputStream result = null;
        try {
            result = Pack200UnpackerAdapter.unwrap(filterInputStream);
        } catch (Exception e) {
            fail("unwrap threw an exception: " + e.getMessage());
        }

        // Verify
        assertNotNull(result);
        assertTrue(result instanceof ByteArrayInputStream);
    }

    @Test(timeout = 4000)
    public void testUnwrapNonFilterInputStream() {
        // Setup
        InputStream inputStream = new ByteArrayInputStream("test data".getBytes(StandardCharsets.UTF_8));

        // Execute
        InputStream result = null;
        try {
            result = Pack200UnpackerAdapter.unwrap(inputStream);
        } catch (Exception e) {
            fail("unwrap threw an exception: " + e.getMessage());
        }

        // Verify
        assertNotNull(result);
        assertTrue(result instanceof ByteArrayInputStream);
    }

}