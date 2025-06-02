package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_14_0_Test {

    private Base32 base32;

    @BeforeEach
    public void setUp() {
        // Initialize Base32 with default parameters for testing
        base32 = new Base32();
    }

    @Test
    public void testBase32ConstructorWithLineLength() {
        int lineLength = 64;
        Base32 customBase32 = new Base32(lineLength);
        assertNotNull(customBase32);
        assertEquals(lineLength, customBase32.getLineSeparator().length);
    }

    @Test
    public void testBase32ConstructorWithLineLengthAndSeparator() {
        int lineLength = 64;
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 customBase32 = new Base32(lineLength, lineSeparator);
        assertNotNull(customBase32);
        assertArrayEquals(lineSeparator, customBase32.getLineSeparator());
    }

    @Test
    public void testBase32ConstructorWithLineLengthAndNullSeparatorThrowsException() {
        int lineLength = 64;
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, null);
        });
    }

    @Test
    public void testBase32ConstructorWithInvalidLineLengthAndSeparator() {
        int lineLength = 64;
        // 'A' is a Base32 character
        byte[] lineSeparator = new byte[] { 'A' };
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(lineLength, lineSeparator);
        });
    }

    @Test
    public void testBase32ConstructorWithPadding() {
        byte padding = '=';
        Base32 customBase32 = new Base32(padding);
        assertNotNull(customBase32);
    }

    @Test
    public void testBase32ConstructorWithHexUsage() {
        boolean useHex = true;
        Base32 hexBase32 = new Base32(useHex);
        assertNotNull(hexBase32);
    }

    @Test
    public void testBase32ConstructorWithHexAndPadding() {
        boolean useHex = true;
        byte padding = '=';
        Base32 hexBase32 = new Base32(useHex, padding);
        assertNotNull(hexBase32);
    }

    @Test
    public void testBase32ConstructorWithHexAndInvalidPadding() {
        boolean useHex = true;
        // 'A' is a Base32 character
        byte padding = 'A';
        assertThrows(IllegalArgumentException.class, () -> {
            new Base32(useHex, padding);
        });
    }
}
