package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_13_0_Test {

    private Base32 base32;

    @BeforeEach
    public void setUp() {
        base32 = new Base32();
    }

    @Test
    public void testBase32DefaultConstructor() {
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithHex() {
        Base32 base32Hex = new Base32(true);
        assertNotNull(base32Hex);
    }

    @Test
    public void testBase32WithPadding() {
        Base32 base32WithPadding = new Base32((byte) '=');
        assertNotNull(base32WithPadding);
    }

    @Test
    public void testBase32WithLineLength() {
        Base32 base32WithLineLength = new Base32(76);
        assertNotNull(base32WithLineLength);
    }

    @Test
    public void testBase32WithLineLengthAndSeparator() {
        byte[] separator = new byte[] { '\n' };
        Base32 base32WithLineLengthAndSeparator = new Base32(76, separator);
        assertNotNull(base32WithLineLengthAndSeparator);
    }

    @Test
    public void testBase32WithHexAndPadding() {
        Base32 base32HexWithPadding = new Base32(true, (byte) '=');
        assertNotNull(base32HexWithPadding);
    }

    @Test
    public void testBase32WithHexAndLineLength() {
        Base32 base32HexWithLineLength = new Base32(76, new byte[] { '\n' }, true);
        assertNotNull(base32HexWithLineLength);
    }

    @Test
    public void testBase32WithHexLineLengthSeparatorAndPadding() {
        byte[] separator = new byte[] { '\n' };
        Base32 base32HexLineLengthSeparatorPadding = new Base32(76, separator, true, (byte) '=');
        assertNotNull(base32HexLineLengthSeparatorPadding);
    }

    @Test
    public void testBase32WithAllParameters() {
        byte[] separator = new byte[] { '\n' };
        Base32 base32AllParams = new Base32(76, separator, true, (byte) '=');
        assertNotNull(base32AllParams);
    }
}
