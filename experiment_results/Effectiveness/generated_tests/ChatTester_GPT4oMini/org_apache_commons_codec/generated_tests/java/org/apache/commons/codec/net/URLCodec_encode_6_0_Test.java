package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class URLCodec_encode_6_0_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
        // Initialize the WWW_FORM_URL_SAFE BitSet for testing
        for (int i = 0; i < 256; i++) {
            if (isSafeCharacter((char) i)) {
                // Corrected line: Access the private WWW_FORM_URL_SAFE field correctly
                try {
                    Method setMethod = BitSet.class.getDeclaredMethod("set", int.class);
                    setMethod.setAccessible(true);
                    // Access the private WWW_FORM_URL_SAFE field using reflection
                    Method getWwwFormUrlSafeMethod = URLCodec.class.getDeclaredMethod("getWwwFormUrlSafe");
                    getWwwFormUrlSafeMethod.setAccessible(true);
                    BitSet wwwFormUrlSafe = (BitSet) getWwwFormUrlSafeMethod.invoke(urlCodec);
                    setMethod.invoke(wwwFormUrlSafe, i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void testEncode_ValidInput() throws Exception {
        String input = "Hello World!";
        byte[] expectedOutput = "Hello%20World%21".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = invokeEncodeMethod(input.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_EmptyInput() throws Exception {
        byte[] expectedOutput = "".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = invokeEncodeMethod("".getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncode_NullInput() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            invokeEncodeMethod(null);
        });
    }

    @Test
    public void testEncode_SpecialCharacters() throws Exception {
        String input = "Space: !@#$%^&*()";
        byte[] expectedOutput = "Space%3A%20%21%40%23%24%25%5E%26%2A%28%29".getBytes(StandardCharsets.UTF_8);
        byte[] actualOutput = invokeEncodeMethod(input.getBytes(StandardCharsets.UTF_8));
        assertArrayEquals(expectedOutput, actualOutput);
    }

    private byte[] invokeEncodeMethod(byte[] bytes) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method encodeMethod = URLCodec.class.getDeclaredMethod("encode", byte[].class);
        encodeMethod.setAccessible(true);
        return (byte[]) encodeMethod.invoke(urlCodec, (Object) bytes);
    }

    private boolean isSafeCharacter(char c) {
        // Define safe characters according to URL encoding rules
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || "-_.~".indexOf(c) != -1;
    }
}
