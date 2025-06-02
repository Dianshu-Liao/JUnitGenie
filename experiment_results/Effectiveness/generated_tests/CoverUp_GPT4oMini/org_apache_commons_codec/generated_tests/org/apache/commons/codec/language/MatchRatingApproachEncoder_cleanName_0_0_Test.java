package org.apache.commons.codec.language;

import org.apache.commons.codec.language.MatchRatingApproachEncoder;
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

public class MatchRatingApproachEncoder_cleanName_0_0_Test {

    private final MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

    @Test
    public void testCleanNameWithNormalInput() throws Exception {
        String name = "John Doe";
        String expected = "JOHNDOE";
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanNameWithSpecialCharacters() throws Exception {
        // Special characters
        String name = "J@ne-Doe!";
        String expected = "JANEDOE";
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanNameWithAccents() throws Exception {
        // Accents
        String name = "Jérôme D'Ambrosio";
        String expected = "JEROMEDAMBROSIO";
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanNameWithMultipleSpaces() throws Exception {
        // Multiple spaces
        String name = "   John    Doe   ";
        String expected = "JOHNDOE";
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanNameWithEmptyString() throws Exception {
        // Empty string
        String name = "";
        String expected = "";
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanNameWithNull() throws Exception {
        // Null input
        String name = null;
        // Expected to return null
        String expected = null;
        String actual = invokeCleanName(name);
        assertEquals(expected, actual);
    }

    private String invokeCleanName(String name) throws Exception {
        Method method = MatchRatingApproachEncoder.class.getDeclaredMethod("cleanName", String.class);
        method.setAccessible(true);
        return (String) method.invoke(encoder, name);
    }
}
