package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class harmony_unpack200_Pack200UnpackerAdapter_unwrap_InputStream_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUnwrapWithFilterInputStream() {
        // Create a FilterInputStream for testing
        InputStream filterInputStream = new FilterInputStream(new ByteArrayInputStream(new byte[]{1, 2, 3})) {};
        
        // Call the unwrap method
        InputStream result = null;
        try {
            result = Pack200UnpackerAdapter.unwrap(filterInputStream);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Verify that the result is the same as the input FilterInputStream
        assertEquals(filterInputStream, result);
    }

    @Test(timeout = 4000)
    public void testUnwrapWithNonFilterInputStream() {
        // Create a regular InputStream for testing
        InputStream regularInputStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        
        // Call the unwrap method
        InputStream result = null;
        try {
            result = Pack200UnpackerAdapter.unwrap(regularInputStream);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Verify that the result is the same as the input regular InputStream
        assertEquals(regularInputStream, result);
    }

}