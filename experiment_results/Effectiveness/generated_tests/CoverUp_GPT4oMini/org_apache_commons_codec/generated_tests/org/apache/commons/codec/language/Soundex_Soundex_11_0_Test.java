package org.apache.commons.codec.language;

import org.apache.commons.codec.language.Soundex;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_11_0_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        soundex = new Soundex("01230120022455012623010202", true);
    }

    @Test
    public void testSoundexWithValidInputAndSpecialCase() throws Exception {
        String input = "Robert";
        boolean specialCaseHW = true;
        String expected = invokeSoundexMethod(input, specialCaseHW);
        assertEquals("R163", expected);
    }

    @Test
    public void testSoundexWithValidInputWithoutSpecialCase() throws Exception {
        String input = "Robert";
        boolean specialCaseHW = false;
        String expected = invokeSoundexMethod(input, specialCaseHW);
        assertEquals("R163", expected);
    }

    @Test
    public void testSoundexWithEmptyInput() throws Exception {
        String input = "";
        boolean specialCaseHW = true;
        String expected = invokeSoundexMethod(input, specialCaseHW);
        assertEquals("", expected);
    }

    @Test
    public void testSoundexWithNullInput() throws Exception {
        String input = null;
        boolean specialCaseHW = true;
        String expected = invokeSoundexMethod(input, specialCaseHW);
        assertEquals("", expected);
    }

    @Test
    public void testSoundexWithSpecialCharacters() throws Exception {
        String input = "O'Connor";
        boolean specialCaseHW = true;
        String expected = invokeSoundexMethod(input, specialCaseHW);
        assertEquals("O252", expected);
    }

    private String invokeSoundexMethod(String input, boolean specialCaseHW) throws Exception {
        Method method = Soundex.class.getDeclaredMethod("Soundex", String.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(soundex, input, specialCaseHW);
    }
}
