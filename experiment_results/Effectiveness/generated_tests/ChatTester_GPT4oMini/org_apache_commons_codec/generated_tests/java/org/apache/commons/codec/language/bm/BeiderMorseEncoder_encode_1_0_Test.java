package org.apache.commons.codec.language.bm;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

class BeiderMorseEncoder_encode_1_0_Test {

    private BeiderMorseEncoder encoder;

    private PhoneticEngine mockEngine;

    @BeforeEach
    void setUp() {
        mockEngine = mock(PhoneticEngine.class);
        encoder = new BeiderMorseEncoder();
        // Use reflection to set the private engine field to the mock
        try {
            java.lang.reflect.Field field = BeiderMorseEncoder.class.getDeclaredField("engine");
            field.setAccessible(true);
            field.set(encoder, mockEngine);
        } catch (Exception e) {
            fail("Failed to set up the mock engine: " + e.getMessage());
        }
    }

    @Test
    void testEncode_NullInput() throws EncoderException {
        String result = encoder.encode(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    void testEncode_ValidInput() throws EncoderException {
        String source = "example";
        String expectedEncoded = "encodedExample";
        when(mockEngine.encode(source)).thenReturn(expectedEncoded);
        String result = encoder.encode(source);
        assertEquals(expectedEncoded, result, "Encoding should return the expected encoded string");
    }

    @Test
    void testEncode_EmptyInput() throws EncoderException {
        String source = "";
        String expectedEncoded = "encodedEmpty";
        when(mockEngine.encode(source)).thenReturn(expectedEncoded);
        String result = encoder.encode(source);
        assertEquals(expectedEncoded, result, "Encoding an empty string should return the expected encoded string");
    }
}
