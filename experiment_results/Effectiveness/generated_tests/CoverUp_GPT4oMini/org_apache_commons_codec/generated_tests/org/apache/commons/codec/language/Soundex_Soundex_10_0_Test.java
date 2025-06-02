package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.StringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Soundex_Soundex_10_0_Test {

    @Test
    public void testSoundexConstructorWithValidMapping() {
        Soundex soundex = new Soundex("01230120022455012623010202");
        assertNotNull(soundex);
    }

    @Test
    public void testSoundexConstructorWithEmptyMapping() {
        Soundex soundex = new Soundex("");
        assertNotNull(soundex);
    }

    @Test
    public void testSoundexConstructorWithNullMapping() {
        assertThrows(NullPointerException.class, () -> {
            new Soundex((String) null);
        });
    }

    @Test
    public void testGetMaxLength() {
        Soundex soundex = new Soundex("01230120022455012623010202");
        assertEquals(4, soundex.getMaxLength());
    }

    @Test
    public void testSetMaxLength() {
        Soundex soundex = new Soundex("01230120022455012623010202");
        soundex.setMaxLength(6);
        assertEquals(6, soundex.getMaxLength());
    }

    @Test
    public void testHasMarker() throws Exception {
        Method method = Soundex.class.getDeclaredMethod("hasMarker", char[].class);
        method.setAccessible(true);
        // Test with a mapping that has a marker
        char[] mappingWithMarker = { '0', '1', '2', Soundex.SILENT_MARKER, '2' };
        boolean resultWithMarker = (boolean) method.invoke(new Soundex("01230120022455012623010202"), (Object) mappingWithMarker);
        assertTrue(resultWithMarker);
        // Test with a mapping that does not have a marker
        char[] mappingWithoutMarker = { '0', '1', '2', '2' };
        boolean resultWithoutMarker = (boolean) method.invoke(new Soundex("01230120022455012623010202"), (Object) mappingWithoutMarker);
        assertFalse(resultWithoutMarker);
    }
}
