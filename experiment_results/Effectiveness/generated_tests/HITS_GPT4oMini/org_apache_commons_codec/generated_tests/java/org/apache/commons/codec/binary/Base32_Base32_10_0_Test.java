package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base32_Base32_10_0_Test {

    @Test
    void testBase32ConstructorWithHex() {
        // Test the public constructor with hex usage
        Base32 base32 = new Base32(true);
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithoutHex() {
        // Test the public constructor without hex usage
        Base32 base32 = new Base32(false);
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithPadding() {
        // Test the constructor that allows padding
        Base32 base32 = new Base32(true, (byte) '=');
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLength() {
        // Test the constructor that specifies line length
        Base32 base32 = new Base32(76);
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthAndSeparator() {
        // Test the constructor that specifies line length and line separator
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator);
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthSeparatorAndHex() {
        // Test the constructor with line length, separator, and hex
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator, true);
        assertNotNull(base32);
    }

    @Test
    void testBase32ConstructorWithLineLengthSeparatorHexAndPadding() {
        // Test the constructor with line length, separator, hex, and padding
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator, true, (byte) '=');
        assertNotNull(base32);
    }
}
