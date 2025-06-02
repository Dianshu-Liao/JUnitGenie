package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class DoubleMetaphone_handleZ_30_2_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new DoubleMetaphoneResult();
    }

    @Test
    void testHandleZ_WithH() throws Exception {
        String value = "Zhao";
        int index = 0;
        boolean slavoGermanic = false;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);
        assertEquals(2, newIndex);
        assertEquals("J", result.toString());
    }

    @Test
    void testHandleZ_WithSlavoGermanic() throws Exception {
        String value = "Zebra";
        int index = 0;
        boolean slavoGermanic = true;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    @Test
    void testHandleZ_WithoutHOrSlavoGermanic() throws Exception {
        String value = "Zigzag";
        int index = 0;
        boolean slavoGermanic = false;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    @Test
    void testHandleZ_CharAtOutOfBounds() throws Exception {
        String value = "Z";
        int index = 0;
        boolean slavoGermanic = false;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphoneResult.class, int.class, boolean.class);
        method.setAccessible(true);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            method.invoke(doubleMetaphone, value, result, index, slavoGermanic);
        });
    }
}

// Assuming this is the DoubleMetaphoneResult class
class DoubleMetaphoneResult {

    private StringBuilder result = new StringBuilder();

    public void append(char c) {
        result.append(c);
    }

    public void append(String... strings) {
        for (String str : strings) {
            result.append(str);
        }
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
