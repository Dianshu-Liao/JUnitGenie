package org.apache.commons.compress.compressors.brotli;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class compressors_brotli_BrotliUtils_isBrotliCompressionAvailable__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsBrotliCompressionAvailable_CachedResultDONT_CACHE() {
        try {
            // Set the cachedBrotliAvailability to DONT_CACHE
            // This is typically done through reflection since the constructor is private
            java.lang.reflect.Field field = BrotliUtils.class.getDeclaredField("cachedBrotliAvailability");
            field.setAccessible(true);
            field.set(null, BrotliUtils.CachedAvailability.DONT_CACHE);

            // Call the method under test
            boolean result = BrotliUtils.isBrotliCompressionAvailable();

            // Assert the expected outcome
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}