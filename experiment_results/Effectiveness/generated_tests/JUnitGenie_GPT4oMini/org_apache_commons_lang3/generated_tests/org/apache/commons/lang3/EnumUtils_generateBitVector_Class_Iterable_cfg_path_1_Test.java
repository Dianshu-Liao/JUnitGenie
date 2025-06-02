package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class EnumUtils_generateBitVector_Class_Iterable_cfg_path_1_Test {

    private enum TestEnum {
        VALUE_ONE,
        VALUE_TWO,
        VALUE_THREE
    }

    @Test(timeout = 4000)
    public void testGenerateBitVector_withValidEnumAndValues() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Arrays.asList(TestEnum.VALUE_ONE, TestEnum.VALUE_TWO);
        
        long result = EnumUtils.generateBitVector(enumClass, values);
        
        // Expected bit vector for VALUE_ONE (1) and VALUE_TWO (2) is 3 (binary 11)
        assertEquals(3L, result);
    }

    @Test(timeout = 4000)
    public void testGenerateBitVector_withEmptyValues() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Collections.emptyList();
        
        long result = EnumUtils.generateBitVector(enumClass, values);
        
        // Expected bit vector for no values is 0
        assertEquals(0L, result);
    }

    @Test(timeout = 4000)
    public void testGenerateBitVector_withNullValues() {
        Class<TestEnum> enumClass = TestEnum.class;
        
        try {
            // Cast null to Iterable<TestEnum> to resolve ambiguity
            EnumUtils.generateBitVector(enumClass, (Iterable<TestEnum>) null);
        } catch (NullPointerException e) {
            assertEquals("values", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGenerateBitVector_withNullElementInValues() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Arrays.asList(TestEnum.VALUE_ONE, null);
        
        try {
            EnumUtils.generateBitVector(enumClass, values);
        } catch (NullPointerException e) {
            assertEquals("null elements not permitted", e.getMessage());
        }
    }


}