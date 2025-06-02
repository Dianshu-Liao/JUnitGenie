package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class // Additional tests can be added here to cover more scenarios if needed
Base32_Base32_13_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        // Initialize the Base32 object with a line length of 8 (for example)
        base32 = new Base32(8);
    }

    @Test
    void testBase32ConstructorWithValidLineLength() {
        // Check that the object is not null
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithZeroLineLength() {
        // Create a Base32 instance with line length 0
        Base32 base32ZeroLength = new Base32(0);
        assertNotNull(base32ZeroLength);
    }

    @Test
    void testBase32ConstructorWithNegativeLineLength() {
        // Create a Base32 instance with negative line length
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(-1);
        });
    }

    @Test
    void testBase32ConstructorWithLargeLineLength() {
        // Create a Base32 instance with a large line length
        Base32 base32LargeLength = new Base32(1000);
        assertNotNull(base32LargeLength);
    }

    @Test
    void testBase32ConstructorWithValidLineLengthAndCheckLineSeparator() {
        // Check if the default line separator is set correctly
        byte[] expectedSeparator = Base32.builder().getLineSeparator();
        assertArrayEquals(expectedSeparator, base32.getLineSeparator());
    }
}
