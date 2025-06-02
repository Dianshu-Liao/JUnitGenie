package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SegmentOptions_hasSpecialFormats_10_0_Test {

    @Test
    public void testHasSpecialFormats_WhenOptionsHasSpecialFormats_ReturnsTrue() throws Pack200Exception {
        // Arrange
        // Binary: 0000...0001
        int optionsWithSpecialFormats = 1;
        SegmentOptions segmentOptions = new SegmentOptions(optionsWithSpecialFormats);
        // Act
        boolean result = segmentOptions.hasSpecialFormats();
        // Assert
        assertTrue(result, "Expected hasSpecialFormats() to return true when special formats are present.");
    }

    @Test
    public void testHasSpecialFormats_WhenOptionsDoesNotHaveSpecialFormats_ReturnsFalse() throws Pack200Exception {
        // Arrange
        // Binary: 0000...0000
        int optionsWithoutSpecialFormats = 0;
        SegmentOptions segmentOptions = new SegmentOptions(optionsWithoutSpecialFormats);
        // Act
        boolean result = segmentOptions.hasSpecialFormats();
        // Assert
        assertFalse(result, "Expected hasSpecialFormats() to return false when special formats are not present.");
    }

    @Test
    public void testHasSpecialFormats_WhenOptionsIncludesOtherFlags_ReturnsFalse() throws Pack200Exception {
        // Arrange
        // SegmentOptions.HAVE_ALL_CODE_FLAGS (1 << 2)
        int optionsWithOtherFlags = 4;
        SegmentOptions segmentOptions = new SegmentOptions(optionsWithOtherFlags);
        // Act
        boolean result = segmentOptions.hasSpecialFormats();
        // Assert
        assertFalse(result, "Expected hasSpecialFormats() to return false when other flags are included but special formats are not.");
    }

    @Test
    public void testHasSpecialFormats_WhenOptionsIncludesSpecialFormatsWithOtherFlags_ReturnsTrue() throws Pack200Exception {
        // Arrange
        // (HAVE_SPECIAL_FORMATS | HAVE_ALL_CODE_FLAGS)
        int optionsWithSpecialFormatsAndOtherFlags = 1 | 4;
        SegmentOptions segmentOptions = new SegmentOptions(optionsWithSpecialFormatsAndOtherFlags);
        // Act
        boolean result = segmentOptions.hasSpecialFormats();
        // Assert
        assertTrue(result, "Expected hasSpecialFormats() to return true when special formats are included with other flags.");
    }

    @Test
    public void testHasSpecialFormats_WhenOptionsIsNegative_ReturnsFalse() throws Pack200Exception {
        // Arrange
        // A negative integer
        int negativeOptions = -1;
        SegmentOptions segmentOptions = new SegmentOptions(negativeOptions);
        // Act
        boolean result = segmentOptions.hasSpecialFormats();
        // Assert
        assertFalse(result, "Expected hasSpecialFormats() to return false when options is negative.");
    }
}
