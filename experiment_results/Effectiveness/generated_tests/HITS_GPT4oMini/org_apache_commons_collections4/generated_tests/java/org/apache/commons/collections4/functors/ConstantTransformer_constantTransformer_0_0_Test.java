package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class ConstantTransformer_constantTransformer_0_0_Test {

    @Test
    public void testConstantTransformerWithNonNullValue() {
        String constantValue = "TestValue";
        Transformer<Object, String> transformer = ConstantTransformer.constantTransformer(constantValue);
        // Test if it returns the constant value
        assertEquals(constantValue, transformer.transform(null));
    }

    @Test
    public void testConstantTransformerWithNullValue() {
        Transformer<Object, Object> transformer = ConstantTransformer.constantTransformer(null);
        // Test if it returns null transformer
        assertNull(transformer);
    }

    @Test
    public void testConstantTransformerWithIntegerValue() {
        Integer constantValue = 42;
        Transformer<Object, Integer> transformer = ConstantTransformer.constantTransformer(constantValue);
        // Test if it returns the constant integer value
        assertEquals(constantValue, transformer.transform(null));
    }

    @Test
    public void testConstantTransformerWithBooleanValue() {
        Boolean constantValue = true;
        Transformer<Object, Boolean> transformer = ConstantTransformer.constantTransformer(constantValue);
        // Test if it returns the constant boolean value
        assertEquals(constantValue, transformer.transform(null));
    }

    @Test
    public void testConstantTransformerWithCustomObject() {
        CustomObject constantValue = new CustomObject("Custom");
        Transformer<Object, CustomObject> transformer = ConstantTransformer.constantTransformer(constantValue);
        // Test if it returns the constant custom object
        assertEquals(constantValue, transformer.transform(null));
    }

    // Custom class for testing purposes
    private static class CustomObject {

        private String name;

        public CustomObject(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            CustomObject that = (CustomObject) obj;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
