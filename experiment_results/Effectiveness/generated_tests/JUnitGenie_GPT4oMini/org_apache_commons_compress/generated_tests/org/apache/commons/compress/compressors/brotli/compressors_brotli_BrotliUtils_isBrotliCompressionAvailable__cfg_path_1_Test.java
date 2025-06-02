package org.apache.commons.compress.compressors.brotli;
import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class compressors_brotli_BrotliUtils_isBrotliCompressionAvailable__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsBrotliCompressionAvailable_whenCachedResultIsDontCache() {
        // Set the cachedBrotliAvailability to DONT_CACHE using reflection
        try {
            java.lang.reflect.Field field = BrotliUtils.class.getDeclaredField("cachedBrotliAvailability");
            field.setAccessible(true);
            field.set(null, BrotliUtils.CachedAvailability.DONT_CACHE);
            
            // Call the method under test
            boolean result = BrotliUtils.isBrotliCompressionAvailable();
            
            // Assert the expected outcome
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}