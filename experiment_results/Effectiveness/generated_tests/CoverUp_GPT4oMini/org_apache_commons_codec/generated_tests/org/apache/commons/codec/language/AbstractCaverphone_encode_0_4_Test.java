package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.StringEncoder;

@ExtendWith(MockitoExtension.class)
class AbstractCaverphone_encode_0_4_Test {

    private class TestCaverphone extends AbstractCaverphone {

        @Override
        public String encode(String source) {
            return source.toUpperCase();
        }
    }

    @Test
    void testEncodeWithString() throws EncoderException {
        AbstractCaverphone caverphone = new TestCaverphone();
        String input = "test";
        Object result = caverphone.encode(input);
        assertEquals("TEST", result);
    }

    @Test
    void testEncodeWithNonString() {
        AbstractCaverphone caverphone = new TestCaverphone();
        Exception exception = assertThrows(EncoderException.class, () -> {
            caverphone.encode(123);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", exception.getMessage());
    }

    @Test
    void testEncodeWithNull() {
        AbstractCaverphone caverphone = new TestCaverphone();
        Exception exception = assertThrows(EncoderException.class, () -> {
            caverphone.encode(null);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", exception.getMessage());
    }

    @Test
    void testEncodeWithEmptyString() throws EncoderException {
        AbstractCaverphone caverphone = new TestCaverphone();
        Object result = caverphone.encode("");
        assertEquals("", result);
    }
}
