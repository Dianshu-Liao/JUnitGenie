package org.apache.commons.codec.language;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_10_0_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        // Use the predefined US_ENGLISH instance
        soundex = Soundex.US_ENGLISH;
    }

    @Test
    public void testSoundexInitialization() {
        assertNotNull(soundex, "Soundex object should be initialized");
    }

    @Test
    public void testSoundexMapping() throws NoSuchFieldException, IllegalAccessException {
        // Use the mapping string
        char[] expectedMapping = Soundex.US_ENGLISH_MAPPING_STRING.toCharArray();
        Field mappingField = Soundex.class.getDeclaredField("soundexMapping");
        mappingField.setAccessible(true);
        char[] actualMapping = (char[]) mappingField.get(soundex);
        assertArrayEquals(expectedMapping, actualMapping, "Soundex mapping should match the default US_ENGLISH_MAPPING");
    }

    @Test
    public void testSoundexSpecialCaseHW() throws NoSuchFieldException, IllegalAccessException {
        boolean expectedSpecialCaseHW = true;
        Field specialCaseHWField = Soundex.class.getDeclaredField("specialCaseHW");
        specialCaseHWField.setAccessible(true);
        boolean actualSpecialCaseHW = (boolean) specialCaseHWField.get(soundex);
        assertTrue(actualSpecialCaseHW, "Special case HW should be true for default initialization");
    }
}
