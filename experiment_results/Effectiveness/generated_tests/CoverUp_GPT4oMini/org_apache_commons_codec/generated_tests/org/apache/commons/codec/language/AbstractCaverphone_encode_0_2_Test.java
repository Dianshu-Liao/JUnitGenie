package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.StringEncoder;

public class AbstractCaverphone_encode_0_2_Test {

    private AbstractCaverphone caverphone;

    // Concrete implementation of AbstractCaverphone for testing
    private class TestCaverphone extends AbstractCaverphone {

        @Override
        public String encode(String source) {
            return source.toLowerCase();
        }
    }

    @BeforeEach
    public void setUp() {
        caverphone = new TestCaverphone();
    }

    @Test
    public void testEncodeWithString() throws EncoderException {
        String input = "TEST";
        Object result = caverphone.encode(input);
        assertEquals("test", result);
    }

    @Test
    public void testEncodeWithNonString() {
        Object input = 123;
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            caverphone.encode(input);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", thrown.getMessage());
    }

    @Test
    public void testEncodeWithNull() {
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            caverphone.encode(null);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", thrown.getMessage());
    }
}
