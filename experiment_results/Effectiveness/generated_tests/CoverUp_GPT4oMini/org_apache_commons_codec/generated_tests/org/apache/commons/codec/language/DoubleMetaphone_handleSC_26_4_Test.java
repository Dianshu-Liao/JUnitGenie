package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class DoubleMetaphone_handleSC_26_4_Test {

    private DoubleMetaphone doubleMetaphone;

    private TestDoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new TestDoubleMetaphoneResult();
    }

    @Test
    void testHandleSCWithHAtIndex2AndDutchOrigin() throws Exception {
        invokeHandleSC("school", result, 0);
        assertEquals("X", result.getPrimary());
    }

    @Test
    void testHandleSCWithHAtIndex2AndNoDutchOrigin() throws Exception {
        invokeHandleSC("schooner", result, 0);
        assertEquals("SK", result.getPrimary());
    }

    @Test
    void testHandleSCWithVowelAtIndex2() throws Exception {
        invokeHandleSC("sci", result, 0);
        assertEquals("S", result.getPrimary());
    }

    @Test
    void testHandleSCWithNoConditionsMet() throws Exception {
        invokeHandleSC("sc", result, 0);
        assertEquals("SK", result.getPrimary());
    }

    private void invokeHandleSC(String value, TestDoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleSC", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        method.invoke(doubleMetaphone, value, result, index);
    }

    private static class TestDoubleMetaphoneResult extends DoubleMetaphoneResult {

        private String primary;

        @Override
        public void append(String primary, String secondary) {
            this.primary = primary;
        }

        @Override
        public void append(String value) {
            this.primary = value;
        }

        public String getPrimary() {
            return primary;
        }
    }

    // Assuming DoubleMetaphoneResult is defined somewhere in the package
    private static class DoubleMetaphoneResult {

        public void append(String primary, String secondary) {
            // Implementation not shown
        }

        public void append(String value) {
            // Implementation not shown
        }
    }
}
