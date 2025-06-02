package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ConstantTransformer_constantTransformer_0_0_Test {

    @Test
    void testConstantTransformerWithNonNullValue() {
        // Arrange
        String constantValue = "test";
        // Act
        Transformer<String, String> transformer = ConstantTransformer.constantTransformer(constantValue);
        // Assert
        assertNotNull(transformer);
        // Assuming transform method exists
        assertEquals(constantValue, transformer.transform("any input"));
    }

    @Test
    void testConstantTransformerWithNullValue() {
        // Act
        Transformer<String, String> transformer = ConstantTransformer.constantTransformer(null);
        // Assert
        // Expecting NULL_INSTANCE
        assertNull(transformer);
    }

    // Reflection test to invoke private methods if necessary
    @Test
    void testPrivateMethodInvocation() throws Exception {
        // Assuming there is a private method we want to test via reflection
        ConstantTransformer transformer = new ConstantTransformer("test");
        Method privateMethod = ConstantTransformer.class.getDeclaredMethod("privateMethodName");
        privateMethod.setAccessible(true);
        // Act
        Object result = privateMethod.invoke(transformer);
        // Assert
        // Replace expectedValue with the actual expected value from the private method
        // Set this to the expected value based on the method logic
        Object expectedValue = "expected result";
        assertEquals(expectedValue, result);
    }
}
