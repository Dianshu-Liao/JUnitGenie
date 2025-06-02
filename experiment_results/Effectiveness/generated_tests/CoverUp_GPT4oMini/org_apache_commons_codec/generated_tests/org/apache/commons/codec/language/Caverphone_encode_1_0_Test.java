package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;

public class Caverphone_encode_1_0_Test {

    private Caverphone caverphone;

    @BeforeEach
    public void setUp() {
        caverphone = new Caverphone();
    }

    @Test
    public void testEncode_ValidString() {
        String input = "hello";
        // Expected output based on the encoding logic of Caverphone2
        String expectedOutput = "hll";
        // Use reflection to access the private method caverphone
        try {
            String actualOutput = invokePrivateCaverphoneMethod(input);
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            fail("Exception thrown while invoking private method: " + e.getMessage());
        }
    }

    @Test
    public void testEncode_NonStringInput() {
        Object input = 123;
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            caverphone.encode(input);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", thrown.getMessage());
    }

    @Test
    public void testEncode_NullInput() {
        Object input = null;
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            caverphone.encode(input);
        });
        assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", thrown.getMessage());
    }

    private String invokePrivateCaverphoneMethod(String input) throws Exception {
        Method method = Caverphone.class.getDeclaredMethod("caverphone", String.class);
        method.setAccessible(true);
        return (String) method.invoke(caverphone, input);
    }
}
