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

    @BeforeEach
    public void setUp() {
        soundex = new DaitchMokotoffSoundex(false);
    }

    @Test
    public void testCleanup_WithWhitespace() throws Exception {
        String input = "  Hello World  ";
        String expected = "helloworld";
        String actual = invokeCleanup(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanup_WithFoldingEnabled() throws Exception {
        soundex = new DaitchMokotoffSoundex(true);
        // Assuming FOLDINGS map is populated with some values for testing
        // Example: FOLDINGS.put('h', 'H');
        String input = "Hello";
        String expected = "H";
        String actual = invokeCleanup(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanup_EmptyInput() throws Exception {
        String input = "";
        String expected = "";
        String actual = invokeCleanup(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCleanup_NullInput() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            invokeCleanup(null);
        });
    }

    private String invokeCleanup(String input) throws Exception {
        Method method = DaitchMokotoffSoundex.class.getDeclaredMethod("cleanup", String.class);
        method.setAccessible(true);
        return (String) method.invoke(soundex, input);
    }
}
