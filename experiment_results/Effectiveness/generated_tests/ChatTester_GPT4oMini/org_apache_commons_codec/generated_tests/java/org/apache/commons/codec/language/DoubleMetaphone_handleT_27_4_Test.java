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

class DoubleMetaphone_handleT_27_4_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new DoubleMetaphoneResult();
    }

    @Test
    void testHandleT_TION() throws Exception {
        invokeHandleT("MOTION", 0);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleT_TIA() throws Exception {
        invokeHandleT("MATERIAL", 0);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleT_TCH() throws Exception {
        invokeHandleT("MATCH", 0);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleT_TH_OM() throws Exception {
        invokeHandleT("THOMAS", 0);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleT_TH_AM() throws Exception {
        invokeHandleT("THAMES", 0);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleT_TH_SCH() throws Exception {
        invokeHandleT("SCHOOL", 0);
        assertEquals("0T", result.toString());
    }

    @Test
    void testHandleT_D() throws Exception {
        invokeHandleT("DAD", 0);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleT_T() throws Exception {
        invokeHandleT("TIGER", 0);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleT_Regular_T() throws Exception {
        invokeHandleT("TEST", 0);
        assertEquals("T", result.toString());
    }

    @Test
    void testHandleT_Double_T() throws Exception {
        invokeHandleT("TAT", 0);
        assertEquals("T", result.toString());
    }

    private void invokeHandleT(String value, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleT", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        method.invoke(doubleMetaphone, value, result, index);
    }

    // Mock class for DoubleMetaphoneResult
    static class DoubleMetaphoneResult {

        private StringBuilder stringBuilder = new StringBuilder();

        void append(char... chars) {
            for (char c : chars) {
                stringBuilder.append(c);
            }
        }

        @Override
        public String toString() {
            return stringBuilder.toString();
        }
    }
}
