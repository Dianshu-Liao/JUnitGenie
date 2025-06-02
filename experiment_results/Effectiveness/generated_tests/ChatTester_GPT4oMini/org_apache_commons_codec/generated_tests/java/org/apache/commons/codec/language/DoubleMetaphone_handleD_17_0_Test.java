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

class DoubleMetaphone_handleD_17_0_Test {

    @Test
    void testHandleD_withDGAndVowel() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "EDGING", result, 0);
        assertEquals(3, index);
        assertEquals("J", result.toString());
    }

    @Test
    void testHandleD_withDGAndNoVowel() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "DOG", result, 0);
        assertEquals(2, index);
        assertEquals("TK", result.toString());
    }

    @Test
    void testHandleD_withDT() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "ADDITIONAL", result, 0);
        assertEquals(2, index);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleD_withDefault() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "DOME", result, 0);
        assertEquals(1, index);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleD_withDD() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "EDDIE", result, 0);
        assertEquals(2, index);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleD_withEdgeCase() throws Exception {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        DoubleMetaphoneResult result = new DoubleMetaphoneResult();
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleD", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int index = (int) method.invoke(doubleMetaphone, "EDGAR", result, 0);
        assertEquals(3, index);
        assertEquals("J", result.toString());
    }
}

