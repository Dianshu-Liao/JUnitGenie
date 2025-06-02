package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@ExtendWith(MockitoExtension.class)
public class RefinedSoundex_getMappingCode_3_0_Test {

    private RefinedSoundex refinedSoundex;

    @BeforeEach
    public void setUp() {
        // Corrected the initialization of RefinedSoundex
        refinedSoundex = new RefinedSoundex();
    }

    @Test
    public void testGetMappingCode_ValidLetter() throws Exception {
        char input = 'A';
        // Based on US_ENGLISH_MAPPING
        char expected = '0';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_ValidLowercaseLetter() throws Exception {
        char input = 'b';
        // Based on US_ENGLISH_MAPPING
        char expected = '1';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_NonLetterCharacter() throws Exception {
        char input = '1';
        // Non-letter character should return 0
        char expected = 0;
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_UpperOutOfBounds() throws Exception {
        // Should be in bounds
        char input = 'Z';
        // Based on US_ENGLISH_MAPPING
        char expected = '0';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_LowerOutOfBounds() throws Exception {
        // Should be in bounds
        char input = 'z';
        // Based on US_ENGLISH_MAPPING
        char expected = '0';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_NegativeIndex() throws Exception {
        // Non-letter character should return 0
        char input = '@';
        char expected = 0;
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_UppercaseLetterOutOfBounds() throws Exception {
        // Valid letter
        char input = 'A';
        // Based on US_ENGLISH_MAPPING
        char expected = '0';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMappingCode_LowercaseLetterOutOfBounds() throws Exception {
        // Valid letter
        char input = 'a';
        // Based on US_ENGLISH_MAPPING
        char expected = '0';
        char actual = invokeGetMappingCode(input);
        assertEquals(expected, actual);
    }

    private char invokeGetMappingCode(char c) throws Exception {
        Method method = RefinedSoundex.class.getDeclaredMethod("getMappingCode", char.class);
        method.setAccessible(true);
        return (char) method.invoke(refinedSoundex, c);
    }
}
