package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_11_0_Test {

    private Base32 base32Default;

    private Base32 base32Hex;

    private Base32 base32WithPadding;

    @BeforeEach
    public void setUp() {
        base32Default = new Base32();
        base32Hex = new Base32(true);
        base32WithPadding = new Base32(false, (byte) '=');
    }

    @Test
    public void testBase32DefaultConstructor() {
        assertNotNull(base32Default);
    }

    @Test
    public void testBase32HexConstructor() {
        assertNotNull(base32Hex);
    }

    @Test
    public void testBase32WithPaddingConstructor() {
        assertNotNull(base32WithPadding);
    }

    @Test
    public void testBase32WithHexTrue() {
        Base32 base32HexTrue = new Base32(true);
        assertNotNull(base32HexTrue);
    }

    @Test
    public void testBase32WithHexFalse() {
        Base32 base32HexFalse = new Base32(false);
        assertNotNull(base32HexFalse);
    }

    @Test
    public void testBase32WithPadding() {
        Base32 base32WithPadding = new Base32(false, (byte) '=');
        assertNotNull(base32WithPadding);
    }

    @Test
    public void testBase32WithLineLength() {
        Base32 base32WithLineLength = new Base32(76);
        assertNotNull(base32WithLineLength);
    }

    @Test
    public void testBase32WithLineSeparator() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32WithLineSeparator = new Base32(76, lineSeparator);
        assertNotNull(base32WithLineSeparator);
    }

    @Test
    public void testBase32WithLineLengthAndSeparator() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32WithLineLengthAndSeparator = new Base32(76, lineSeparator, true);
        assertNotNull(base32WithLineLengthAndSeparator);
    }

    @Test
    public void testBase32WithAllParameters() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32Full = new Base32(76, lineSeparator, true, (byte) '=');
        assertNotNull(base32Full);
    }
}
