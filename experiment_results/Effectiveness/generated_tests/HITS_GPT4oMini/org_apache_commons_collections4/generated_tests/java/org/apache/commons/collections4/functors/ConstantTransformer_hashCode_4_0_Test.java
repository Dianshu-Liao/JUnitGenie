package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

public class ConstantTransformer_hashCode_4_0_Test {

    @Test
    public void testHashCodeWithNullConstant() {
        ConstantTransformer<String, String> transformer = new ConstantTransformer<>(null);
        int expectedHashCode = "ConstantTransformer".hashCode() << 2;
        assertEquals(expectedHashCode, transformer.hashCode());
    }

    @Test
    public void testHashCodeWithNonNullConstant() {
        String constantValue = "TestConstant";
        ConstantTransformer<String, String> transformer = new ConstantTransformer<>(constantValue);
        int expectedHashCode = ("ConstantTransformer".hashCode() << 2) | constantValue.hashCode();
        assertEquals(expectedHashCode, transformer.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentNonNullConstant() {
        String constantValue = "AnotherConstant";
        ConstantTransformer<String, String> transformer = new ConstantTransformer<>(constantValue);
        int expectedHashCode = ("ConstantTransformer".hashCode() << 2) | constantValue.hashCode();
        assertEquals(expectedHashCode, transformer.hashCode());
    }

    @Test
    public void testHashCodeWithSameConstant() {
        String constantValue = "SameConstant";
        ConstantTransformer<String, String> transformer1 = new ConstantTransformer<>(constantValue);
        ConstantTransformer<String, String> transformer2 = new ConstantTransformer<>(constantValue);
        assertEquals(transformer1.hashCode(), transformer2.hashCode());
    }
}
