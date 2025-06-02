package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class MatchRatingApproachEncoder_cleanName_0_0_Test {

    private MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testCleanName_WithHyphensAndSpaces() throws Exception {
        String input = "Jean-Paul Sartre";
        String expected = "JEANPAULSARTRE";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithSpecialCharacters() throws Exception {
        String input = "O'Brien, the best!";
        String expected = "OBRIENTHEBEST";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithAccents() throws Exception {
        String input = "Émilie";
        String expected = "EMILIE";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithMultipleSpaces() throws Exception {
        String input = "   John   Doe   ";
        String expected = "JOHNDOE";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithEmptyString() throws Exception {
        String input = "";
        String expected = "";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithDoubleConsonants() throws Exception {
        String input = "Bobby";
        String expected = "BOBBY";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanName_WithTrailingAndLeadingSpaces() throws Exception {
        String input = "  Alice  ";
        String expected = "ALICE";
        String result = invokeCleanName(input);
        assertEquals(expected, result);
    }

    private String invokeCleanName(String name) throws Exception {
        Method method = MatchRatingApproachEncoder.class.getDeclaredMethod("cleanName", String.class);
        method.setAccessible(true);
        return (String) method.invoke(encoder, name);
    }
}
