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

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testRemoveVowels_WithVowelFirstLetter() throws Exception {
        String input = "Alice";
        String expected = "Alic";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithConsonantFirstLetter() throws Exception {
        String input = "Bob";
        String expected = "Bb";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithMultipleVowels() throws Exception {
        String input = "Eleanor";
        String expected = "Elnr";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithSpaces() throws Exception {
        String input = "  O  U  ";
        String expected = "  ";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithEmptyString() throws Exception {
        String input = "";
        String expected = "";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithNoVowels() throws Exception {
        String input = "Rhythm";
        String expected = "Rhythm";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVowels_WithLeadingAndTrailingSpaces() throws Exception {
        String input = "  A  B  C  ";
        String expected = "  B C  ";
        String actual = invokeRemoveVowels(input);
        assertEquals(expected, actual);
    }

    private String invokeRemoveVowels(String name) throws Exception {
        Method method = MatchRatingApproachEncoder.class.getDeclaredMethod("removeVowels", String.class);
        method.setAccessible(true);
        return (String) method.invoke(encoder, name);
    }
}
