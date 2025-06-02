package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder_removeVowels_10_0_Test {

    private MatchRatingApproachEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = new MatchRatingApproachEncoder();
    }

    @Test
    public void testRemoveVowels_WithVowelFirstLetter() throws Exception {
        String input = "Apple";
        String expected = "Apple";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithConsonantFirstLetter() throws Exception {
        String input = "Banana";
        String expected = "Bnn";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithAllVowels() throws Exception {
        String input = "AEIOU";
        String expected = "AEIOU";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithEmptyString() throws Exception {
        String input = "";
        String expected = "";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithSpaces() throws Exception {
        String input = " A B C D ";
        String expected = " B C D ";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithMultipleSpaces() throws Exception {
        String input = "A  B  C  D";
        String expected = " B C D";
        String result = invokeRemoveVowels(input);
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveVowels_WithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeRemoveVowels(null);
        });
    }

    private String invokeRemoveVowels(String name) throws Exception {
        Method method = MatchRatingApproachEncoder.class.getDeclaredMethod("removeVowels", String.class);
        method.setAccessible(true);
        return (String) method.invoke(encoder, name);
    }
}
