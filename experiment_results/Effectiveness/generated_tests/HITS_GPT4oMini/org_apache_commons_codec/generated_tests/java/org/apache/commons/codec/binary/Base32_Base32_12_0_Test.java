package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_Base32_12_0_Test {

    @Test
    public void testBase32DefaultConstructor() {
        Base32 base32 = new Base32();
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithHex() {
        Base32 base32 = new Base32(true);
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithHexAndPadding() {
        Base32 base32 = new Base32(true, (byte) '=');
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithPadding() {
        Base32 base32 = new Base32((byte) '=');
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithLineLength() {
        Base32 base32 = new Base32(76);
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithLineLengthAndSeparator() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator);
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithLineLengthSeparatorHex() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator, true);
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithLineLengthSeparatorHexAndPadding() {
        byte[] lineSeparator = new byte[] { '\n' };
        Base32 base32 = new Base32(76, lineSeparator, true, (byte) '=');
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithDecodingPolicy() {
        Base32 base32 = new Base32(76, new byte[] { '\n' }, true, (byte) '=');
        assertNotNull(base32);
    }

    @Test
    public void testBase32WithCustomEncodeTable() {
        byte[] customEncodeTable = new byte[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7' };
        Base32 base32 = new Base32(76, new byte[] { '\n' }, true, (byte) '=');
        assertNotNull(base32);
    }
}
