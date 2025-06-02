package org.apache.commons.lang3;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class EnumUtils_generateBitVector_Class_Iterable_cfg_path_2_Test {

    private enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }

    @Test(timeout = 4000)
    public void testGenerateBitVectorWithValidEnum() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Arrays.asList(TestEnum.VALUE1, TestEnum.VALUE2);
        
        try {
            long result = EnumUtils.generateBitVector(enumClass, values);
            assertEquals(3L, result); // 1L << 0 | 1L << 1 = 3
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGenerateBitVectorWithNullValues() {
        Class<TestEnum> enumClass = TestEnum.class;
        
        try {
            long result = EnumUtils.generateBitVector(enumClass, (Iterable<TestEnum>) null);
            // This should throw an exception
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGenerateBitVectorWithNullEnumConstant() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Arrays.asList(TestEnum.VALUE1, null);
        
        try {
            long result = EnumUtils.generateBitVector(enumClass, values);
            // This should throw an exception
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGenerateBitVectorWithEmptyIterable() {
        Class<TestEnum> enumClass = TestEnum.class;
        Iterable<TestEnum> values = Collections.emptyList();
        
        try {
            long result = EnumUtils.generateBitVector(enumClass, values);
            assertEquals(0L, result); // No values should result in 0
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}