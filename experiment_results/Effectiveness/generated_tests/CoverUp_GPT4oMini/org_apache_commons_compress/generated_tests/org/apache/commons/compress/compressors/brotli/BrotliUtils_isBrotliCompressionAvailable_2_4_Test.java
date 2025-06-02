package org.apache.commons.compress.compressors.brotli;

import org.apache.commons.compress.compressors.brotli.BrotliUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.utils.OsgiUtils;

public class BrotliUtils_isBrotliCompressionAvailable_2_4_Test {

    @BeforeEach
    public void setUp() {
        // Reset cached availability before each test
        BrotliUtils.setCacheBrotliAvailablity(false);
    }

    @Test
    public void testIsBrotliCompressionAvailable_CachedAvailable() throws Exception {
        // Set the cache to available
        BrotliUtils.setCacheBrotliAvailablity(true);
        // Use reflection to call the private method
        Method method = BrotliUtils.class.getDeclaredMethod("isBrotliCompressionAvailable");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null);
        assertTrue(result);
    }

    @Test
    public void testIsBrotliCompressionAvailable_CachedUnavailable() throws Exception {
        // Simulate the internal method to return unavailable
        setInternalAvailability(false);
        // Set cache to available
        BrotliUtils.setCacheBrotliAvailablity(true);
        // Use reflection to call the private method
        Method method = BrotliUtils.class.getDeclaredMethod("isBrotliCompressionAvailable");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null);
        assertFalse(result);
    }

    @Test
    public void testIsBrotliCompressionAvailable_DontCache() throws Exception {
        // Set cache to not cache
        BrotliUtils.setCacheBrotliAvailablity(false);
        // Use reflection to call the private method
        Method method = BrotliUtils.class.getDeclaredMethod("isBrotliCompressionAvailable");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(null);
        // This will depend on the actual availability of the Brotli library
        // In a real test, you should mock the internal method call
        // or assertFalse(result); based on your test environment
        assertTrue(result);
    }

    private void setInternalAvailability(boolean available) throws Exception {
        Method method = BrotliUtils.class.getDeclaredMethod("internalIsBrotliCompressionAvailable");
        method.setAccessible(true);
        // You would need to use a mocking framework like Mockito to change the behavior of this method
        // This is just a placeholder to indicate that the method should be mocked.
    }
}
