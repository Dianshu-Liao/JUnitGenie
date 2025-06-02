package org.apache.commons.compress.harmony.unpack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class SegmentOptions_hasSpecialFormats_10_0_Test {

    private SegmentOptions segmentOptionsWithSpecialFormats;

    private SegmentOptions segmentOptionsWithoutSpecialFormats;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        // Initialize with options that include HAVE_SPECIAL_FORMATS
        // Options set to HAVE_SPECIAL_FORMATS
        segmentOptionsWithSpecialFormats = new SegmentOptions(1 << 0);
        // Initialize without HAVE_SPECIAL_FORMATS
        // No special formats
        segmentOptionsWithoutSpecialFormats = new SegmentOptions(0);
    }

    @Test
    public void testHasSpecialFormats_WithSpecialFormats() {
        assertTrue(segmentOptionsWithSpecialFormats.hasSpecialFormats(), "Expected hasSpecialFormats() to return true when special formats are present.");
    }

    @Test
    public void testHasSpecialFormats_WithoutSpecialFormats() {
        assertFalse(segmentOptionsWithoutSpecialFormats.hasSpecialFormats(), "Expected hasSpecialFormats() to return false when special formats are not present.");
    }
}
