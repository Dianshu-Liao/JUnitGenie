package org.apache.commons.compress.compressors.brotli;

import java.lang.reflect.Field;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.compress.utils.OsgiUtils;

@ExtendWith(MockitoExtension.class)
class BrotliUtils_isBrotliCompressionAvailable_2_0_Test {

    private enum CachedAvailability {

        CACHED_AVAILABLE, CACHED_NOT_AVAILABLE, DONT_CACHE
    }

    @BeforeEach
    void setUp() {
        // Reset cachedBrotliAvailability before each test
        setCachedBrotliAvailability(null);
    }

    @Test
    void testIsBrotliCompressionAvailable_CachedAvailable() {
        setCachedBrotliAvailability(CachedAvailability.CACHED_AVAILABLE);
        assertTrue(BrotliUtils.isBrotliCompressionAvailable());
    }

    @Test
    void testIsBrotliCompressionAvailable_CachedNotAvailable() {
        setCachedBrotliAvailability(CachedAvailability.CACHED_NOT_AVAILABLE);
        assertFalse(BrotliUtils.isBrotliCompressionAvailable());
    }

    @Test
    void testIsBrotliCompressionAvailable_DontCache() {
        setCachedBrotliAvailability(CachedAvailability.DONT_CACHE);
        // Assuming internalIsBrotliCompressionAvailable() returns false for this test
        assertFalse(BrotliUtils.isBrotliCompressionAvailable());
    }

    @Test
    void testIsBrotliCompressionAvailable_NullCache() {
        setCachedBrotliAvailability(null);
        // Assuming internalIsBrotliCompressionAvailable() returns false for this test
        assertFalse(BrotliUtils.isBrotliCompressionAvailable());
    }

    private void setCachedBrotliAvailability(CachedAvailability availability) {
        try {
            Field field = BrotliUtils.class.getDeclaredField("cachedBrotliAvailability");
            field.setAccessible(true);
            field.set(null, availability);
        } catch (Exception e) {
            fail("Failed to set cachedBrotliAvailability: " + e.getMessage());
        }
    }
}
