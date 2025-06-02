package org.apache.commons.codec.language;

import org.apache.commons.codec.language.DoubleMetaphone;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class DoubleMetaphone_encode_11_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    public void testEncodeWithValidInput() {
        String input = "Smith";
        // Replace with the expected output
        String expectedOutput = invokeDoubleMetaphone(input);
        String actualOutput = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithEmptyString() {
        String input = "";
        // Replace with the expected output
        String expectedOutput = invokeDoubleMetaphone(input);
        String actualOutput = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithNull() {
        String input = null;
        assertThrows(NullPointerException.class, () -> doubleMetaphone.encode(input));
    }

    @Test
    public void testEncodeWithVowels() {
        String input = "Aero";
        // Replace with the expected output
        String expectedOutput = invokeDoubleMetaphone(input);
        String actualOutput = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithSilentStart() {
        String input = "Knight";
        // Replace with the expected output
        String expectedOutput = invokeDoubleMetaphone(input);
        String actualOutput = doubleMetaphone.encode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    private String invokeDoubleMetaphone(String value) {
        try {
            Method method = DoubleMetaphone.class.getDeclaredMethod("doubleMetaphone", String.class, boolean.class);
            method.setAccessible(true);
            return (String) method.invoke(doubleMetaphone, value, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
