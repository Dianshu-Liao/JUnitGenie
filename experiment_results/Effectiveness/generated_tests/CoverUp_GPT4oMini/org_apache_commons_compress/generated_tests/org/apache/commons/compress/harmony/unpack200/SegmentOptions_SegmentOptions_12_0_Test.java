package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SegmentOptions_SegmentOptions_12_0_Test {

    @Test
    public void testConstructor_WithValidOptions_ShouldSetOptions() throws Pack200Exception {
        SegmentOptions options = new SegmentOptions(0);
        assertTrue(options.hasAllCodeFlags());
        assertFalse(options.hasFileOptions());
    }

    @Test
    public void testConstructor_WithUnusedFlag_ShouldThrowPack200Exception() {
        assertThrows(Pack200Exception.class, () -> {
            // Setting unused flag
            new SegmentOptions(-1 << 13);
        });
    }

    @Test
    public void testConstructor_WithAllFlagsSet_ShouldNotThrowException() throws Pack200Exception {
        int allFlags = (1 << 5) | (1 << 2) | (1 << 9) | (1 << 10) | (1 << 1) | (1 << 10) | (1 << 4) | (1 << 6) | (1 << 7) | (1 << 8) | (1 << 11) | (1 << 0);
        SegmentOptions options = new SegmentOptions(allFlags);
        assertTrue(options.hasAllCodeFlags());
        assertTrue(options.hasFileOptions());
        assertTrue(options.hasSpecialFormats());
    }

    @Test
    public void testHasMethods() throws Pack200Exception {
        // Only HAVE_ALL_CODE_FLAGS
        SegmentOptions options = new SegmentOptions(1 << 2);
        assertTrue(options.hasAllCodeFlags());
        assertFalse(options.hasCPNumberCounts());
        assertFalse(options.hasFileModtime());
        assertFalse(options.shouldDeflate());
    }

    @Test
    public void testHasMethod_WithMultipleFlags() throws Pack200Exception {
        // HAVE_ALL_CODE_FLAGS, HAVE_FILE_HEADERS, DEFLATE_HINT
        SegmentOptions options = new SegmentOptions((1 << 2) | (1 << 4) | (1 << 5));
        assertTrue(options.hasAllCodeFlags());
        assertTrue(options.hasArchiveFileCounts());
        assertTrue(options.shouldDeflate());
    }
}
