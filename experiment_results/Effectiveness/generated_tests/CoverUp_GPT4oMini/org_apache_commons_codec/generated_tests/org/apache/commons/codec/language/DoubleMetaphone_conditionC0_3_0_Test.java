package org.apache.commons.codec.language;

import org.apache.commons.codec.language.DoubleMetaphone;
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

class DoubleMetaphone_conditionC0_3_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    @Test
    void testConditionC0_ContainsCHIA() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(doubleMetaphone, "SOMETHINGCHIA", 10));
    }

    @Test
    void testConditionC0_IndexLessThanOrEqualTo1() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(doubleMetaphone, "ACH", 1));
    }

    @Test
    void testConditionC0_IsVowel() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // 'A' is a vowel
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACH", 3));
    }

    @Test
    void testConditionC0_NotContainsACH() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // Does not contain "ACH" at index 2
        assertFalse((Boolean) method.invoke(doubleMetaphone, "BACHER", 3));
    }

    @Test
    void testConditionC0_CNotIorE() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // 'C' is not 'I' or 'E'
        assertTrue((Boolean) method.invoke(doubleMetaphone, "MACHER", 3));
    }

    @Test
    void testConditionC0_CContainsBACHER() throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("conditionC0", String.class, int.class);
        method.setAccessible(true);
        // Contains "BACHER"
        assertTrue((Boolean) method.invoke(doubleMetaphone, "BACHER", 3));
    }
}
