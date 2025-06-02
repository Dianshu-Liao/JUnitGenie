package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class // Add more tests here to cover other edge cases if necessary
DoubleMetaphone_encode_10_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    void testEncodeValidString() throws EncoderException {
        String input = "example";
        // Assuming it returns a valid output
        String expectedOutput = doubleMetaphone.doubleMetaphone(input);
        Object result = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    void testEncodeNullInput() {
        assertThrows(EncoderException.class, () -> doubleMetaphone.encode(null));
    }

    @Test
    void testEncodeNonStringInput() {
        assertThrows(EncoderException.class, () -> doubleMetaphone.encode(123));
    }

    @Test
    void testEncodeEmptyString() throws EncoderException {
        String input = "";
        // Assuming it returns a valid output
        String expectedOutput = doubleMetaphone.doubleMetaphone(input);
        Object result = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    void testEncodeSingleCharacterString() throws EncoderException {
        String input = "A";
        // Assuming it returns a valid output
        String expectedOutput = doubleMetaphone.doubleMetaphone(input);
        Object result = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, result);
    }
}
