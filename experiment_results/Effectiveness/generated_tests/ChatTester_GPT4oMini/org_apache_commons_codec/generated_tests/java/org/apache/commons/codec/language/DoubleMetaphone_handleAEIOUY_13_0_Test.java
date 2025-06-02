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

public class DoubleMetaphone_handleAEIOUY_13_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new DoubleMetaphoneResult();
    }

    @Test
    public void testHandleAEIOUY_AtIndexZero() throws Exception {
        // Invoke the private method handleAEIOUY with index 0
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleAEIOUY", DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, result, 0);
        // Verify that the result contains 'A' and the index is incremented
        assertEquals("A", result.toString());
        assertEquals(1, newIndex);
    }

    @Test
    public void testHandleAEIOUY_AtIndexOne() throws Exception {
        // Invoke the private method handleAEIOUY with index 1
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleAEIOUY", DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, result, 1);
        // Verify that the result is unchanged and the index is incremented
        assertEquals("", result.toString());
        assertEquals(2, newIndex);
    }
}

