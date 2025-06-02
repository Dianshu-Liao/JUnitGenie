package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.Resources;
import org.apache.commons.codec.StringEncoder;

public class DaitchMokotoffSoundex_cleanup_2_0_Test {

    private DaitchMokotoffSoundex soundex;

    private Method cleanupMethod;

    @BeforeEach
    public void setUp() throws Exception {
        soundex = new DaitchMokotoffSoundex();
        cleanupMethod = DaitchMokotoffSoundex.class.getDeclaredMethod("cleanup", String.class);
        // Allow access to the private method
        cleanupMethod.setAccessible(true);
    }

    private String invokeCleanup(String input) throws Exception {
        return (String) cleanupMethod.invoke(soundex, input);
    }

    @Test
    public void testCleanup_WithLeadingWhitespace() throws Exception {
        String input = "   hello";
        String expected = "hello";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanup_WithTrailingWhitespace() throws Exception {
        String input = "hello   ";
        String expected = "hello";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanup_WithWhitespaceInBetween() throws Exception {
        String input = "he llo";
        String expected = "hello";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanup_WithOnlyWhitespace() throws Exception {
        String input = "     ";
        String expected = "";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanup_WithNoWhitespace() throws Exception {
        String input = "hello";
        String expected = "hello";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }

    @Test
    public void testCleanup_WithMixedWhitespace() throws Exception {
        String input = "  h e l l o  ";
        String expected = "hello";
        String result = invokeCleanup(input);
        assertEquals(expected, result);
    }
}
