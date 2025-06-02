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
    public void testValidOptions() throws Pack200Exception {
        SegmentOptions segmentOptions = new SegmentOptions(0);
        assertNotNull(segmentOptions);
    }

    @Test
    public void testValidOptionsWithFlags() throws Pack200Exception {
        SegmentOptions segmentOptions = new SegmentOptions(getHAVE_ALL_CODE_FLAGS());
        assertNotNull(segmentOptions);
    }

    @Test
    public void testValidOptionsWithMultipleFlags() throws Pack200Exception {
        SegmentOptions segmentOptions = new SegmentOptions(getHAVE_FILE_HEADERS() | getHAVE_FILE_OPTIONS());
        assertNotNull(segmentOptions);
    }

    @Test
    public void testUnusedFlagsThrowException() {
        assertThrows(Pack200Exception.class, () -> {
            new SegmentOptions(getUNUSED());
        });
    }

    @Test
    public void testUnusedFlagsWithValidOptionsThrowException() {
        assertThrows(Pack200Exception.class, () -> {
            new SegmentOptions(getUNUSED() | getHAVE_FILE_HEADERS());
        });
    }

    @Test
    public void testNegativeOptions() {
        assertThrows(Pack200Exception.class, () -> {
            new SegmentOptions(-1);
        });
    }

    @Test
    public void testZeroOptions() throws Pack200Exception {
        SegmentOptions segmentOptions = new SegmentOptions(0);
        assertNotNull(segmentOptions);
    }

    // Helper methods to access private constants
    private int getHAVE_ALL_CODE_FLAGS() {
        // Value of HAVE_ALL_CODE_FLAGS
        return 1 << 2;
    }

    private int getHAVE_FILE_HEADERS() {
        // Value of HAVE_FILE_HEADERS
        return 1 << 4;
    }

    private int getHAVE_FILE_OPTIONS() {
        // Value of HAVE_FILE_OPTIONS
        return 1 << 7;
    }

    private int getUNUSED() {
        // Value of UNUSED
        return -1 << 13 | 1 << 3;
    }
}
