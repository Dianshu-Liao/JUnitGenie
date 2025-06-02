package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_9_0_Test {

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
        Base32 hexBase32 = new Base32(true);
        assertNotNull(hexBase32);
    }

    @Test
    public void testBase32WithPadding() {
        Base32 paddedBase32 = new Base32((byte) '=');
        assertNotNull(paddedBase32);
    }

    @Test
    public void testBase32WithLineLength() {
        Base32 lineLengthBase32 = new Base32(76);
        assertNotNull(lineLengthBase32);
    }

    @Test
    public void testBase32WithLineLengthAndSeparator() {
        byte[] separator = new byte[] { '\n' };
        Base32 lineLengthSeparatorBase32 = new Base32(76, separator);
        assertNotNull(lineLengthSeparatorBase32);
    }

    @Test
    public void testBase32WithLineLengthSeparatorHex() {
        byte[] separator = new byte[] { '\n' };
        Base32 lineLengthSeparatorHexBase32 = new Base32(76, separator, true);
        assertNotNull(lineLengthSeparatorHexBase32);
    }

    @Test
    public void testBase32WithLineLengthSeparatorPadding() {
        byte[] separator = new byte[] { '\n' };
        Base32 lineLengthSeparatorPaddingBase32 = new Base32(76, separator, false, (byte) '=');
        assertNotNull(lineLengthSeparatorPaddingBase32);
    }

    @Test
    public void testBase32WithDecodingPolicy() {
        Base32 decodingPolicyBase32 = new Base32(76, new byte[] { '\n' }, false, (byte) '=');
        assertNotNull(decodingPolicyBase32);
    }

    @Test
    public void testBase32WithAllParameters() {
        byte[] separator = new byte[] { '\n' };
        Base32 fullConstructorBase32 = new Base32(76, separator, true, (byte) '=');
        assertNotNull(fullConstructorBase32);
    }
}
