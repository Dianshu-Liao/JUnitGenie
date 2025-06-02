package org.apache.commons.compress.compressors.lzma;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class compressors_lzma_LZMAUtils_internalIsLZMACompressionAvailable__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInternalIsLZMACompressionAvailable() {
        try {
            Method method = LZMAUtils.class.getDeclaredMethod("internalIsLZMACompressionAvailable");
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception as required for the test
            e.printStackTrace();
        }
    }

}