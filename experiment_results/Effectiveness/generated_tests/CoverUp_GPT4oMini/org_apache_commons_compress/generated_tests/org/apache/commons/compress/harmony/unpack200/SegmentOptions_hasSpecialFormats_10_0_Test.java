package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SegmentOptions_hasSpecialFormats_10_0_Test {

    @Test
    void testHasSpecialFormats_WhenOptionsHasSpecialFormats_ReturnsTrue() throws Pack200Exception {
        // 1 corresponds to HAVE_SPECIAL_FORMATS
        SegmentOptions segmentOptions = new SegmentOptions(1);
        assertTrue(segmentOptions.hasSpecialFormats());
    }

    @Test
    void testHasSpecialFormats_WhenOptionsDoesNotHaveSpecialFormats_ReturnsFalse() throws Pack200Exception {
        // 0 corresponds to no special formats
        SegmentOptions segmentOptions = new SegmentOptions(0);
        assertFalse(segmentOptions.hasSpecialFormats());
    }

    @Test
    void testHasSpecialFormats_WhenOptionsHasOtherFlags_ReturnsFalse() throws Pack200Exception {
        // 2 does not have HAVE_SPECIAL_FORMATS
        SegmentOptions segmentOptions = new SegmentOptions(2);
        assertFalse(segmentOptions.hasSpecialFormats());
    }

    @Test
    void testHasSpecialFormats_WhenOptionsHasMultipleFlagsIncludingSpecialFormats_ReturnsTrue() throws Pack200Exception {
        // 1 (HAVE_SPECIAL_FORMATS) and 4 (HAVE_ALL_CODE_FLAGS)
        SegmentOptions segmentOptions = new SegmentOptions(1 | (1 << 2));
        assertTrue(segmentOptions.hasSpecialFormats());
    }

    @Test
    void testHasSpecialFormats_WhenOptionsHasMultipleFlagsExcludingSpecialFormats_ReturnsFalse() throws Pack200Exception {
        // 4 (HAVE_ALL_CODE_FLAGS) and 64 (HAVE_FILE_MODTIME)
        SegmentOptions segmentOptions = new SegmentOptions(4 | (1 << 6));
        assertFalse(segmentOptions.hasSpecialFormats());
    }
}
